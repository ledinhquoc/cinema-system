import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {UserService} from "../service/user.service";
declare let Email: any;
export interface Email1 {
  email: string
}

@Component({
  selector: 'app-reset-password',
  templateUrl: './reset-password.component.html',
  styleUrls: ['./reset-password.component.css']
})
export class ResetPasswordComponent implements OnInit {
  emails: Array<Email1> = [];
  formReset: FormGroup;
  message: string;


  constructor(private router: Router,
              private fb: FormBuilder,
              private userService: UserService) {
  }

  ngOnInit(): void {

    this.formReset = this.fb.group({
      email: [null, Validators.required]
    });

    this.userService.getListUser().subscribe(data => {
      for (const item of data) {
        this.emails.push(item.email);
      }
    });
  }

  sentToEmail() {
    console.log(this.emails);
    const emailT = this.formReset.get('email').value;
    this.userService.getListUser().subscribe(data => {
      for (const item of data) {
        if (item.email === emailT) {
          Email.send({
            Host: 'smtp.elasticemail.com',
            Username: 'kingdomstory272@gmail.com',
            Password: 'A88DD81B7C271836D619D698C97AD44E4B72',
            To: emailT,
            From: 'kingdomstory272@gmail.com',
            Subject: 'Reset Password mail',
            Body: '<i>This is sent as a feedback from my resume page.</i> <br/> <i>Link: http://localhost:4200/confirmPassword/' + item.id + '</i><br><br> <b>~End of Message.~</b> '
          }).then(message => {
            alert(message);
          });
          alert("Check your email");
          return;
        }
      }
      this.message = "Email invalid";
      console.log("fail roi");
    });


  }
}
