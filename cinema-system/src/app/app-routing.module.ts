import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {LoginComponent} from './Components/component-vu/login/login.component';
import {ResetPasswordComponent} from './Components/component-vu/reset-password/reset-password.component';

import {TopBarComponent} from './Components/component-viet/TopBar/top-bar/top-bar.component';
import {SlideBarComponent} from './Components/component-viet/SlideBar/slide-bar/slide-bar.component';
import { ErrorDisplayComponent } from './Components/component-vu/error-display/error-display.component';


import {InfomationComponent} from './Components/component-viet/InformationAccount/infomation/infomation.component';
import {HomeAccountComponent} from './Components/component-viet/home-account/home-account.component';
import {HistoryTicketComponent} from './Components/component-viet/Tickes/history-ticket/history-ticket.component';
import {TicketCanceledComponent} from './Components/component-viet/Tickes/ticket-canceled/ticket-canceled.component';
import {TicketBookingComponent} from './Components/component-viet/Tickes/ticket-booking/ticket-booking.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {MatDialogModule} from '@angular/material/dialog';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import { MatConfirmDialogComponent } from './Components/component-viet/mat-confirm-dialog/mat-confirm-dialog.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { PromotionlistComponent } from './Components/component-toanbui/promotionlist/promotionlist.component';


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
  {path: 'resetPassword', component: ResetPasswordComponent},
  {path: 'promotions', component: PromotionlistComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes), ReactiveFormsModule, FormsModule, CommonModule,MatDialogModule,MatButtonModule,MatIconModule,MatSnackBarModule],
  exports: [RouterModule, TopBarComponent, SlideBarComponent,],
  declarations: [TopBarComponent, SlideBarComponent, InfomationComponent, HomeAccountComponent
    , HistoryTicketComponent,ErrorDisplayComponent,LoginComponent,
    ResetPasswordComponent, TicketCanceledComponent, TicketBookingComponent, MatConfirmDialogComponent, PromotionlistComponent,],
  entryComponents:[MatConfirmDialogComponent]
})
export class AppRoutingModule {
}
