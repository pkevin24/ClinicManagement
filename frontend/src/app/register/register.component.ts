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

  public sign=new Signup;

  constructor(private signupService: SignupService) {}

  ngOnInit(): void {}

  signup(userForm: any) {
    console.log(userForm.value);
    this.signupService.signup(this.sign).subscribe((res) => {
      console.log(res);
      window.alert(res.body);
      if(res!= "Username already exists")
        window.location.replace('/login');
    });
  }
}
