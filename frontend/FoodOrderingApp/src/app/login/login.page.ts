import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user.service";
import {Observable} from "rxjs";
import {UserProfile} from "../dto/user-profile";

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  users:UserProfile[];

  constructor(private userService:UserService) {

  }

  ngOnInit() {
   this.userService.getUsers().subscribe(x =>{ this.users =x;});



  }



}
