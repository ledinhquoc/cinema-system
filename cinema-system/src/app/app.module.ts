import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ReactiveFormsModule} from '@angular/forms';
import {AuthService, AuthServiceConfig, FacebookLoginProvider} from "angularx-social-login";
import {CookieService} from "ngx-cookie-service";
import { PaypalComponent } from './Components/component-vu/admin-ticket/paypal/paypal.component';
import { FilmService } from './services/film.service';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';

registerLocaleData(en);

@NgModule({
  declarations: [
    AppComponent,
    PaypalComponent,

  ]
  ,
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, BrowserAnimationsModule, ReactiveFormsModule],
  providers: [AuthService,CookieService,FilmService,
    {
      provide: AuthServiceConfig,
      useFactory: socialConfigs
    },
  {
    provide: NZ_I18N,useValue: en_US
  }],
    
  bootstrap: [AppComponent]

})

export class AppModule {
}

export function socialConfigs() {
  const config = new AuthServiceConfig(
    [
      {
        id: FacebookLoginProvider.PROVIDER_ID,
        provider: new FacebookLoginProvider('1570392383013006')
      }
    ]
  );
  return config;
}

