import {Component, OnInit} from '@angular/core';
import {Customer} from "../model/user";
import {UserRegistrationService} from "../../../Services/user-registration.service"
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router, ActivatedRoute} from "@angular/router";
import {UserService} from "../../component-vu/service/user.service";
import {NotificationService} from "../../../Services/notification.service";
import {DatePipe} from "@angular/common";

declare var $: any;


function formatDate(date) {
  var d = new Date(date),
    day = '' + d.getDate(),
    month = '' + (d.getMonth() + 1),
    year = d.getFullYear();
  if (month.length < 2)
    month = '0' + month;
  if (day.length < 2)
    day = '0' + day;
  return [year, month, day].join('-');
}

@Component({
  selector: 'app-member-management',
  templateUrl: './member-management.component.html',
  styleUrls: ['./member-management.component.css']
})
export class MemberManagementComponent implements OnInit {
  public members: Customer[];
  public p: number = 1;
  public check: boolean = true;
  public checkvalid: boolean = true;
  public id: number;
  public member: Customer;
  public searchText;
  public size = false;
  public array = new Array();
  public befor: number;
  public bodercolor: boolean = true;
  public birthday: string;
  public count = 0;
  public position1: any;
  // public formAddnewMember: FormGroup;
  public formAddnewMember: FormControl;

  constructor(public userRegistrationService: UserRegistrationService,
              public formBuilder: FormBuilder,
              public activeRouter: ActivatedRoute,
              public userService: UserService,
              public notificationService: NotificationService,
              public datePipe: DatePipe) {
  }

  ngOnInit(): void {
    this.userRegistrationService.getAllAccounts().subscribe(data => {
      this.members = data;
      // console.log(this.members[1].user.status);
      this.befor = this.members.length;
    });


  }

  edit(index) {
    this.bodercolor = !this.bodercolor;
    console.log("abcxyz" + index);
    this.size = true;
    $(document).ready(function () {
      $("#edit" + index).hide();
      $("#add" + index).show();
    });
    // this.members[index].user.status = !this.members[index].user.status;


  }

  delete(id: number) {
    this.id = id
    this.userRegistrationService.deleteIdAccounts(id).subscribe(data => {
      console.log(data)
      // this.member= data
      console.log(this.members);
      for (let i = 0; i < this.members.length; i++) {
        if (this.members[i].id == this.id) {
          this.members.splice(i, 1)
          break;
        }
      }
    });
  }

  add(index) {
    this.bodercolor = !this.bodercolor;
    this.size = false;
    $(document).ready(function () {
      $("#edit" + index).show();
      $("#add" + index).hide();
    });
    const value = {
      id: this.members[index].id,
      fullName: this.members[index].fullName,
      gender: this.members[index].gender,
      idCard: this.members[index].idCard,
      email: this.members[index].email,
      phone: this.members[index].phone,
      address: this.members[index].address,
      birthday: this.members[index].birthday
    }
    this.userRegistrationService.putAccounts(value).subscribe(data => {
      this.notificationService.warn('chỉnh sửa thành công!');
    });
    // this.members[index].user.status = !this.members[index].user.status;
  }

  create() {
    console.log(this.befor)
    this.members.push(this.member = new Customer());
    console.log(this.members.length);

  }

  onSubmit() {
    let date1;
    for (let i = this.befor; i < this.members.length; i++) {

      if (this.members[i].birthday != null) {
        const d = (this.members[i].birthday);
        const a = new Date(d);
        const b1 = this.datePipe.transform(a, 'yyyy-MM-dd');
        console.log(b1);
        date1 = formatDate(d);
      } else {
        date1 = "";
      }
      if(this.members[i].fullName == null){
        this.members[i].checkFullName = false;
      }else if(this.members[i].birthday == null){
        this.members[i].CheckBirthday = false
      }else if(this.members[i].email == null){
        this.members[i].checkEmail = false
      }else if(this.members[i].gender == null){
        this.members[i].checkGender = false
      }else if(this.members[i].address == null){
        this.members[i].checkAddress = false
      }else if(this.members[i].idCard == null){
        this.members[i].checkIdcard = false
      }else if(this.members[i].phone == null){
        this.members[i].checkPhone = false
      }
      if (this.members[i].fullName == null || this.members[i].birthday == null || this.members[i].address == null || this.members[i].phone
        || this.members[i].email == null || this.members[i].gender == null || this.members[i].idCard == null) {
      } else {
        const value = {
          id: 100 + i,
          fullName: this.members[i].fullName,
          gender: this.members[i].gender,
          idCard: this.members[i].idCard,
          email: this.members[i].email,
          phone: this.members[i].phone,
          address: this.members[i].address,
          user: {
            password: 'hoang123456',
            username: 'hoangdeptrai',
            roles: [
              {
                id: 2,
                name: 'ROLE_USER'
              }
            ],
            status: false
          },
          birthday: date1

        }
        console.log(value)
        // this.array.push(value);
        this.userService.addCustomer(value).subscribe(data => {
          // this.members.push(data);
        });
        this.notificationService.warn('thêm mới thành công!');
      }

    }
    if (this.count != 0) {
      alert("du lieu sa")
    }
  }


  // stringToDate("9/17/2014","mm/dd/yyyy","/")
  // stringToDate("9-17-2014","mm-dd-yyyy","-")
}
