import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  constructor(public http: HttpClient) { }
  private baseUrlFilm = 'http://localhost:8080/movies';
  private baseUrlSchedule = 'http://localhost:8080/movieSchedules/hour';
  private baseUrlPromotion = 'http://localhost:8080/promotions';

  getAllFilm(): Observable<any> {
    return this.http.get(this.baseUrlFilm);
  }

  getFilmById(id: number): Observable<any> {
    return this.http.get(this.baseUrlFilm + '/' + id);
  }

  getScheduleById(id: number): Observable<any> {
    return this.http.get(this.baseUrlSchedule + '/' + id);
  }

  getAllPromotion(): Observable<any> {
    return this.http.get(this.baseUrlPromotion);
  }

  getPromotionById(id: number): Observable<any> {
    return this.http.get(this.baseUrlPromotion + '/' + id);
  }
  createAllPromotion(promotion): Observable<any> {
    return this.http.post(this.baseUrlPromotion + '/add' , promotion);
  }
  deletePromotion(id: number): Observable<any> {
    return this.http.delete<any>(this.baseUrlPromotion + '/delete/' + id);
  }
  editAllPromotion(promotion): Observable<any> {
    return this.http.put(this.baseUrlPromotion +'/edit' ,promotion);
  }
}
