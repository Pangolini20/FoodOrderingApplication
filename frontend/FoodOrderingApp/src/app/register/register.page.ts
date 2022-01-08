import { Component, OnInit } from '@angular/core';
import { AuthService} from "../Providers/auth.service";
import {Role} from "../dto/role";

@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss'],
})
export class RegisterPage implements OnInit {

  roles = [Role.CLIENT.toString(),Role.DELIVERY_GUY.toString(),Role.RESTAURANT_OWNER.toString()];
  username:string;
  role:Role;
  email: string;
  password: string;
  confirm_password: string;


  constructor() { }


  ngOnInit() {
  }

}
