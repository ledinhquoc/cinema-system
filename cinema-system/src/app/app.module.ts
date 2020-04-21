import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import { LoginComponent } from './component-vu/login/login.component';
import {AuthService, AuthServiceConfig, FacebookLoginProvider} from 'angularx-social-login';
import { ResetPasswordComponent } from './component-vu/reset-password/reset-password.component';
import { ErrorDisplayComponent } from './component-vu/error-display/error-display.component';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ResetPasswordComponent,
    ErrorDisplayComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [ AuthService,
    {
      provide: AuthServiceConfig,
      useFactory: socialConfigs
    } ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
