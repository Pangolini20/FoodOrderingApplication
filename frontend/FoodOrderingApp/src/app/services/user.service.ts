import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {UserProfile} from "../dto/user-profile";
import {Observable} from "rxjs";

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


}
