import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {AuthService, FacebookLoginProvider, SocialUser} from 'angularx-social-login';
import {Router} from '@angular/router';
import {User} from '../interface/user';
import {UserService} from '../service/user.service';
export interface Account {
  username: string;
  password: string;
}
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  formLogin: FormGroup;
  user: User;
  listUser: Array<User> = [];
  check: boolean;
  constructor(public OAuth: AuthService,
              private userService: UserService,
              private router: Router,
              private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.userService.getAllUser().subscribe(data => {
      for (const a of data) {
        this.listUser.push(a);
      }
    });
    this.formLogin = this.fb.group({
      username1: [null, Validators.required],
      password1: [null, Validators.required]
    });
    console.log(this.listUser);
  }


  isFieldValidUser(field: string): boolean {
    // this.check = false;
    return this.formLogin.get(field).touched && !this.formLogin.get(field).valid;
  }
  isFieldValidPassword(field: string) {
    return this.formLogin.get(field).touched && !this.formLogin.get(field).valid;
  }

  submitLogin() {
    if (this.formLogin.valid) {
      if (this.isValidName() && this.isValidPass()) {
        console.log('success');
        this.router.navigate(['/nextPage']);
      } else {
        this.check = true;
        console.log('fails');
      }
    } else {
      this.validateAllFormFields(this.formLogin);
    }
  }
  isValidName(): boolean {
    const username = this.formLogin.get('username1').value;
    for (const item of this.listUser) {
      if (item.username === username) {
        return true;
      }
    }
    return false;
  }

  isValidPass(): boolean {
    const pass = this.formLogin.get('password1').value;
    for (const item of this.listUser) {
      if (item.password === pass) {
        return true;
      }
    }
    return false;
  }
  Savesresponse(user: SocialUser) {
    this.userService.createUser(user).subscribe((res: any) => {
      console.log(res);
      this.user = res;
      localStorage.setItem('sinhvien', JSON.stringify(this.user));
      console.log(localStorage.setItem('sinhvien', JSON.stringify(this.user)));
      this.router.navigate(['/nextPage']);
    });
  }

  Login() {
    let socialPlatformProvider;
    socialPlatformProvider = FacebookLoginProvider.PROVIDER_ID;
    this.OAuth.signIn(socialPlatformProvider).then(socialusers => {
      console.log(socialusers);
      console.log(socialusers.id);
      if (this.userService.getUser(socialusers.id)) {
        this.router.navigate(['/nextPage']);
      } else {
        this.Savesresponse(socialusers);
      }
    });
  }

  validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      console.log(field);
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({ onlySelf: true });
      }
      // else if (control instanceof FormGroup) {
      //   this.validateAllFormFields(control);
      // }
    });
  }

}
