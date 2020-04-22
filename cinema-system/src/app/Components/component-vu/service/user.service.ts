import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {SocialUser} from 'angularx-social-login';
import {User} from '../interface/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  public API = 'http://localhost:3000/sinhvien';
  constructor( public http: HttpClient) {
  }
  getAllUser(): Observable<any> {
    return this.http.get(this.API);
  }
  deleteUser(i): Observable<any> {
    return this.http.delete(`${this.API}/${i}`);
  }
  createUser(post: SocialUser): Observable<User> {
    return this.http.post<User>(this.API, post);
  }
  getUser(i): Observable<any> {
    return this.http.get(`${this.API}/${i}`);
  }

  updateUser(customer: User): Observable<any> {
    return this.http.patch<User>(`${this.API}/${customer.id}`, customer);
  }
}
