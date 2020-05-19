import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {TokenStorageService} from "./Components/component-vu/service/token-storage.service";
import {UserService} from "./Components/component-vu/service/user.service";
import {CookieService} from "ngx-cookie-service";
import {AuthServices} from "./Components/component-vu/service/auth.service"

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
  loadPage: false;
  showAdminBoard = false;
  end = 0;
  constructor(private tokenStorageService: TokenStorageService,
              private userService: UserService,
              private authService: AuthServices,
              private cookieService: CookieService,
              private router: Router) {
  }

  ngOnInit() {

    if (this.cookieService.check('data-access')) {
      this.tokenStorageService.saveToken(this.cookieService.get('data-access'));

    }
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    console.log(this.cookieService.getAll());

    if (this.isLoggedIn) {
      if (this.cookieService.check('username')) {
        this.userService.getUserByUserName(this.cookieService.get('username')).subscribe(data => {
          this.tokenStorageService.saveUser(data);
        });
      }
      if(this.tokenStorageService.getUser()===null){
        window.location.reload();
      }
      console.log(this.tokenStorageService.getUser())
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.userService.getAllCustomer().subscribe(data => {
        for (const item of data) {
          if (item['user'].id === user.id) {
            this.id = item.id;
          }
        }
      });
      console.log(this.id);
      this.username = user.username;
      this.showAdminBoard = this.roles.includes('ROLE_ADMIN');
      
      console.log(this.showAdminBoard);
    }
  }

  logout() {
    
    this.tokenStorageService.signOut();
    window.location.assign('login');
    this.cookieService.deleteAll();
    this.authService.isAuthorized = false;
  }
}
