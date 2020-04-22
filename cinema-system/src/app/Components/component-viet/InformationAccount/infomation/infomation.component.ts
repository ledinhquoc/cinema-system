import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MemberInformationModule} from '../../Models/memberInformation.module';
import {InformationAccountService} from '../../../../services/information-account.service';
import {ActivatedRoute, Router} from '@angular/router';
import {MaterialService} from '../../../../services/material.service';
import {NotificationService} from '../../../../services/notification.service';

@Component({
  selector: 'app-infomation',
  templateUrl: './infomation.component.html',
  styleUrls: ['./infomation.component.css']
})
export class InfomationComponent implements OnInit {

  public formMember1: FormGroup;
  public formMember2: FormGroup;

  public member: MemberInformationModule;

  constructor(public formBuilderStudentEdit: FormBuilder,
              public memberService: InformationAccountService,
              public router: Router,
              public activatedRouteService: ActivatedRoute,
              public dialogService: MaterialService,
              private notificationService: NotificationService) {
  }

  ngOnInit(): void {
    this.formMember1 = this.formBuilderStudentEdit.group({
      id: [],
      idAccount: [''],
      oldPassWord: ['',[Validators.required]],
      newPassWord: ['',[Validators.required]],
      confirmPassWord: ['',[Validators.required]],
      userName: [''],
      password: [''],


    });
    this.formMember2 = this.formBuilderStudentEdit.group({   fullName: ['',[Validators.required,Validators.pattern('^[a-z A-z]*$')]],
      birthday: ['',[Validators.required]],
      gender: ['',[Validators.required]],
      idCard: ['',[Validators.required, Validators.pattern('^[0-9]{9}$')]],
      email: ['', [Validators.required, Validators.email]],
      phone: ['', [Validators.required, Validators.pattern('^[0-9]{10}|[0-9]{11}|[0-9]{12}$')]],
      address: ['',[Validators.required]],});

    this.loadDataMemberEdit();
  }

  loadDataMemberEdit() {
    this.activatedRouteService.params.subscribe(data => {
      let id = data['id'];
      this.memberService.getAccountEdit(id).subscribe((member: MemberInformationModule) => {
        this.member = member;
        console.log(this.member);
        console.log(this.formMember1);
      });
    });
  }

  onEditPassword() {
    this.dialogService.openConfirmDialog('Are you sure to change this password?').afterClosed().subscribe(data => {
      console.log(data);
      if (data) {
        this.activatedRouteService.params.subscribe(data => {
          let id = data['id'];
          this.memberService.getAccountEdit(id).subscribe((member: MemberInformationModule) => {
              this.member = member;
              if (this.formMember1.value.oldPassWord === this.member.password && this.formMember1.value.newPassWord === this.formMember1.value.confirmPassWord) {
// @ts-ignore
                this.member.password=this.formMember1.value.newPassWord;
                this.memberService.updateAccount(this.member).subscribe(data => {
                  console.log(data);
                  this.notificationService.warn('Change successfully');
                  this.router.navigateByUrl('');
                });
              } else {
                console.log(this.formMember1.value.oldPassWord);
                console.log('Không đổi đc ');
                this.notificationService.warn('Check your old password or new password you have entered');
              }
            }
          );
        })
      }

    });
}

onEditInformartion(){
  this.dialogService.openConfirmDialog('Are you sure to change information account?').afterClosed().subscribe(data => {
    console.log(data);
    if (data) {
      this.memberService.updateAccount(this.member).subscribe(data => {
        console.log(data);
        this.notificationService.warn('Change successfully');
      });
    }

  });
}
}
