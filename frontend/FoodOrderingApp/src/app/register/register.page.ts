import { Component, OnInit } from '@angular/core';
import { AuthService} from "../Providers/auth.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.page.html',
  styleUrls: ['./register.page.scss'],
})
export class RegisterPage implements OnInit {

  role:any;
  email: string;
  password: string;


  constructor() { }


  ngOnInit() {
  }

}
