import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ReactiveFormsModule} from '@angular/forms';
import {AuthService, AuthServiceConfig, FacebookLoginProvider} from 'angularx-social-login';
import {MemberComponent} from './Components/component-vu/member/member.component';
import {httpInteceptorProvider} from './Services/auth-interceptor';
import {AuthService, AuthServiceConfig, FacebookLoginProvider} from "angularx-social-login";
import {CookieService} from "ngx-cookie-service";
import { PaypalComponent } from './Components/component-vu/admin-ticket/paypal/paypal.component';


@NgModule({
  declarations: [
    AppComponent,
    PaypalComponent,

  ]
  ,
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, BrowserAnimationsModule, ReactiveFormsModule],
  providers: [AuthService,CookieService,
    {
      provide: AuthServiceConfig,
      useFactory: socialConfigs
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

