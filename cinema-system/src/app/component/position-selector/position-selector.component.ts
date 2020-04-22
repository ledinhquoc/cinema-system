// import { HttpService } from './../_services/http-service/http.service';
// import { Component, OnInit } from '@angular/core';
//
// @Component({
//   selector: 'app-position-selector',
//   templateUrl: './position-selector.component.html',
//   styleUrls: ['./position-selector.component.css'],
// })
// export class PositionSelectorComponent implements OnInit {
//   positions: any[];
//   SeatColors;
//   constructor(private myHttp: HttpService) {}
//
//   ngOnInit(): void {
//     this.myHttp.getAll('positions').subscribe((positions: any[]) => {
//       this.positions = positions;
//     });
//     this.SeatColors = SeatColors;
//   }
//
//   // fillEmptySeat(seats: any[]): any[] {
//   //   return seats.map((seat, index) => {
//   //     if (seat.number === index + 1) return seat;
//
//   //     let distance = seat.number - index;
//   //     let emptySeats = [];
//   //     for (let i = 0; i < distance; i++) {
//   //       emptySeats.push({ isEmptySeat: true });
//   //     }
//   //     return emptySeats;
//   //   });
//
//   //   for (let position of this.positions) {
//   //     let seats: any[] = position.seats;
//   //     for (let i = 0; i < seats.length; i++) {
//   //       let seat = seats[i];
//   //       if (seat.number === i + 1) {
//   //         this.filledSeats.push(seat);
//   //         break;
//   //       }
//
//   //       new Array<any>()
//   //     }
//   //   }
//   // }
// }
//
// enum SeatColors {
//   BookedSeat = 'red',
//   SelectingSeat = 'greenyellow',
//   VipSeat = 'cyan',
// }
