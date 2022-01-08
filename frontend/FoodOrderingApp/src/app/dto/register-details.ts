import {Role} from "./role";

export class RegisterDetails {
  private username:string;
  private password:string;
  private role:Role;
  private email:string;



  constructor(username: string, password: string, role: Role, email: string) {
    this.username = username;
    this.password = password;
    this.role = role;
    this.email = email;
  }




}
