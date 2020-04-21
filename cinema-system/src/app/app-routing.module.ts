import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import { SeeTickersPricesComponent } from './conponents/see-tickers-prices/see-tickers-prices.component';
import { CommonModule } from '@angular/common';


const routes: Routes = [];

@NgModule({
  imports: [RouterModule.forRoot(routes), CommonModule],
    exports: [RouterModule, SeeTickersPricesComponent],
  declarations: [SeeTickersPricesComponent]
})
export class AppRoutingModule {
}
