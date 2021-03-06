import { Injectable } from  '@angular/core';
import { HttpClient } from  '@angular/common/http';
import { Observable } from  'rxjs';

export  interface  Item{

    userId:  string;
    id:  string;
    title:  string;
    body:  string;
}

@Injectable({
providedIn:  'root'
})

export  class  ApiService {
private  dataURL:  string  =  "https://jsonplaceholder.typicode.com/posts";
constructor(private  httpClient:  HttpClient) {}
fetch():  Observable<Item[]>{
return <Observable<Item[]>>this.httpClient.get(this.dataURL);
}
}
