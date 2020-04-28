import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ticket-booking-information',
  templateUrl: './ticket-booking-information.component.html',

  styleUrls: ['./ticket-booking-information.component.css'],
})
export class TicketBookingInformationComponent implements OnInit {
  ticket: any;

  constructor() {}

  ngOnInit(): void {
    this.ticket = history.state[1];
  }

}
