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
  search: string;

  // public editField: string;
  // isHidden: boolean = true;
  // public regexDiscount = /^([0-9]{1}|[1-9][0-9]|100)$/;

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

  validation(): boolean {
    let patternBeginDate = new RegExp(/^(2019|202[0-9]{1})\-(0[1-9]|1[0-2])\-(0[1-9]|[12][0-9]|3[01])$/);
    let patternEndDate = new RegExp(/^(2019|202[0-9]{1})\-(0[1-9]|1[0-2])\-(0[1-9]|[12][0-9]|3[01])$/);
    let patternDiscount = new RegExp(/^([0-9]{1}|[1-9][0-9]|100)$/);
    let patternTitle = new RegExp(/[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\s]+/);
    if (this.discountCreate.length === 0 && this.discountEdit.length === 0) {
      return false;
    }

    if (this.discountCreate.length !== 0 || this.discountEdit.length !== 0) {
      for (let i = 0; i < this.discount.length; i++) {
        let checkBegindate = patternBeginDate.test(String(this.discount[i].promotionBeginDate));
        let checkEnddate = patternEndDate.test(String(this.discount[i].promotionEndDate));
        let checkDiscount = patternDiscount.test(String(this.discount[i].promotionDiscount));
        let checkTitle = patternTitle.test(String(this.discount[i].promotionTitle));
        let checkDescription = patternTitle.test(String(this.discount[i].promotionDescription));

        if(String(this.discount[i].promotionBeginDate).length==0||String(this.discount[i].promotionEndDate).length==0||
          String(this.discount[i].promotionDiscount).length==0||this.discount[i].promotionTitle.length==0||
          this.discount[i].promotionDescription.length==0||this.discount[i].promotionImage.length==0){
          return false;
        }

        if (!checkBegindate||!checkEnddate||!checkDiscount||!checkTitle||!checkDescription) {
          return false;
        }


      }
    }

    return true;
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
    for (let i = 0; i < this.discount.length; i++) {
      if (this.discount[i].id == null || this.discount[i].id == undefined) {
        this.discountCreate.push(this.discount[i]);
      }
    }
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

    // xử lý trùng lặp
    const uniqueSetEdit = new Set(this.discountEdit);
    this.discountEdit = Array.from(uniqueSetEdit);

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

    // xử lý trùng lặp
    const uniqueSetCreate = new Set(this.discountCreate);
    this.discountCreate = Array.from(uniqueSetCreate);
    if (this.discountCreate != []) {
      console.log(this.discount);
      this.discountService.createAllPromotion(this.discountCreate).subscribe(data => {
      });
    }
    this.discountCreate =[];
    location.reload();
  }


}
