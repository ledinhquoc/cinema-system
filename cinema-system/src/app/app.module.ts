
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AuthService, AuthServiceConfig, FacebookLoginProvider} from 'angularx-social-login';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
@NgModule({
  declarations: [
    AppComponent,
  ]
  ,
  imports: [BrowserModule, AppRoutingModule, HttpClientModule,BrowserAnimationsModule,ReactiveFormsModule,],
  providers: [ AuthService,
    {
      provide: AuthServiceConfig,
      useFactory: socialConfigs
    } ],
  bootstrap: [AppComponent]

})

export class AppModule { }

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

