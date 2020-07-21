import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import {tap} from 'rxjs/operators';
import {shareReplay} from 'rxjs/operators';

import { environment } from '@environments/environment';
import { User } from '@app/_models';

import * as moment from 'moment';

@Injectable({ providedIn: 'root' })
export class AccountService {
    private userSubject: BehaviorSubject<User>;
    public user: Observable<User>;

    private loggedIn = new BehaviorSubject<boolean>(false);
    private token: string;
    
    constructor(
        private router: Router,
        private http: HttpClient
    ) {
        this.userSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('user')));
        this.user = this.userSubject.asObservable();
    }

    public get userValue(): User {
        return this.userSubject.value;
    }

    login(mobilenumber, password) {
        /* OLD Code without JWT
        return this.http.post<User>(`${environment.loginUrl}`, { mobilenumber, password })
            .pipe(map(user => {
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('user', JSON.stringify(user));
                this.userSubject.next(user);
                return user;
            }));

            */

           return this.http.post<User>(`${environment.loginUrl}`, { mobilenumber, password })
           .pipe(tap(res => this.setSession)) 
            //.shareReplay();
            
    }

    private setSession(authResult) {
        //const expiresAt = moment().add(authResult.expiresIn,'second');

        //localStorage.setItem('id_token', authResult.idToken);
        localStorage.setItem('Authorization', authResult.Authorization);
        //this.userSubject.next(user);
        
        //localStorage.setItem("expires_at", JSON.stringify(expiresAt.valueOf()) );
    }   

    logout() {
        // remove user from local storage and set current user to null
        //localStorage.removeItem("id_token");
        localStorage.removeItem("Authorization");
        //localStorage.removeItem("expires_at");

        this.userSubject.next(null);
        this.router.navigate(['/account/login']);
    }
    
    public isLoggedIn() {
        return moment().isBefore(this.getExpiration());
    }

    isLoggedOut() {
        return !this.isLoggedIn();
    }

    getExpiration() {
        
        //TODO: To implement expiration
        const expiration = localStorage.getItem("expires_at");
        const expiresAt = JSON.parse(expiration);
        
        return moment(expiresAt);
    }

    register(user: User) {
        return this.http.post(`${environment.apiUrl}/users/register`, user);
    }

    getAll() {
        return this.http.get<User[]>(`${environment.apiUrl}/users`);
    }

    getById(id: string) {
        return this.http.get<User>(`${environment.apiUrl}/users/${id}`);
    }

    update(id, params) {
        return this.http.put(`${environment.apiUrl}/users/update/${id}`, params)
            .pipe(map(x => {
                // update stored user if the logged in user updated their own record
                if (id == this.userValue.id) {
                    // update local storage
                    const user = { ...this.userValue, ...params };
                    localStorage.setItem('user', JSON.stringify(user));

                    // publish updated user to subscribers
                    this.userSubject.next(user);
                }
                return x;
            }));
    }

    delete(id: string) {
        return this.http.delete(`${environment.apiUrl}/users/${id}`)
            .pipe(map(x => {
                // auto logout if the logged in user deleted their own record
                if (id == this.userValue.id) {
                    this.logout();
                }
                return x;
            }));
    }
}