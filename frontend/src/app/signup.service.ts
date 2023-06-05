import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SignupService {
  constructor(private http: HttpClient) {}

  uri = '';

  signup(data: any): Observable<any> {
    return this.http.post<any>(this.uri, data);
  }
}
