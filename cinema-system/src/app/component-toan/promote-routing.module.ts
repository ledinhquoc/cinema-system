import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Routes, RouterModule} from '@angular/router';
import { PromoteListComponent } from './promote-component/promote-list/promote-list.component';
import { PromoteDetailComponent } from './promote-component/promote-detail/promote-detail.component';

const routes: Routes = [
  {path:'promote-list',component:PromoteListComponent},
  {path:'promote-detail/:id',component:PromoteDetailComponent}
];

@NgModule({
  declarations: [PromoteListComponent, PromoteDetailComponent],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class PromoteRoutingModule { }
