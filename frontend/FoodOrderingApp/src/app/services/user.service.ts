import { Injectable } from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {UserProfile} from "../dto/user-profile";
import {Observable} from "rxjs";

import {RegisterDetails} from "../dto/register-details";
import {UserLoginCredentials} from "../dto/user-login-details";

@Injectable({
  providedIn: 'root'
})

export class UserService {

  userUrl: string;

  constructor(private http:HttpClient) {
    this.userUrl=`${environment.baseUrl}/user`
  }

  public getUsers(): Observable<UserProfile[]>
  {
    return this.http.get<UserProfile[]>(this.userUrl);
  }

  public getUser(id : number):Observable<UserProfile>
  {
    return this.http.get<UserProfile>(`${this.userUrl}/${id}`);
  }

  public userLogin(loginCredentials:UserLoginCredentials) : Observable<any>
  {
    return this.http.post(`${this.userUrl}/login`,loginCredentials,{observe: 'response'});
  }

  public userRegister(registerDetails:RegisterDetails) : Observable<RegisterDetails>
  {
    return this.http.post<RegisterDetails>(`${this.userUrl}/create`,registerDetails)
  }

  public editProfile(userProfile:UserProfile) : Observable<UserProfile>
  {
    return this.http.put<UserProfile>(`${this.userUrl}/edit`,userProfile)
  }


}
