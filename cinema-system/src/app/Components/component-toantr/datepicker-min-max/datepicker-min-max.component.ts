import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-datepicker-min-max",
  templateUrl: "./datepicker-min-max.component.html",
  styleUrls: ["./datepicker-min-max.component.css"],
})
export class DatepickerMinMaxComponent {
  minDate: Date;
  maxDate: Date;

  constructor() {
    // Set the minimum to January 1st 20 years in the past and December 31st a year in the future.
    const currentYear = new Date().getFullYear();
    this.minDate = new Date(currentYear - 100, 0, 1);
    this.maxDate = new Date(currentYear - 5, 11, 31);
  }
}
