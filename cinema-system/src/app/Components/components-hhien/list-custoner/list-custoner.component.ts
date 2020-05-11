import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {CustomerService} from '../../../Services/customer.service';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import {Customer} from '../customer';

@Component({
  selector: 'app-list-custoner',
  templateUrl: './list-custoner.component.html',
  styleUrls: ['./list-custoner.component.css']
})
export class ListCustonerComponent implements OnInit {
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


  delete(customer: Customer) {

  }

  newRow() {
   this.customerArray.push(new Customer());
  }



  edit(index) {
   this.customerService.editCustomer(this.customerArray[index],index-1).subscribe()
  }

  addRow(index) {
    this.customerService.addCustomer(this.customerArray[index]).subscribe()
  }
}
