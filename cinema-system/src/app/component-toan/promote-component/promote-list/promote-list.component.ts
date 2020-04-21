import { Component, OnInit } from '@angular/core';
import { PromoteService } from '../../service/promote.service'

@Component({
  selector: 'app-promote-list',
  templateUrl: './promote-list.component.html',
  styleUrls: ['./promote-list.component.css']
})
export class PromoteListComponent implements OnInit {

  public promotes;

  constructor(
    public promoteService:PromoteService,
  ) { }

  ngOnInit() {
    this.promoteService.getAllPromote().subscribe(data=>{
      console.log(data);
      this.promotes = data
    })
  }

}
