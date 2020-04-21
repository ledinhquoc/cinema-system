import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './component-vu/login/login.component';
import {ResetPasswordComponent} from './component-vu/reset-password/reset-password.component';


const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'resetPassword', component: ResetPasswordComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
