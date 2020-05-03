import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {LoginComponent} from './Components/component-vu/login/login.component';
import {ResetPasswordComponent} from './Components/component-vu/reset-password/reset-password.component';

import {TopBarComponent} from './Components/component-viet/TopBar/top-bar/top-bar.component';
import {SlideBarComponent} from './Components/component-viet/SlideBar/slide-bar/slide-bar.component';
import {ErrorDisplayComponent} from './Components/component-vu/error-display/error-display.component';


import {InfomationComponent} from './Components/component-viet/InformationAccount/infomation/infomation.component';
import {HomeAccountComponent} from './Components/component-viet/home-account/home-account.component';
import {HistoryTicketComponent} from './Components/component-viet/Tickes/history-ticket/history-ticket.component';
import {TicketCanceledComponent} from './Components/component-viet/Tickes/ticket-canceled/ticket-canceled.component';
import {TicketBookingComponent} from './Components/component-viet/Tickes/ticket-booking/ticket-booking.component';
import {TicketBookingInformationComponent} from './Components/component-toantr/ticket-booking-information/ticket-booking-information.component';
import {PositionSelectorComponent} from './Components/component-toantr/position-selector/position-selector.component';
import {BanVeComponent} from '././Components/component-hhien/ban-ve/ban-ve.component';
import {ChonGheComponent} from '././Components/component-hhien/chon-ghe/chon-ghe.component';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CommonModule} from '@angular/common';
import {MatDialogModule} from '@angular/material/dialog';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatConfirmDialogComponent} from './Components/component-viet/mat-confirm-dialog/mat-confirm-dialog.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';

import {SeeTickerPricesComponent} from './Components/component-quy/see-ticker-prices/see-ticker-prices.component';
import {DetailFilmComponent} from './Components/component-tuan/detail-film/detail-film.component';
import {ListFilmComponent} from './Components/component-tuan/list-film/list-film.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {Ng2SearchPipeModule} from 'ng2-search-filter';


const routes: Routes = [
  {
    path: ':id/account', component: SlideBarComponent,
    children: [{
      path: '', component: HomeAccountComponent,
    },
      {
        path: ':id/show', component: HomeAccountComponent,
      },
      {
        path: ':id/changeInformation', component: InfomationComponent,
      },


      {
        path: ':id/history-ticket', component: HistoryTicketComponent,
      },
      {
        path: ':id/ticket-booking', component: TicketBookingComponent,
      },
      {
        path: ':id/ticket-canceled', component: TicketCanceledComponent,
      }]
  },
  {path: 'resetPassword', component: ResetPasswordComponent},
  {path: 'see-ticker-prices', component: SeeTickerPricesComponent},
  {
    path: 'ban-ve',
    component: BanVeComponent,
    loadChildren: () => import('./Components/component-hhien/ban-ve/ban-ve.module').then(m => m.BanVeModule)
  },
  {path: 'chon-ghe', component: ChonGheComponent}
];

@NgModule({

  declarations: [TopBarComponent,
    BanVeComponent,
    ChonGheComponent,
    SlideBarComponent,
    InfomationComponent,
    HomeAccountComponent,
    HistoryTicketComponent,
    ErrorDisplayComponent,
    LoginComponent,
    ResetPasswordComponent,
    TicketCanceledComponent,
    TicketBookingComponent,
    MatConfirmDialogComponent,
    PositionSelectorComponent,
    TicketBookingInformationComponent,
    DetailFilmComponent,
    ListFilmComponent,
    SeeTickerPricesComponent,],
  imports: [RouterModule.forRoot(routes),
    ReactiveFormsModule,
    FormsModule,
    CommonModule,
    MatDialogModule,
    MatButtonModule,
    MatIconModule,
    MatSnackBarModule,
    NgxPaginationModule,
    Ng2SearchPipeModule],
  exports: [RouterModule, TopBarComponent, SlideBarComponent],
  entryComponents: [MatConfirmDialogComponent]

})
export class AppRoutingModule {
}
