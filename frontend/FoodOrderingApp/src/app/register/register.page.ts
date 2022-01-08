import { Component, OnInit } from '@angular/core';
import {Role} from "../dto/role";
import {RegisterDetails} from "../dto/register-details";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss'],
})
export class RegisterPage implements OnInit {

  roles = [Role.CLIENT.toString(),Role.RESTAURANT_OWNER.toString(),Role.DELIVERY_GUY.toString()];
  username:string;
  role:Role;
  email: string;
  password: string;
  confirm_password: string;
  registerData:RegisterDetails;

  constructor(private userService:UserService, private router:Router) { }

  ngOnInit() {
  }

  checkInput() : boolean
  {
    if(this.username && this.password && this.role && this.email && this.confirm_password)
      return true;

    return false;

  }

  register() {
    this.registerData = new RegisterDetails(this.username, this.password, this.role, this.email);
    console.log(this.registerData);
    if (this.checkInput())
      if (this.password === this.confirm_password) {
        this.registerData = new RegisterDetails(this.username, this.password, this.role, this.email);
        this.userService.userRegister(this.registerData).subscribe();
        this.router.navigateByUrl('/login');
      }
      else
        console.log("Passwords do not match")
    else
      console.log("some fields are not completed");

  }




}
