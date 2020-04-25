import { HttpService } from './../_services/http-service/http.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-position-selector',
  templateUrl: './position-selector.component.html',
  styleUrls: ['./position-selector.component.css'],
})
export class PositionSelectorComponent implements OnInit {
  showRoom: any;
  user: any;
  SeatColors: any;
  selectingSeatCount = 0;
  formGroup = new FormGroup({
    seatAmount: new FormControl(1, [Validators.min(1), Validators.required]),
  });
  constructor(private myHttp: HttpService, private router: Router) {}

  ngOnInit(): void {
    this.myHttp.getById('users', 1).subscribe((user) => {
      this.user = user;
      console.log(this.user);
    });
    this.myHttp.getById('showrooms', 1).subscribe((showRoom) => {
      this.showRoom = showRoom;
      console.log(this.showRoom);
    });
    this.SeatColors = SeatColors;
  }

  onSubmit() {
    for (const row of this.showRoom._rows) {
      for (const seat of row.seats) {
        if (seat.selecting) {
          (this.user.tickets[0].seats as Array<any>).push(seat);
        }
      }
    }
    this.router.navigate(['thong-tin-dat-ve'], { state: this.user.tickets });
  }

  onSeatSelect(seat: any) {
    if (seat.booked) return;

    if (seat.selecting) {
      --this.selectingSeatCount;
    } else {
      ++this.selectingSeatCount;
    }
    seat.selecting = !seat.selecting;
    this.handleSubmission();
  }

  handleSubmission() {
    this.formGroup.setErrors(
      this.selectingSeatCount === this.formGroup.get('seatAmount').value
        ? {}
        : { unequalOptions: true }
    );
  }

  // fillEmptySeat(seats: any[]): any[] {
  //   return seats.map((seat, index) => {
  //     if (seat.number === index + 1) return seat;

  //     let distance = seat.number - index;
  //     let emptySeats = [];
  //     for (let i = 0; i < distance; i++) {
  //       emptySeats.push({ isEmptySeat: true });
  //     }
  //     return emptySeats;
  //   });

  //   for (let position of this.positions) {
  //     let seats: any[] = position.seats;
  //     for (let i = 0; i < seats.length; i++) {
  //       let seat = seats[i];
  //       if (seat.number === i + 1) {
  //         this.filledSeats.push(seat);
  //         break;
  //       }

  //       new Array<any>()
  //     }
  //   }
  // }
}

enum SeatColors {
  BookedSeat = 'bg-danger',
  SelectingSeat = 'bg-success',
  VipSeat = 'bg-info',
}
