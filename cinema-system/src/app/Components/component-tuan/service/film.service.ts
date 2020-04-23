import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  constructor(public http: HttpClient) { }
  private baseUrl = 'http://localhost:3000/films';

  getAllFilm(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getFilmById(id: number): Observable<any> {
    return this.http.get(this.baseUrl + '/' + id);
  }

}
