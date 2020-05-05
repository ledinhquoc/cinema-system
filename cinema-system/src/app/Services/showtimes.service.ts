import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {FormControl} from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ShowtimesService {
  public API: string = 'http://localhost:8080/api/v1/movieSchedules';

  constructor(
    public http: HttpClient
  ) {
  }

  getAllFilm(): Observable<any> {
    return this.http.get(this.API);
  }
}
