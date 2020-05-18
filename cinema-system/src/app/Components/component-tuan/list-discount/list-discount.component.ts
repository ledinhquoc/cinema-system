import { Component, OnInit } from '@angular/core';
import {FilmService} from "../service/film.service";
import {Promotions} from "../model/Promotions";
import {FormBuilder} from "@angular/forms";

@Component({
  selector: 'app-list-discount',
  templateUrl: './list-discount.component.html',
  styleUrls: ['./list-discount.component.css']
})
export class ListDiscountComponent implements OnInit {
  public discount: Array<Promotions> = [];
  public discountCreate: Array<Promotions> = [];
  public discountEdit: Array<Promotions> = [];
  public page = 1;

  // public editField: string;
  // isHidden: boolean = true;


  constructor(private discountService: FilmService) {
  }

  ngOnInit(): void {
    this.discountService.getAllPromotion().subscribe(data => {
      this.discount = data;
      this.discountCreate = [];
      this.discountEdit = [];
      this.discount.forEach((item, index) => {
        this.discount[index].isEdit = false;
      })
    });
  }
  delete(id, index) {
    if (id == null) {
      this.discount.splice(index, 1);
      console.log(this.discountCreate);
    } else {
      if(confirm("Bạn có chắc muốn xóa Khuyến mãi này không???")){
        this.discountService.deletePromotion(id).subscribe(result => {
          this.ngOnInit();
        }, error => console.error(error));
      }
    }
  }


  addNew() {
    let promo = new Promotions();
    this.discount.push(promo);
    promo.isEdit = true;
    console.log(this.discount.length);
  }

  edit(id,index) {
    if (id !== null && id !== undefined){
      this.discountEdit.push(this.discount[index]);
    }
    this.discount[index].isEdit = !this.discount[index].isEdit;
  }


  saveAll() {
    if (this.discountEdit != []) {
      for (let i = 0; i < this.discountEdit.length; i++) {
        if (this.discount[i].id == null) {
          this.discount.splice(i, 1);
        }
      }
      this.discountService.editAllPromotion(this.discountEdit).subscribe(data => {
      });
    }

    for (let i = 0; i < this.discount.length; i++) {
      if (this.discount[i].id == null) {
        this.discountCreate.push(this.discount[i]);
      }
    }
    if (this.discountCreate != []) {
      console.log(this.discount);
      this.discountService.createAllPromotion(this.discountCreate).subscribe(data => {
      });
    }
    location.reload();
  }


}
