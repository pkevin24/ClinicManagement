import { Component, OnInit } from '@angular/core';
import { throwError } from 'rxjs';
import { Signup } from '../model/signup';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
})
export class RegisterComponent implements OnInit {
  submitted = false;

  signupModel: Signup = {
    name: '',
    username: '',
    password: '',
  };

  constructor(private signupService: SignupService) {}

  ngOnInit(): void {}

  signup(userForm: any) {
    this.signupService.signup(userForm.value).subscribe((res) => {
      console.log(res.user);

      if (res.user == null) {
        throwError('User Already Exist!');
      }
      localStorage.setItem('user', JSON.stringify(res.user));
      window.alert('User registered !!!');
      window.location.replace('/login');
    });
  }
}
