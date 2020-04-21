import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InformationAccountService {

  public API: string = ' http://localhost:3000/memberInformation';

  constructor(public http: HttpClient) {
  }

  getAccountEdit(id:number):Observable<any>{
    return this.http.get(`${this.API}/${id}`);
  }


  updateAccount(account):Observable<any>{
    return this.http.put(`${this.API}/${account.id}`,account)
  }
}
