import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../../../Services/user-registration.service';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import { Router} from '@angular/router';
import {User} from '../../../Model/User/user';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  public formAddnewAccount: FormGroup;
  user: User;
  listUser: Array<User> = [];
  public maxDate = new Date();
  public minDate = new Date(1992, 0, 1);
  constructor(public formBuilder: FormBuilder,
              public route: Router,
              public userRegistrationService: UserRegistrationService) { }

  ngOnInit(): void {
    this.userRegistrationService.getAllAccounts().subscribe(da => {
      for (const s of da) {
        this.listUser.push(s);
      }
      console.log(this.listUser);
    });
    this.formAddnewAccount = this.formBuilder.group(
      {
        id: [],
        account: ['', Validators.required],
        password: ['', Validators.required],
        fullName: ['', Validators.required],
        dateOfBirth: ['', Validators.required],
        idCard: ['', Validators.required],
        address: ['', Validators.required],
        gender: ['', Validators.required],
        email: ['', Validators.required],
        phone: ['', Validators.required],
      }
    );
  }
  addNewAccount() {
    this.userRegistrationService.postAccount(this.formAddnewAccount.value).subscribe(data => {
      this.user = data;
      this.listUser.push(this.user);
      console.log(this.listUser);
      this.route.navigateByUrl('/nextPage');
    });
  }
  exit() {
    this.route.navigateByUrl('/exitPage');
  }
}
