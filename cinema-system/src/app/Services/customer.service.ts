import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http' ;
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
	public API = 'http://localhost:8080/customers';
  public API2 = 'http://localhost:8080/tickets';

  constructor(
  	public http: HttpClient
  	) { }
  getCustomerById(customerId): Observable<any> {
  return this.http.get(this.API + '/' + customerId)
	}
	getAllCustomers(): Observable<any> {
  	return this.http.get(this.API)
  }
  getTicketById(ticketId): Observable<any> {
    return this.http.get(this.API2 + '/' + ticketId)
  }


  // hhien
  addCustomer(customer): Observable<any> {
    return this.http.post(this.API ,customer)
  }

  editCustomer(customer, customerid): Observable<any> {
    return this.http.put(this.API + '/' + customer,customerid)
  }


}
