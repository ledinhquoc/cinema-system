import { Component, OnInit } from '@angular/core';
import {MemberInformationModule} from '../../Models/memberInformation.module';
import {InformationAccountService} from '../../../../services/information-account.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-slide-bar',
  templateUrl: './slide-bar.component.html',
  styleUrls: ['./slide-bar.component.css']
})
export class SlideBarComponent implements OnInit {



  public  memberAvatar:MemberInformationModule;
  constructor(
              public memberService:InformationAccountService,
              public router:Router,
              public activatedRouteService: ActivatedRoute,) { }

  ngOnInit(): void {


    this.loadDataAvarta();
  }

  loadDataAvarta() {
    this.activatedRouteService.params.subscribe(data => {
      let id = data['id'];
      this.memberService.getAccountEdit(id).subscribe((member:MemberInformationModule) => {
        this.memberAvatar = member;
      });
    });
  }
}
