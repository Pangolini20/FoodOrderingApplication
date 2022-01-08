import {Role} from "./role";

export class UserProfile {
  id:number;
  username:string;
  address:string;
  role:Role;
  email:string;

  builder(id,username,address,role,email) : UserProfile
  {
    this.id=id;
    this.username=username;
    this.address=address;
    this.role=role;
    this.email=email;
    return this;
  }

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
