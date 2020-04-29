import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatusTicketService {

  public API: string = 'http://localhost:8433/api/v1/tickes';

  constructor(public http: HttpClient) {
  }

  getStatusTickes(id:number,status:string):Observable<any>{
    return this.http.get(`${this.API}/${id}/${status}`);
  }
}
