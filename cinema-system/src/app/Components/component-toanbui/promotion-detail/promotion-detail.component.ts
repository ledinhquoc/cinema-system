import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute } from '@angular/router'
import {PromotionService} from '../service/promotion.service'

@Component({
  selector: 'app-promotion-detail',
  templateUrl: './promotion-detail.component.html',
  styleUrls: ['./promotion-detail.component.css']
})
export class PromotionDetailComponent implements OnInit {

  public promoteId;
  public promote;

  constructor(
    public promotionService: PromotionService,
    public router: Router,
    public activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(data=>{
      this.promoteId=data.promotion_id;
      this.promotionService.getPromotionById(this.promoteId).subscribe(data=>{
        this.promote=data;
      })
    })
  }

}
