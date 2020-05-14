import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CustomerService} from '../../../Services/customer.service';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {Customer} from '../customer';


// tslint:disable-next-line:class-name
export interface user {
  id,
  password,
  username,
  status,
  roles: []
}

@Component({
  selector: 'app-list-custoner',
  templateUrl: './list-custoner.component.html',
  styleUrls: ['./list-custoner.component.css']
})
export class ListCustonerComponent implements OnInit {
  public isValid= true;
  p = 1;
  public customers;
  public formAddNewCustomer: FormGroup;
  public customerArray: Array<Customer>;

  constructor(public router: Router,
              public customerService: CustomerService,
              public formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.customerService.getAllCustomers().subscribe(data => {
      this.customers = data;
      console.log(this.customers);
    });
    this.customerService.getAllCustomers().subscribe(data => {
      this.customerArray = data;
      console.log(this.customerArray);
    });
    // this.formAddNewCustomer = this.formBuilder.group({
    //   id:[''],
    //   fullName:[''],
    //   birthday:[''],
    //   gender:[''],
    //
    // });
  }

  changeHidden() {
    this.isValid = !this.isValid;
  }

  delete(customer: Customer) {
  }

  newRow() {
    this.customerArray.push(new Customer());
  }

  // edit(index) {
  //   this.customerService.editCustomer(this.customerArray[index], index - 1).subscribe()
  // }
  addRow(index) {
    // console.log("good morning",this.customerArray[index]);
    // const value = {
    //   id: this.customerArray[index].id,
    //   fullName: this.customerArray[index].fullName,
    //   gender: this.customerArray[index].gender,
    //   idCard: this.customerArray[index].idCard,
    //   email: this.customerArray[index].email,
    //   phone: this.customerArray[index].phone,
    //   address: this.customerArray[index].address,
    //   birthday: this.customerArray[index].birthday,
    //   user: {
    //     password: '$2y$12$JwRpMe64v77SB.FpIL495OeWiyFLZUB95zZfZCQWCmADpexuSo9XK\n',
    //     username: this.customerArray[index].fullName + '123',
    //     status: false,
    //     roles: []
    //   }
    // };

    // this.customerService.addCustomer(value).subscribe();
    this.customerService.addCustomer(this.customerArray[index]).subscribe();
    // window.location.reload();
  }

  editRow(index) {
    this.customerService.editCustomer(this.customerArray[index],index+1).subscribe( data => {});
    alert('edited '+this.customerArray[index].id+this.customerArray[index].fullName );
  }

  deleteRow(index) {
    // this.customerArray.splice(index,1);
    this.customerService.deleteCustomer(index).subscribe();
    alert('deleted : ' + this.customerArray[index].fullName);
  }
}
