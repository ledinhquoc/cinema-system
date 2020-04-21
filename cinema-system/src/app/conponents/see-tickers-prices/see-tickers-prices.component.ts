import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-see-tickers-prices',
  templateUrl: './see-tickers-prices.component.html',
  styleUrls: ['./see-tickers-prices.component.css']
})
export class SeeTickersPricesComponent implements OnInit {

  isBK2 = '';
  isBK1 = '';
  public  ticker: object = [
    {
      name: '2d',
      time: 'Trước 17h',
      thu246: 50 ,
      thu3: 50 ,
      thu67CN: 40 ,
    },
    {
      name: '2d',
      time: 'Sau 17h',
      thu246: 50 ,
      thu3: 50 ,
      thu67CN: 40 ,
    },
    {
      name: '3d',
      time: 'Trước 17h',
      thu246: 5550 ,
      thu3: 5550 ,
      thu67CN: 40 ,
    },
    {
      name: '3d',
      time: 'Sau 17h',
      thu246: 5550 ,
      thu3: 5550 ,
      thu67CN: 5540 ,
    }
  ] ;
  checkticker = '2d';
  constructor() { }

  ngOnInit(): void {
  }

  clickTab1() {
    this.isBK1 = '#DF7401' ;
    this.isBK2 = '' ;
    this.checkticker = '2d';
  }

  clickTab2() {
    this.checkticker = '3d';
    this.isBK2 = '#DF7401' ;
    this.isBK1 = '' ;
  }

}
