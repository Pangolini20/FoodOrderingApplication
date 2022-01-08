import {Component, Input, OnInit} from '@angular/core';
import {UserService} from "../services/user.service";
import {UserProfile} from "../dto/user-profile";
import {UserLoginCredentials} from "../dto/user-login-details";
import {Router} from "@angular/router";


@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  username!:string;
  password!:string;

  userCredentials:UserLoginCredentials = new UserLoginCredentials();
  userProfile:UserProfile = new UserProfile();

  constructor(private userService:UserService,private router:Router) {
  }

  ngOnInit() {

  }

  loginCheck()
  {
    this.userCredentials.username=this.username;
    this.userCredentials.notHashedPassword=this.password;

    console.log(this.userCredentials);

    this.userService.userLogin(this.userCredentials)
      .subscribe(userprofile => {

        ///////////////////////////////////////////////////////
        // redirect to next page and save profile somewhere

        this.userProfile=this.userProfile.builder(userprofile.id,
          userprofile.username,
          userprofile.address,
          userprofile.role,
          userprofile.email)
        //console.log(this.userProfile.role);
        console.log("Login Succesful :)");

        localStorage.setItem('currentUser',JSON.stringify(this.userProfile))

        switch (this.userProfile.role.toString())
        {
          case 'CLIENT':
          {console.log(this.userProfile.role.toString())
            this.router.navigateByUrl('/browse')
          }
              break;
          case 'RESTAURANT_OWNER':
          { console.log(this.userProfile.role.toString())
            this.router.navigateByUrl('/view-restaurants')
          }
              break;
          case 'DELIVERY_GUY':
            console.log(this.userProfile.role.toString())
             break;
        }
        ////////////////////////////////////////////////////////

     });


  }






}
