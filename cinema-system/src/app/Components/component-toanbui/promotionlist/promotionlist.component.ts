import { Component, OnInit } from '@angular/core';
import {PromotionService} from '../service/promotion.service'

@Component({
  selector: 'app-promotionlist',
  templateUrl: './promotionlist.component.html',
  styleUrls: ['./promotionlist.component.css']
})
export class PromotionlistComponent implements OnInit {

  public promotions;
  constructor(
    public promotionService : PromotionService,
  ) { }

  ngOnInit() {
    this.promotionService.getAllPromotions().subscribe(data =>{
      console.log(data);
      this.promotions=data
    })
  }

}
