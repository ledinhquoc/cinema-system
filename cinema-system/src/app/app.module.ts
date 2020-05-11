import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ReactiveFormsModule} from '@angular/forms';
import {AuthService, AuthServiceConfig, FacebookLoginProvider} from "angularx-social-login";
import {MemberComponent} from './Components/component-vu/member/member.component';
import {httpInteceptorProvider} from "./Services/auth-interceptor";

@NgModule({
  declarations: [
    AppComponent,
    MemberComponent,

  ]
  ,
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, BrowserAnimationsModule, ReactiveFormsModule],
  providers: [AuthService, httpInteceptorProvider,
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

