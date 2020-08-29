import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { AddressComponent } from './address/address.component';
import { ErrorComponent } from './error/error.component';
import { ListTodosComponent } from './list-todos/list-todos.component';
import { LogoutComponent } from './logout/logout.component';
import { RouteGuardService } from './service/route-guard.service';
import { TodoComponent } from './todo/todo.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'login', component: LoginComponent },
  { path: 'welcome', component: WelcomeComponent ,canActivate:[RouteGuardService] },
  { path: 'welcome/:name', component: WelcomeComponent , canActivate:[RouteGuardService] },
  { path: 'todos', component: ListTodosComponent , canActivate:[RouteGuardService]},
  { path: 'address', component: AddressComponent , canActivate:[RouteGuardService]},
  { path: 'todos/:id', component: TodoComponent , canActivate:[RouteGuardService] },
  { path: 'logout', component: LogoutComponent },
  { path: '**', component: ErrorComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }
