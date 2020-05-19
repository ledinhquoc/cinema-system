import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {log} from 'util';

@Injectable({
  providedIn: 'root'
})
export class EmployeesService {

  public API : string = 'http://localhost:8080/employees';

  constructor(
    public http: HttpClient
  ) { }

  getAllEmployees(): Observable<any> {
    return this.http.get(this.API);
  }

  addNewEmployee(employees): Observable<any>{
    return this.http.post(this.API + '/add' ,employees);
  }

  deleteEmployee(id): Observable<any>{
    return this.http.delete(this.API + '/delete/' + id);
  }

  editEmployee(employees): Observable<any>{
    return this.http.put(this.API + '/edit',employees);
  }
}
