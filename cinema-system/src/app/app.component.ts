import { Component } from '@angular/core';
import {TokenStorageService} from "./Components/component-vu/service/token-storage.service";
import { Router} from "@angular/router";
import {UserService} from "./Components/component-vu/service/user.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'cinemaSystem';

  private roles: string[];
  isLoggedIn = false;
  username: string;
  id: number;
  constructor(private tokenStorageService: TokenStorageService,
              private userService: UserService) { }

  ngOnInit() {
    this.isLoggedIn = !!this.tokenStorageService.getToken();

    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.userService.getAllCustomer().subscribe(data => {
        for(const item of data){
          if(item['user'].id === user.id){
            this.id = item.id;
          }
        }
      });
      console.log(this.id);
      this.username = user.username;
    }
  }

  logout() {
    this.tokenStorageService.signOut();
    window.location.assign('login');
  }
}
