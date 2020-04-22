import { Component, OnInit } from '@angular/core';
import {PointHistoryModule} from '../../Models/pointHistory.module';
import {HistoryUsePointService} from '../../../../Services/history-use-point.service';
import {MemberInformationModule} from '../../Models/memberInformation.module';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-history-ticket',
  templateUrl: './history-ticket.component.html',
  styleUrls: ['./history-ticket.component.css']
})
export class HistoryTicketComponent implements OnInit {

public history: PointHistoryModule [];

public from:string;
public to:string;
  constructor(public historyUsePointService: HistoryUsePointService,
              public router: Router,
              public activatedRouteService: ActivatedRoute,) { }

  ngOnInit(): void {
    this.loadPointUser();
    this.from="dd-MM-yyyy"
    this.to="dd-MM-yyyy"
  }

  loadPointUser() {
    this.activatedRouteService.params.subscribe(data => {
      let id = data['id'];
      this.historyUsePointService.getPointAccount(id).subscribe((point: PointHistoryModule[]) => {
        this.history = point;
        console.log(this.history);

      });
    });
  }

 searchPointUser() {
    this.activatedRouteService.params.subscribe(data => {
      let id = data['id'];
     let from=this.from;
     let to=this.to;
      this.historyUsePointService.getSearchPointAccount(id,from,to).subscribe((point: PointHistoryModule[]) => {
        this.history = point;
        console.log(this.history);

      });
    });
  }
  onSubmit() {
    this.searchPointUser();
    console.log(this.from);
    console.log(this.to);
  }

}
