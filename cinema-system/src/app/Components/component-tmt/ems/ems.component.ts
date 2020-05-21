import {Component, ViewChild, ElementRef, Renderer2, HostListener, OnInit} from '@angular/core';
import {DynamicGrid} from '../model/grid.model';
import {EmployeesService} from 'src/app/Services/employees.service';
// import {FormBuilder, FormGroup, FormArray, Validators} from '@angular/forms';
import {MatDialog} from '@angular/material/dialog';
import {DialogAddComponent} from './dialog-add/dialog-add.component';
import {DialogDeleteComponent} from './dialog-delete/dialog-delete.component';
import {interval} from 'rxjs';
import {FormControl, NgModel, NgForm} from '@angular/forms';

@Component({
  selector: 'app-ems',
  templateUrl: './ems.component.html',
  styleUrls: ['./ems.component.css']
})


export class EmsComponent implements OnInit {
  @ViewChild('fullName') fullName: ElementRef;

  constructor(public employeeService: EmployeesService,
              public dialog: MatDialog) {
  };

  dynamicArray: Array<DynamicGrid> = [];
  dynamicNews: Array<DynamicGrid> = [];
  dynamicEdits: Array<DynamicGrid> = [];
  public page = 1;
  search: string;
  isFocus: boolean = true;

  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe(data => {
      this.dynamicArray = data;
      this.dynamicNews = [];
      this.dynamicEdits = [];
      this.dynamicArray.forEach((item, index) => {
        this.dynamicArray[index].isEdit = false;
      });
    });
  }

  validate(): boolean {

    let patternEmail = new RegExp(/^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)$/);
    let patternFullName = new RegExp(/[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\s]+/);
    let patternIdCard = new RegExp(/([0-9]{9})/);
    let patternPhone = new RegExp(/^(0[0-9]{9})$/);
    let patternAdrress = new RegExp(/[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ\s]+/);

    if (this.dynamicNews.length === 0 && this.dynamicEdits.length === 0) {
      return false;
    }

    if (this.dynamicNews.length !== 0 || this.dynamicEdits.length !== 0) {
      for (let i = 0; i < this.dynamicArray.length; i++) {
        let checkEmail = patternEmail.test(this.dynamicArray[i].email);
        let checkFullName = patternFullName.test(this.dynamicArray[i].fullName);
        let checkIdCard = patternIdCard.test(this.dynamicArray[i].idCard);
        let checkPhone = patternPhone.test(this.dynamicArray[i].phone);
        let checkAddress = patternAdrress.test(this.dynamicArray[i].address);


        // end test
        if (!checkEmail || !checkFullName || !checkIdCard || !checkPhone || !checkAddress) {
          // this.dynamicArray[i]["isInvalid"]=true;
          return false;
        }

        if (this.dynamicArray[i].email.length == 0 || this.dynamicArray[i].fullName.length == 0
          || this.dynamicArray[i].address.length == 0 || this.dynamicArray[i].phone.length == 0
          || this.dynamicArray[i].idCard.length == 0) {
          return false;
        }
      }
    }

    return true;
  }

  delete(id, index) {
    if (id == null) {
      this.dynamicArray.splice(index, 1);
    } else {
      this.openDialogDelete().subscribe(confirmDelete => {
        if (confirmDelete) {
          this.employeeService.deleteEmployee(id).subscribe(result => {
            this.ngOnInit();
          }, error => console.error(error));
        }
      });
    }
  }

  edit(id, index) {
    if (id !== null || id !== undefined) {
      this.dynamicEdits.push(this.dynamicArray[index]);
    }
    this.dynamicArray[index].isEdit = !this.dynamicArray[index].isEdit;
  }

  addNew() {
    const dr = new DynamicGrid();
    this.dynamicArray.push(dr);

    for (let i = 0; i < this.dynamicArray.length; i++) {
      if (this.dynamicArray[i].id == null || this.dynamicArray[i].id == undefined) {
        this.dynamicNews.push(this.dynamicArray[i]);
      }
    }
    dr.isEdit = true;
  }

  save() {
    if (!this.validate()) {
      this.validate();
    } else {
      // xử lý trùng lặp
      const uniqueSetEdit = new Set(this.dynamicEdits);
      this.dynamicEdits = Array.from(uniqueSetEdit);

      if (this.dynamicEdits.length !== 0) {
        for (let i = 0; i < this.dynamicEdits.length; i++) {
          if (this.dynamicArray[i].id == null || this.dynamicArray[i].id == undefined) {
            this.dynamicArray.splice(i, 1);
          }
        }
        this.employeeService.editEmployee(this.dynamicEdits).subscribe(data => {
        });
      }

      // xử lý trùng lặp
      const uniqueSetAddNew = new Set(this.dynamicNews);
      this.dynamicNews = Array.from(uniqueSetAddNew);
      if (this.dynamicNews.length !== 0) {
        this.employeeService.addNewEmployee(this.dynamicNews).subscribe(data => {

        });
      }
      this.dynamicNews = [];
      this.openDialogSave().subscribe(result => {
        location.reload();
      });
    }
  }

  openDialogSave() {
    return this.dialog.open(DialogAddComponent).afterClosed();
  }

  openDialogDelete() {
    return this.dialog.open(DialogDeleteComponent).afterClosed();

  }

  forcusName(fullName,index) {
    this.fullName.nativeElement.forcus(fullName,index);
  }
}

