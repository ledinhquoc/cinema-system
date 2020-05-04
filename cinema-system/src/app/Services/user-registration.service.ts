import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {
  public APIUrl = 'http://localhost:3000/accounts';
  constructor(public http: HttpClient) { }
  postAccount(user): Observable<any> {
    return this.http.post(this.APIUrl, user);
  }

  getAllAccounts(): Observable<any> {
    return this.http.get(this.APIUrl);
  }
}
