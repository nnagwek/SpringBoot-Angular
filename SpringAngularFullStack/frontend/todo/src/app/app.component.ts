import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  // template: '<h1>{{ title }}</h1>',
  styleUrls: ['./app.component.css']
  // styles: ['div{ background-color :  darkcyan}']
})
export class AppComponent {
  title = 'todo';
  message = 'Welcome Niket' ;
}
