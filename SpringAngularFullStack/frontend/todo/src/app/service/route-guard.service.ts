import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { HardcodedAuthenticationService } from './hardcoded-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private hardCodedAuthentication: HardcodedAuthenticationService,
      private router : Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    console.log("Before Calling RoutGuard : " + this.hardCodedAuthentication.isUserLoggedIn())
    if (this.hardCodedAuthentication.isUserLoggedIn())
    {
      console.log("After Calling RoutGuard : " + this.hardCodedAuthentication.isUserLoggedIn())
      return true
    }
    this.router.navigate(['login'])
    return false
  }
}
