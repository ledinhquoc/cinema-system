import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class PromotionService {
  public API: string = 'http://localhost:8421/Promotions';

  constructor(
    public http: HttpClient
  ) { }

  getAllPromotions(): Observable<any> {
    return this.http.get(this.API);
  }

  getPromotionById(promotionId): Observable<any>{
    return this.http.get(this.API + '/' + promotionId);
  }
}
