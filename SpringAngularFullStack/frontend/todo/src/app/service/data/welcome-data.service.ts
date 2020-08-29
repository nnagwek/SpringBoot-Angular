import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(
    private http:HttpClient
  ) { }

  executeHelloWorldService(){
    // this.http.get<any>('http://localhost:8080/api/hello-world-bean/')
    return this.http.get<HelloWorldBean>('/api/hello-world-bean')
    // console.log("executed Hello World Service");
  }

  executeHelloWorldServiceWithPathVariable(name){
    // let basicAuthHeaderString = this.createBasicAuthenticationHttpHeader();

    // let headers = new HttpHeaders({
    //     Authorization: basicAuthHeaderString
    //   })

    return this.http.get<HelloWorldBean>(`/api/hello-world-bean/path-variable/${name}`,
    //  {headers}
     )
  }

  
  
  // createBasicAuthenticationHttpHeader() {
  //   let username = 'in28minutes'
  //   let password = 'in28minutes'
  //   let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);
  //   return basicAuthHeaderString;
  // }
}

export class HelloWorldBean{ 
  constructor(
    public message : String
  ) { }
}



// Access to XMLHttpRequest at 'http://localhost:8080/login' (redirected from 'http://localhost:4200/api/hello-world-bean/path-variable/Niket') from origin 'http://localhost:4200' 
// has been blocked by CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource.