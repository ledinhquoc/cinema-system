import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmService {
  public API: string = 'http://localhost:8080/tickets';
  public API1: string = 'http://localhost:8080/promotion/new';
  public API3: string = 'http://localhost:8080/promotions';
  

  constructor(
    public http: HttpClient
  ) { }

  getAllFilms(): Observable<any>{
    return this.http.get(this.API );
  }

  getDayById(ticketId: any): Observable<any>{
    return this.http.get(this.API + '/' + ticketId);
  }

  getAllHours(): Observable<any>{
    return this.http.get(this.API);
  }

  addNewPromotion(promotion): Observable<any>{
    return this.http.post(this.API1,promotion);
  }

  getPromotionById(promotionId): Observable<any>{
    return this.http.get(this.API3 + '/' + promotionId)
  }

  editPromotion(promotion,promotionId): Observable<any>{
    return this.http.put(this.API3 + '/' + promotionId,promotion);
  }
}
