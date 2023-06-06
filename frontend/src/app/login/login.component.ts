import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { Login } from '../model/login';
import { setCookie } from 'typescript-cookie';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  jwttoken = '';
  submitted = false;
  errMsg = '';

  loginModel: Login = {
    username: '',
    password: '',
  };

  response = {
    data: '',
  };

  constructor(private _loginService: LoginService) {}

  ngOnInit(): void {}

  login(userForm: any) {
    const data = {
      username: this.loginModel.username,
      password: this.loginModel.password,
    };

    this._loginService.authenticate(data).subscribe({
      next: (res: any) => {
        JSON.stringify(res);

        // console.log(res);
        this.jwttoken = res.jwt;

        console.log(res.jwt);

        localStorage.setItem('userid', res.jwt);

        this.submitted = true;

        setCookie(
          'jwtToken',
          JSON.stringify(res.jwt).substring(
            1,
            JSON.stringify(res.jwt).length - 1
          )
        );
        window.alert('login success !!!');
        window.location.replace('/');
      },
      error: (e) => console.log(e),
    });
  }
}
