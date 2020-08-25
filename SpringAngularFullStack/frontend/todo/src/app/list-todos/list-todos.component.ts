import { Component, OnInit } from '@angular/core';
import { TodoDataService } from './../service/data/todo-data.service';
import { Router } from '@angular/router';

export class Todo{

  constructor(
    public id : number,
    public description : String,
    public done : boolean,
    public targetDate : Date
  ){

  }
}



@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos : Todo[]
  
  message : String

  nameSearch : String = ''

  // [
  //   new Todo(1, 'Love to code', false , new Date()),
  //   new Todo(2, 'Dream to dance', true , new Date()),
  //   new Todo(3, 'Visit US', false , new Date()),
  //   new Todo(4,  'Learn to cook', false , new Date())

  //   // { id : 1 , description : 'Love to code'},
  //   // { id : 2 , description : 'Dream to dance'},
  //   // { id : 3, description : 'Visit US'},
  //   // { id : 4 , description : 'Learn to cook'},
  // ]

  // todo = { id : 1 , description : 'Love to code'}

  constructor(
    private todoDataService : TodoDataService,
    private router : Router
  ) { }

  ngOnInit(): void {
    this.refreshTodos();
  }

  handleSuccessfulResponseforTodos(response){
    console.log(response);
    this.todos = response;
  }

  refreshTodos(){
    this.todoDataService.retrieveAllTodos("in28minutes").subscribe(
      response => this.handleSuccessfulResponseforTodos(response),
    )
  }

  deleteTodo(id){
    // console.log( `delete Todo ${id}`)
    this.todoDataService.deleteTodo('in28minutes',id).subscribe(
      response => {
        console.log(response)
        this.message = ` Todo with Id: ${id} is been succesfully deleted!!!`
        this.refreshTodos();
      }
    )
  }

  updateTodo(id){
    console.log( `update Todo ${id}`)
    this.router.navigate(['todos',id])
  }

  addTodo(){
    this.router.navigate(['todos',-1])
  }

}
