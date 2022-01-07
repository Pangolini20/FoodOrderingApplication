import {Role} from "./role";

export class UserProfile {
  private id:number;
  private username:string;
  private address:string;
  private role:Role;
  private email:string;


  set _id(value: number) {
    this.id = value;
  }

  set _username(value: string) {
    this.username = value;
  }

  set _address(value: string) {
    this.address = value;
  }

  set _role(value: Role) {
    this.role = value;
  }

  set _email(value: string) {
    this.email = value;
  }
}
