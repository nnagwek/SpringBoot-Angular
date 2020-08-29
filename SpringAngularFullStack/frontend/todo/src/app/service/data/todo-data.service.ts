import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Todo } from './../../list-todos/list-todos.component';

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  constructor(
    private http: HttpClient
  ) { }

  retrieveAllTodos(username){
    return this.http.get<Todo[]>(`/api/jpa/users/${username}/todos`)
  }

  deleteTodo(username, id){
    return this.http.delete(`/api/jpa/users/${username}/todos/${id}`)
  }

  retrieveTodo(username, id){
     return this.http.get<Todo>(`/api/jpa/users/${username}/todos/${id}`)
  }

  updateTodo(username, id, todo){
    return this.http.put(`/api/jpa/users/${username}/todos/${id}` , todo)
 }

 createTodo(username, todo){
  return this.http.post(`/api/jpa/users/${username}/todos` , todo)
}
  // http://localhost:8080

}
