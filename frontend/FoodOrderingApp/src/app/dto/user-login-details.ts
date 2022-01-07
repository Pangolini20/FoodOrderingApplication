export class UserLoginCredentials {
  private username:string;
  private notHashedPassword:string;


  set _username(value: string) {
    this.username = value;
  }

  set _notHashedPassword(value: string) {
    this.notHashedPassword = value;
  }
}

