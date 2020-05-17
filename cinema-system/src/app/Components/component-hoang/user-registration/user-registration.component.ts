import { Component, OnInit } from '@angular/core';
import { UserRegistrationService } from '../../../Services/user-registration.service';
import {AbstractControl, FormGroup, FormBuilder, Validators} from '@angular/forms';
import { Router} from '@angular/router';
import {User} from '../model/user';
import {UserService} from "../../component-vu/service/user.service";
import {NotificationService} from "../../../Services/notification.service"
function comparePassword(c: AbstractControl) {
  const v = c.value;
  return (v.password === v.confirmPassword) ? null : {
    passwordnotmatch: true
  };
}
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
  public minDate = new Date(1920, 0, 1);
  show = true;
  check: boolean;
  constructor(public formBuilder: FormBuilder,
              public route: Router,
              public userRegistrationService: UserService,
              public notificationService: NotificationService) { }

  ngOnInit(): void {

    this.userRegistrationService.getAllCustomer().subscribe(da => {
      for (const s of da) {
        this.listUser.push(s);
      }
      console.log(this.listUser);
    });
    this.formAddnewAccount = this.formBuilder.group(
      {
        id: [],
        account: ['',[Validators.required, Validators.pattern('^[0-9a-zA-Z](\\w){5,20}$')]],
        pwGroup: this.formBuilder.group({
          password: ['', [Validators.required, Validators.minLength(6), Validators.pattern('^[0-9a-z]{6,12}$')]],
          confirmPassword: ['', [Validators.required]]
        }, {validator: comparePassword}),
        fullName: ['', [Validators.required]],
        birthday: ['',  [Validators.required]],
        idCard: ['',  [Validators.required, Validators.pattern('^[0-9]{9}$')]],
        address: ['', [Validators.required]],
        gender: ['', [Validators.required]],
        email: ['', [Validators.required, Validators.email]],
        phone: ['', [Validators.required, Validators.pattern('^(090|091)[0-9]{7}$')]],
        cb: [false, Validators.requiredTrue]
      }
    );
    this.check = false;
  }
  addNewAccount() {
    this.check = false;
    this.userRegistrationService.getAllCustomer().subscribe(data1 => {
      for (const item of data1) {
        console.log(item['user'].name)
        if (item['user'].name === this.formAddnewAccount.get('account').value) {
          this.check = true;
          return ;
        }
      }
      if (!this.check) {
        const value = {

          fullName: this.formAddnewAccount.get('fullName').value,
          gender: this.formAddnewAccount.get('gender').value,
          idCard: this.formAddnewAccount.get('idCard').value,
          email: this.formAddnewAccount.get('email').value,
          phone: this.formAddnewAccount.get('phone').value,
          address: this.formAddnewAccount.get('address').value,
          user: {

            password: this.formAddnewAccount.get('pwGroup').get('password').value,
            username: this.formAddnewAccount.get('account').value,
            roles: [
              {
                id: 2,
                name: 'ROLE_USER'
              }
            ]
          },
          birthday: this.formAddnewAccount.get('birthday').value
        }
        console.log(value)
        this.userRegistrationService.addCustomer(value).subscribe(data => {
          this.user = data;
          console.log(data);
          this.notificationService.warn('Đăng kí thành công,tài khoản của bạn đã là thành viên,' +
            'hãy đăng nhập để tham gia!');
          this.route.navigateByUrl('/login');
        });
      }

    });
  }
  exit() {
    this.route.navigateByUrl('/login');
  }
  toggleshow() {
    this.show = !this.show;
  }
}
