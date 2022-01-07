import {Component, OnInit} from '@angular/core';
import {UserService} from "../services/user.service";
import {UserProfile} from "../dto/user-profile";
import {RegisterDetails} from "../dto/register-details";
import {Role} from "../dto/role";
import {UserLoginCredentials} from "../dto/user-login-details";


@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  users:UserProfile[];
  loginCreds : UserLoginCredentials;
  status !: number;
  test:RegisterDetails ;
  userProfile:UserProfile;

  constructor(private userService:UserService) {

  }

  ngOnInit() {
    //this.createUser();
    //this.loginUser();
    this.editUser();
  }



  createUser(): void
  {
    this.test= new RegisterDetails("darius","darius",Role.CLIENT,"darius@yahoo.com")
    console.log(this.test)
    this.userService.userRegister(this.test).subscribe();
  }

  editUser():void
  {
    this.userProfile = new UserProfile();
    this.userProfile._id = 1;
    this.userProfile._role = Role.DELIVERY_GUY;
    this.userProfile._username = "daiana";
    this.userProfile._address = "timisoara";
    this.userProfile._email = "daiana@yahoo.com";

    this.userService.editProfile(this.userProfile).subscribe()

  }

  loginUser(): void
  {
    this.loginCreds = new UserLoginCredentials();
    this.loginCreds._username='darius';
    this.loginCreds._notHashedPassword='darius';

    this.userService.userLogin(this.loginCreds)
      .subscribe(response => {
        if (response.status == 202)
        {
          console.log(response.status)
          console.log("Login Succesful :)")
        }
      });

    // this.loginCreds._username='darius';
    // this.loginCreds._notHashedPassword='dariussss';
    // this.userService.userLogin(this.loginCreds).subscribe(response => console.log(response.status));
  }





}
