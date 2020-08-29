import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import {map} from 'rxjs/operators';
import { UrlSerializer } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class BasicAuthenticationService {

  constructor(
    private http:HttpClient
  ) { }

  executeAuthenticationService(username: any,password: any){
    let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);
    

    let headers = new HttpHeaders({
        Authorization: basicAuthHeaderString
      })

    return this.http.get<AuthenticationBean>(`/api/basicauth`,
     {headers}).pipe(
       map(
         data => {
          sessionStorage.setItem('authenticatedUser' , username)
          sessionStorage.setItem('token' , basicAuthHeaderString)
          return data
         }
       )
     )
  }

  executeJWTAuthenticationService(username: any,password: any){
   
    return this.http.post<any>(`/api/authenticate`,{
      username,
      password
    }).pipe(
       map(
         data => {
          sessionStorage.setItem('authenticatedUser' , username)
          sessionStorage.setItem('token' , `Bearer ${data.token}`)
          return data
         }
       )
     )
  }

  getAuthenticatedUser(){
    return sessionStorage.getItem('authenticatedUser')
  }
  getAuthenticatedToken(){
    if(this.getAuthenticatedUser())
    return sessionStorage.getItem('token')
  }

  isUserLoggedIn(){
    let user = sessionStorage.getItem('authenticatedUser')
    return !(user=== null)
  }
  
   
  logout(){
    sessionStorage.removeItem('authenticatedUser')
    sessionStorage.removeItem('token')
  }

  // createBasicAuthenticationHttpHeader() {
  //   let username = 'in28minutes'
  //   let password = 'dummy'
  //   let basicAuthHeaderString = 'Basic ' + window.btoa(username + ':' + password);
  //   return basicAuthHeaderString;
  // }

}

export class AuthenticationBean{ 
  constructor(
    public message : String
  ) { }
}
