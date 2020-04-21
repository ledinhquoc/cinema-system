import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class PromoteService {

  public API: string ='http://localhost:3000/promote'

  constructor(
    public http: HttpClient
  ) { }

  getAllPromote(): Observable<any> {
    return this.http.get(this.API);
  }
  getPromoteById(promoteId): Observable<any> {
    return this.http.get(this.API + '/' + promoteId);
  }

}
