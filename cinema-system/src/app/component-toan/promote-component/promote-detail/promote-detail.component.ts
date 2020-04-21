import { Component, OnInit } from '@angular/core';
import { PromoteService } from '../../service/promote.service';
import {Router, ActivatedRoute } from '@angular/router'

@Component({
  selector: 'app-promote-detail',
  templateUrl: './promote-detail.component.html',
  styleUrls: ['./promote-detail.component.css']
})
export class PromoteDetailComponent implements OnInit {

  public promoteId;
  public promote;

  constructor(
    public promoteService: PromoteService,
    public router: Router,
    public activatedRoute: ActivatedRoute
  ) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe(data =>{ 
      this.promoteId=data.id;
      this.promoteService.getPromoteById(this.promoteId).subscribe(data=>{
      this.promote=data
      })
    })
  
  }

}
