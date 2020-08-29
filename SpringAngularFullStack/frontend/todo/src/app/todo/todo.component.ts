import { Component, OnInit } from '@angular/core';
import { TodoDataService } from './../service/data/todo-data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Todo } from './../list-todos/list-todos.component';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  id: number
  todo: Todo

  constructor(
    private todoDataService: TodoDataService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.activatedRouter.snapshot.params['id']
    this.todo = new Todo(this.id, "", false, new Date())

    if (this.id !=-1) {
      this.todoDataService.retrieveTodo('in28minutes', this.id).subscribe(
        data => this.todo = data
      )
    }
  }

  saveTodo() {
    if (this.id == -1) {
      console.log(this.id)
      this.todoDataService.createTodo('in28minutes',  this.todo).subscribe(
        data => {
          console.log(data)
          this.router.navigate(['/todos'])
        }
      )
    }
    else {
      console.log(this.id)
      this.todoDataService.updateTodo('in28minutes', this.id, this.todo).subscribe(
        data => {
          console.log(data)
          this.router.navigate(['/todos'])
        }
      )
    }
  }
}
