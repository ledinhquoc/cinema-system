import { Component, OnInit } from '@angular/core';
import {TicketPriceService} from '../../../../Services/PhuQuyService/ticket-price.service';

@Component({
  selector: 'app-see-ticket-price',
  templateUrl: './see-ticket-price.component.html',
  styleUrls: ['./see-ticket-price.component.css']
})
export class SeeTicketPriceComponent implements OnInit {
  public ticket;
  constructor(private tickerPriceService: TicketPriceService) { }
  ngOnInit(): void {
    this.tickerPriceService.getAllTicketPrice().subscribe(data =>{
        this.ticket = data;
        console.log(this.ticket)
    })
  }
}
