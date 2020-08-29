import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthenticationService {

  constructor() { }

  authenticate(username,password){
    // console.log('Before authentication : UserLogged In ' + this.isUserLoggedIn()  )
    if(username === 'Niket' && password ==='dummy'){
      sessionStorage.setItem('authenticatedUser' , username)
      // console.log('After authentication : UserLogged In ' + this.isUserLoggedIn()  )
      return true
    }
      return false
  }
  isUserLoggedIn(){
    let user = sessionStorage.getItem('authenticatedUser')
    return !(user=== null)
  }
  
  logout(){
    sessionStorage.removeItem('authenticatedUser')
  }
}
