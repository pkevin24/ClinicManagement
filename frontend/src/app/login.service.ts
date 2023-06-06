import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

const uri = 'http://localhost:8080/gettoken/';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  authenticate(data: any): Observable<any> {
    return this.http.get<any>(uri+data.username+"/"+data.password, data);
  }
}
