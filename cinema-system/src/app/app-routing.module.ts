import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {TopBarComponent} from './Components/TopBar/top-bar/top-bar.component';
import {SlideBarComponent} from './Components/SlideBar/slide-bar/slide-bar.component';

import {InfomationComponent} from './Components/InformationAccount/infomation/infomation.component';
import {HomeAccountComponent} from './Components/home-account/home-account.component';
import {HistoryTicketComponent} from './Components/Tickes/history-ticket/history-ticket.component';
import {TicketCanceledComponent} from './Components/Tickes/ticket-canceled/ticket-canceled.component';
import {TicketBookingComponent} from './Components/Tickes/ticket-booking/ticket-booking.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {MatDialogModule} from '@angular/material/dialog';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { MatConfirmDialogComponent } from './Components/mat-confirm-dialog/mat-confirm-dialog.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';


const routes: Routes = [
  {
    path: ':id/account', component: SlideBarComponent,
    children: [{
      path: '', component: HomeAccountComponent,
    },{
      path: ':id/information', component: InfomationComponent,
    },
      {
        path: 'history-ticket', component: HistoryTicketComponent,
      },
      {
        path: 'ticket-booking', component: TicketBookingComponent,
      },
      {
        path: 'ticket-canceled', component: TicketCanceledComponent,
      }]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes), ReactiveFormsModule, FormsModule, CommonModule,MatDialogModule,MatButtonModule,MatIconModule,MatSnackBarModule],
  exports: [RouterModule, TopBarComponent, SlideBarComponent,],
  declarations: [TopBarComponent, SlideBarComponent, InfomationComponent, HomeAccountComponent
    , HistoryTicketComponent, TicketCanceledComponent, TicketBookingComponent, MatConfirmDialogComponent,],
  entryComponents:[MatConfirmDialogComponent]
})
export class AppRoutingModule {
}
