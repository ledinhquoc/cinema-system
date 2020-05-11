import { Component, OnInit } from '@angular/core';
import {FilmService} from "../service/film.service";
import {Promotions} from "../model/Promotions";

@Component({
  selector: 'app-list-discount',
  templateUrl: './list-discount.component.html',
  styleUrls: ['./list-discount.component.css']
})
export class ListDiscountComponent implements OnInit {
  public discount: Array<Promotions> = [];
  public editField: string;
  constructor(private discountService: FilmService) { }

  ngOnInit(): void {
    this.discountService.getAllPromotion().subscribe(data => {
      this.discount = data;
    });
  }

  delete(id) {
    this.discountService.deletePromotion(id).subscribe(result => {
      this.ngOnInit();
    }, error => console.error(error))
  }

  addRow(index) {
    this.discountService.createPromotion(this.discount[index]).subscribe();
    return true;
  }

  addNew() {
    this.discount.push(new Promotions());
  }

  edit(index){
    this.discountService.editPromotion(this.discount[index], index+1).subscribe();
    return true;
  }

  // changeValue(id: number, property: string, event: any) {
  //   this.editField = event.target.textContent;
  // }

}
