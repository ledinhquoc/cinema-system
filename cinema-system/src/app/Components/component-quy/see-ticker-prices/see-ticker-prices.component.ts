import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-see-ticker-prices',
  templateUrl: './see-ticker-prices.component.html',
  styleUrls: ['./see-ticker-prices.component.css']
})
export class SeeTickerPricesComponent implements OnInit {

  public ticker: object = [
    {
      id: 1,
      name: '2d',
      time: 'Trước 17h',
      thu246gt: 50000,
      thu246gv: 50000,
      thu246gd: 50000,
      thu3gt: 50000,
      thu3gv: 50000,
      thu3gd: 50000,
      thu67CNgt: 50000,
      thu67CNgv: 50000,
      thu67CNgd: 50000,
    },
    {
      id: 2,
      name: '2d',
      time: 'Sau 17h',
      thu246gt: 50000,
      thu246gv: 50000,
      thu246gd: 50000,
      thu3gt: 50000,
      thu3gv: 50000,
      thu3gd: 50000,
      thu67CNgt: 50000,
      thu67CNgv: 50000,
      thu67CNgd: 50000,
    },
    {
      id: 3,
      name: '2d',
      time: 'Sau 22h',
      thu246gt: 50000,
      thu246gv: 50000,
      thu246gd: 50000,
      thu3gt: 50000,
      thu3gv: 50000,
      thu3gd: 50000,
      thu67CNgt: 50000,
      thu67CNgv: 50000,
      thu67CNgd: 50000,
    },
    {
      id: 4,
      name: '3d',
      time: 'Trước 17h',
      thu246gt: 50000,
      thu246gv: 50000,
      thu246gd: 50000,
      thu3gt: 50000,
      thu3gv: 50000,
      thu3gd: 50000,
      thu67CNgt: 50000,
      thu67CNgv: 50000,
      thu67CNgd: 50000,
    },
    {
      id: 5,
      name: '3d',
      time: 'Sau 17h',
      thu246gt: 50000,
      thu246gv: 50000,
      thu246gd: 50000,
      thu3gt: 50000,
      thu3gv: 50000,
      thu3gd: 50000,
      thu67CNgt: 50000,
      thu67CNgv: 50000,
      thu67CNgd: 50000,
    },
    {
      id: 6,
      name: '3d',
      time: 'Sau 22h',
      thu246gt: 50000,
      thu246gv: 50000,
      thu246gd: 50000,
      thu3gt: 50000,
      thu3gv: 50000,
      thu3gd: 50000,
      thu67CNgt: 50000,
      thu67CNgv: 50000,
      thu67CNgd: 50000,
    },
  ];

  constructor() {
  }

  ngOnInit(): void {
  }
}
