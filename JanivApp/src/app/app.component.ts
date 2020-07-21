import { Component, OnInit } from  '@angular/core';
import { ApiService } from  './api.service';
import { Item } from  './api.service';

import { AccountService } from './_services';
import { User } from './_models';

@Component({
selector:  'app-root',
templateUrl:  './app.component.html',
styleUrls: ['./app.component.css']
})
export  class  AppComponent  implements  OnInit{
    title  =  'Janiv';
    items:  Array<Item>;
    user: User;

    constructor(private  apiService:  ApiService, private accountService: AccountService){

        this.accountService.user.subscribe(x => this.user = x);
    }
    
    ngOnInit(){
        this.fetchData();
    }


    logout() {
        this.accountService.logout();
    }

    fetchData(){
        this.apiService.fetch().subscribe((data:  Array<Item>)=>{
        console.log(data);
        this.items  =  data;
        }, (err)=>{
        console.log(err);
    });
}
}
