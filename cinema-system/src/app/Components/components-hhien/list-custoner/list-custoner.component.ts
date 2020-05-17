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
  public customerArray: Array<Customer>;
  public customerArrayEdit :Array<Customer>;
  public customerArrayNews :Array<Customer>;

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
  }

  changeHidden() {
    this.isValid = !this.isValid;
  }

  newRow() {
    const customerNew = new Customer();
    customerNew.isEdit = true;
    this.customerArray.push(customerNew);
    this.showAddButton = false;
  }

  addRow(index,customer) {
    // this.customerService.addCustomer(value).subscribe();
    customer.isEdit = false;
    this.customerArray[index] = customer;
    this.customerService.addCustomer(this.customerArray[index]).subscribe();
    // alert('success');
    // window.location.reload();
    this.showAddButton = true;
  }

  editRow(index,i, customer) {
    this.customerArray[i].isEdit=!this.customerArray[i].isEdit;
    this.showUpdateButton = !this.showUpdateButton;
    if (this.customerArray[i].isEdit === false) {
      if (index !== null && index !== undefined) {
        this.customerService.editCustomer(customer, index).subscribe(data => {
        });
      }
      alert('updated')
    }
  }

  deleteRow(index,customer) {
    // this.customerArray.splice(index,1);
    this.customerService.deleteCustomer(index).subscribe();
    alert(`Deleted Customer : Name = ${customer.fullName} , id = ${customer.id} , `);
    window.location.reload();

  }
}
