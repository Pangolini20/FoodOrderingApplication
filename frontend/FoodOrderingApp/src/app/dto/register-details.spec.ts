import { RegisterDetails } from './register-details';
import {Role} from "./role";

describe('RegisterDetails', () => {
  it('should create an instance', () => {
    expect(new RegisterDetails('darius','darius',Role.CLIENT,'darius@yahoo.com')).toBeTruthy();
  });
});
