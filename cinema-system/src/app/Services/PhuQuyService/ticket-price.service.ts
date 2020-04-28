import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TicketPriceService {
   private  API = 'http://localhost:8080/ticketPrice' ;
  constructor(public http: HttpClient) { }
   getAllTicketPrice(): Observable<any>{
      return this.http.get(this.API)
   }
   addNewTicketPrice(newticket): Observable<any>{
       return this.http.post(this.API,newticket);
   }
   deleteTicketPrice(id):Observable<any>{
    return this.http.delete(this.API + '/' + id);
   }
  getByIdTodo(id): Observable<any>{
    return  this.http.get(this.API + '/' + id);
  }
  updateTodo(ticketPrice, id): Observable<any>{
    return this.http.put(this.API + '/' + id , ticketPrice);
  }
}
