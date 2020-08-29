import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from './../service/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {
  message = 'Some welcome message'
  name = ""
  welcomeMessageFromService : String 
  welcomeErrorMessage : String
  welcomeName : String

  constructor( private router : ActivatedRoute ,
    private welcomeDataService :WelcomeDataService) { }

  ngOnInit(): void {
    console.log(this.message)
    console.log(this.router.snapshot.params['name'])
    this.name = this.router.snapshot.params['name']
  }

  getWelcomeMessage(){
    console.log(this.welcomeDataService.executeHelloWorldService().subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    ))
    // this.welcomeDataService.executeHelloWorldService().subscribe()
    // console.log("Hello- World")
  }

  handleSuccessfulResponse(response){
    this.welcomeMessageFromService = response.message 
    this.welcomeName= response.name
    // console.log(response)
    // console.log(response.message)
  }

  handleErrorResponse(error){
    this.welcomeErrorMessage = error.error.message
    
    console.log(error.error.message)
  }

  getWelcomeMessageWithPathVariable(){
    console.log(this.welcomeDataService.executeHelloWorldServiceWithPathVariable(this.name).subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    ))
  }

}
