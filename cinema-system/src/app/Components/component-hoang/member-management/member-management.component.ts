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
  // public members: Customer[];
  public members: Array<Customer> = [];
  public p: number = 1;
  public check: boolean = true;
  public checkDulicationData: boolean = true;
  public id: number;
  public searchText;
  public size = false;
  public array: Array<Customer> = [];
  public befor: number;
  public bodercolor: boolean = true;
  public birthday: string;
  public count = 0;
  public regexGender = /([N|n]am)|([N|n]u)/g;
  private regexBirthday = /(0[1-9]|[12][0-9]|3[01])[- \\/.](0[1-9]|1[012])[- \\/.](19|20)\\d\\d/g;
  private regexPhone = /(0[0-9]{8})/g;
  private regexIdCard = /([0-9]{9})/g;
  private regexFullName = /[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\s]+/g;
  private regexEmail = /\S+@\S+\.\S+/g;
  // public formAddnewMember: FormGroup;
  public formAddnewMember: FormControl;

  constructor(public userRegistrationService: UserRegistrationService,
              public userService: UserService,
              public notificationService: NotificationService,
              public datePipe: DatePipe) {
  }

  ngOnInit(): void {
    this.userRegistrationService.getAllAccounts().subscribe(data => {
      // this.members = data;
      for (const item of data) {
        item.checkFullName = true;
        item.checkBirthday = true;
        item.checkIdcard = true;
        item.checkGender = true;
        item.checkAddress = true;
        item.checkPhone = true;
        item.checkEmail = true;
        item.checkHide = true;
        this.members.push(item);
        this.array.push(item);
      }
      console.log(this.array);
      console.log(this.members);

      this.befor = this.members.length;
    });


  }

  edit(index) {
    this.bodercolor = !this.bodercolor;
    this.size = true;
    console.log(index);
    $(document).ready(function () {
      $("#edit" + index).hide();
      $("#add" + index).show();
    });
    this.members[index ].checkHide = false;
  }

  delete(id: number) {
    this.id = id

    this.userRegistrationService.deleteIdAccounts(id).subscribe(data => {
      console.log(data)
      // this.member= data
      for (let i = 0; i < this.members.length; i++) {
        if (this.members[i].id == this.id) {
          this.members.splice(i, 1)
          break;
          this.members[id-1].checkHide = true;
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
    this.members[index ].checkHide = true;
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
    let member = new Customer();
    console.log(this.befor)
    this.members.push(member);
    console.log(this.members.length);
    this.array.push(member)
    this.members[this.members.length-1].checkHide = false;
  }

  onSubmit() {

    let date1;
    for (let i = this.befor; i < this.array.length; i++) {
      console.log(this.array[i].gender)
      if (this.array[i].birthday != null) {
        const d = (this.array[i].birthday);
        const a = new Date(d);
        const b1 = this.datePipe.transform(a, 'yyyy-MM-dd');
        console.log(b1);
        date1 = formatDate(d);
      } else {
        date1 = "";
      }
      // || !this.array[i].fullName.match(this.regexFullName)
      //   || this.array[i].birthday.match(this.regexBirthday)
      //   || !this.array[i].gender.match(this.regexGender)
      //   || !this.array[i].idCard.match(this.regexIdCard)
      //   || !this.array[i].phone.match(this.regexPhone)
      //   console.log(this.array[i].phone.match(this.regexPhone))

      // console.log(this.array[i].gender.search(this.regexGender));
      if (this.array[i].fullName === null || !this.array[i].fullName.match(this.regexFullName)) {
        this.array[i].checkFullName = false;
      } else {
        this.array[i].checkFullName = true;
      }

      if (this.array[i].birthday === null) {
        this.array[i].checkBirthday = false
      } else {
        this.array[i].checkBirthday = true
      }

      if (this.array[i].email === null || this.array[i].gender.match(this.regexEmail)) {
        this.array[i].checkEmail = false
      } else {
        this.array[i].checkEmail = true;
      }

      if (this.array[i].gender === null || !this.array[i].gender.match(this.regexGender)) {

        this.array[i].checkGender = false
      } else {
        this.array[i].checkGender = true;

      }


      if (this.array[i].address === null) {
        this.array[i].checkAddress = false
      } else {
        this.array[i].checkAddress = true
      }


      if (this.array[i].idCard === null || !this.array[i].idCard.match(this.regexIdCard)) {
        this.array[i].checkIdcard = false
      } else {
        this.array[i].checkIdcard = true
      }
      console.log(!this.array[i].idCard.match(this.regexIdCard));

      if (this.array[i].phone === null || !this.array[i].phone?.match(this.regexPhone)) {
        this.array[i].checkPhone = false
      } else {
        this.array[i].checkPhone = true
      }
      console.log(this.array[i].checkFullName, this.array[i].checkBirthday, this.array[i].checkAddress, this.array[i].checkPhone,
        this.array[i].checkEmail, this.array[i].checkGender, this.array[i].checkIdcard)
      if (!this.array[i].checkFullName || !this.array[i].checkBirthday || !this.array[i].checkAddress || !this.array[i].checkPhone
        || !this.array[i].checkEmail || !this.array[i].checkGender || !this.array[i].checkIdcard) {
        console.log(this.array[i].checkFullName);
        console.log(this.array[i].checkBirthday);
        console.log(this.array[i].checkAddress);
        console.log(this.array[i].checkPhone);
        console.log(this.array[i].checkEmail);
        console.log(this.array[i].checkGender);
        console.log(this.array[i].checkIdcard);
        console.log('heloo');

      } else {
        this.checkDulicationData = false;
        for (let item of this.members) {
          // if (((item['idCard'] == this.members[i].idCard) || (item['email'] == this.members[i].email))&&(item['id']!=this.members[i].id)) {
          if ((item['idCard'] == this.members[i]?.idCard)&&(item['id']!=this.members[i].id)) {
            console.log(item['idCard']);
            console.log(this.members[i].idCard);
            console.log("item['id']: ",item['id']);
            console.log("this.members[i].id: ",this.members[i].id);
            this.checkDulicationData = true;
            this.members[i].checkIdcard = false;
            console.log(i);
            // alert("số chứng minh đã tồn tại!");
            return;
          }
          if ((item['phone'] == this.members[i]?.phone)&&(item['id']!=this.members[i].id)){
            this.members[i].checkPhone = false;
          }
        }

        if (!this.checkDulicationData) {
          const value = {
            fullName: this.array[i].fullName,
            gender: this.array[i].gender,
            idCard: this.array[i].idCard,
            email: this.array[i].email,
            phone: this.array[i].phone,
            address: this.array[i].address,
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
          this.userService.addCustomer(value).subscribe(data => {
            this.array.splice(i, 1);
            data.checkIdcard=true;
            data.checkPhone = true;
            this.members.splice(i,1,data);
            console.log(this.members[i]);
          });
          this.notificationService.warn('thêm mới thành công!');
        }
      }
    }
    if (this.count != 0) {
      alert("du lieu sa")
    }
  }

}
