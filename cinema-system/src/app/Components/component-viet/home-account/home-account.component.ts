import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MemberInformationModule} from '../Models/memberInformation.module';
import {UserModule} from '../Models/user.module';
import {InformationAccountService} from '../../../Services/information-account.service';
import {UserServiceService} from '../../../Services/user-service.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MaterialService} from '../../../Services/material.service';
import {NotificationService} from '../../../Services/notification.service';

@Component({
  selector: 'app-home-account',
  templateUrl: './home-account.component.html',
  styleUrls: ['./home-account.component.css']
})
export class HomeAccountComponent implements OnInit {

  public formMemberShow1: FormGroup;
  public formMemberShow2: FormGroup;

  public member: MemberInformationModule;
  public user: UserModule;

  constructor(public formBuilderStudentEdit: FormBuilder,
              public memberService: InformationAccountService,
              public userService: UserServiceService,
              public router: Router,
              public activatedRouteService1: ActivatedRoute,
             ) {
  }

  ngOnInit(): void {
    this.formMemberShow1 = this.formBuilderStudentEdit.group({
      id: [],
      idAccount: [''],
      oldPassWord: ['', [Validators.required]],
      newPassWord: ['', [Validators.required]],
      confirmPassWord: ['', [Validators.required]],
      userName: [''],
      password: [''],


    });
    this.formMemberShow2 = this.formBuilderStudentEdit.group({
      fullName: ['', [Validators.required, Validators.pattern('^[a-z A-z]*$')]],
      birthday: ['', [Validators.required]],
      gender: ['', [Validators.required]],
      idCard: ['', [Validators.required, Validators.pattern('^[0-9]{9}$')]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern('^[0-9]{10}|[0-9]{11}|[0-9]{12}$')]],
      address: ['', [Validators.required]],
    });

    this.loadDataMemberEdit1();
  }

  loadDataMemberEdit1() {
    this.activatedRouteService1.params.subscribe(data => {
      let id = data['id'];
      this.memberService.getAccountEdit(id).subscribe((member: MemberInformationModule) => {
        this.member = member;
        console.log(this.member);
        console.log(this.formMemberShow1);
      });
      this.userService.getUserEdit(id).subscribe((user: UserModule) => {
        this.user = user;
        console.log(this.user);

      });
    });
  }
}
