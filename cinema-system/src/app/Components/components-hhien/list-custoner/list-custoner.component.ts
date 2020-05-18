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
  public showAddButton = true;
  showUpdateButton = true;
  public isValid = true;
  public customers;
  public formAddNewCustomer: FormGroup;
  public customerArray: Array<Customer> =[];
  public customerArrayEdit: Array<Customer> = [];
  public customerArrayNews: Array<Customer> = [];

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
      this.customerArrayNews = [];
      this.customerArrayEdit = [];
      console.log(this.customerArray);
    });
  }

  changeHidden() {
    this.isValid = !this.isValid;
  }

  newRow() {
    const customerNew = new Customer();
    customerNew.isEdit = true;
    this.customerArray.push(customerNew);
    // this.showAddButton = false;
    // this.formAddNewCustomer = this.formBuilder.group({
    //   fullName: [''],
    //   birthday: [''],
    //   gender: [''],
    //   idCard: [''],
    //   email: [''],
    //   phone: [''],
    //   address: [''],
    //   isEdit: ['false'],
    //   user:[' ']
    // });
  }

  // addRow(index,customer) {
  //   // this.customerService.addCustomer(value).subscribe();
  //   customer.isEdit = false;
  //   this.customerArray[index] = customer;
  //   this.customerService.addCustomer(this.customerArray[index]).subscribe();
  //   // alert('success');
  //   // window.location.reload();
  //   this.showAddButton = true;
  // }


  // this.customerArray[i].isEdit=!this.customerArray[i].isEdit;
  // this.showUpdateButton = !this.showUpdateButton;
  // if (this.customerArray[i].isEdit === false) {
  //   if (index !== null && index !== undefined) {
  //     this.customerService.editCustomer(customer, index).subscribe(data => {
  //     });
  //   }
  //   alert('updated')
  // }
  editRow(id, i, customer) {
    if (id !== null && id !== undefined) {
      this.customerArrayEdit.push(this.customerArray[i]);
    }
    this.customerArray[i].isEdit = !this.customerArray[i].isEdit;
    console.log(this.customerArrayEdit);

  }

  deleteRow(index, customer) {
    // this.customerArray.splice(index,1);
    this.customerService.deleteCustomer(index).subscribe();
    alert(`Deleted Customer : Name = ${customer.fullName} , id = ${customer.id} , `);
    window.location.reload();

  }

  saveAllCustomer() {
    if (this.customerArrayEdit != []) {
      console.log('save all oke');
      for (let i = 0; i < this.customerArrayEdit.length; i++) {
        if (this.customerArray[i].id == null) {
          this.customerArray.splice(i, 1);
        }
      }
      this.customerService.editCustomer(this.customerArrayEdit).subscribe(data => {
      });
    }
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.customerArray.length; i++) {
      if (this.customerArray[i].id == null) {
        this.customerArrayNews.push(this.customerArray[i]);
      }
    }
    if (this.customerArrayNews !== []) {
      this.customerService.addCustomer(this.customerArrayNews).subscribe(data => {
        console.log('okrr');
      });
    }
    // window.location.reload();


  }
}
