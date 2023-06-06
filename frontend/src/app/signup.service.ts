import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SignupService {
  constructor(private http: HttpClient) {}

  uri = 'http://localhost:8080/gettoken/register';

  signup(data: any): Observable<any> {
    console.log(data);
    return this.http.post<any>(this.uri, data);
  }
}
