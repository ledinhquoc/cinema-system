import {Component, OnInit} from '@angular/core';
import { BanVeService } from '../../../Services/ban-ve.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-chon-ghe',
  templateUrl: './chon-ghe.component.html',
  styleUrls: ['./chon-ghe.component.css']
})
export class ChonGheComponent implements OnInit {
  public row = [
    "Z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
  ];
  public seats;
  public seats_selecting = [];
  public seats_selecting_show = this.seats_selecting;
  public compare_element: string;
  public compare_number_of_element:number;

  constructor(private router: Router,
              private banveService: BanVeService) {
  }

  ngOnInit(): void {
    this.banveService.getAllSeats().subscribe(data => {
      this.seats = data;
    })
  }


  selectSeat(seat: any) {
    if (seat.is_booked) {
      alert(this.row[seat.row_id] + seat.seat_number + " is already booked.");
      return;
    }
    if (seat.is_selecting == false) {
      seat.is_selecting = true;
      this.seats_selecting.push(this.row[seat.row_id] + seat.seat_number);
    } else {
      this.compare_element = this.row[seat.row_id] + seat.seat_number;
      this.compare_number_of_element = this.seats_selecting.indexOf(this.compare_element);
      if (this.compare_number_of_element !== -1) {
        this.seats_selecting.splice(this.compare_number_of_element,1)
      }
      seat.is_selecting = false;
    }
  }

  // datve(seat: any) {
  //   this.seats_selecting.push(this.row[seat.row_id] + seat.seat_number);
  //   this.seats_selecting.push(seat.seat_name);
  // }
}
