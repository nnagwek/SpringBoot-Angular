import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthenticationService }  from './../service/hardcoded-authentication.service'
import { BasicAuthenticationService } from './../service/basic-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = 'Niket' 
  password = 'password'
  errorMessage = 'Invalid Credentials'
  invalidCreds = false

  constructor( private router : Router,
    private hardcodedAuthenticationService: HardcodedAuthenticationService,
    private basicAuthenticationService: BasicAuthenticationService) { }

  ngOnInit(): void {
  }

  handleLogin(){

    if(this.hardcodedAuthenticationService.authenticate(this.username,this.password)){
      // Redirect to Welcome page
      this.router.navigate(['welcome',this.username])
      this.invalidCreds = false
    }
    else{
      this.invalidCreds = true
    }
   
  }
  handleBasicAuthLogin(){

    this.basicAuthenticationService.executeAuthenticationService(this.username,this.password)
        .subscribe(
          data => {
            console.log(data)
            this.router.navigate(['welcome',this.username])
            this.invalidCreds = false
          },
          error =>{
            console.log(error)
            this.invalidCreds = true
          }  
        )
  //    // Redirect to Welcome page
  //    this.router.navigate(['welcome',this.username])
  //    this.invalidCreds = false
  //  }
  //  else{
  //    this.invalidCreds = true
  //  }
  }

  handleJWTBasicAuthLogin(){

    this.basicAuthenticationService.executeJWTAuthenticationService(this.username,this.password)
        .subscribe(
          data => {
            console.log(data)
            this.router.navigate(['welcome',this.username])
            this.invalidCreds = false
          },
          error =>{
            console.log(error)
            this.invalidCreds = true
          }  
        )
  //    // Redirect to Welcome page
  //    this.router.navigate(['welcome',this.username])
  //    this.invalidCreds = false
  //  }
  //  else{
  //    this.invalidCreds = true
  //  }
  }

  redirectLogin(){
    this.router.navigate(['login'])
  }
}

