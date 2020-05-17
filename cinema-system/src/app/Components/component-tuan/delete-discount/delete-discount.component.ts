import { Component, OnInit } from '@angular/core';
import {FilmService} from "../service/film.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-delete-discount',
  templateUrl: './delete-discount.component.html',
  styleUrls: ['./delete-discount.component.css']
})
export class DeleteDiscountComponent implements OnInit {
  public id:number;
  public discount;
  constructor(private discountService: FilmService, private route: ActivatedRoute,public router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(data=>{
      this.id = data.id;
      this.discountService.getPromotionById(this.id).subscribe(data=>{
        this.discount = data;
        console.log(this.discount);
      })
    })
  }

  deleteDiscount(){
    if(confirm("Bạn có chắc muốn xóa Khuyến mãi này không???")){
      this.discountService.deletePromotion(this.id).subscribe(data=>{
        this.router.navigateByUrl("/list-discount");
        window.alert('Xóa thành công');
      })
    }
  }

}
