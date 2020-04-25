import { TicketBookingInformationComponent } from './ticket-booking-information/ticket-booking-information.component';
import { PositionSelectorComponent } from './position-selector/position-selector.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: 'chon-ghe', component: PositionSelectorComponent },
  { path: 'thong-tin-dat-ve', component: TicketBookingInformationComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
