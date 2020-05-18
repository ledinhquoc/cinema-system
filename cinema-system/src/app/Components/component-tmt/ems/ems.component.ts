import {Component, OnInit} from '@angular/core';
import {DynamicGrid} from '../model/grid.model';
import {EmployeesService} from 'src/app/Services/employees.service';

@Component({
  selector: 'app-ems',
  templateUrl: './ems.component.html',
  styleUrls: ['./ems.component.css']
})
export class EmsComponent implements OnInit {

  constructor(public employeeService: EmployeesService) {
  };

  dynamicArray: Array<DynamicGrid> = [];
  dynamicNews: Array<DynamicGrid> = [];
  dynamicEdits: Array<DynamicGrid> = [];
  saveBoolean: boolean;

  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe(data => {
      this.dynamicArray = data;
      this.dynamicNews = [];
      this.dynamicEdits = [];
      this.saveBoolean = true;
      this.dynamicArray.forEach((item, index) => {
        this.dynamicArray[index].isEdit = false;
      });
    });
  }

  delete(id, index) {
    if (id == null) {
      this.dynamicArray.splice(index, 1);
      console.log(this.dynamicNews);
    } else {
      this.employeeService.deleteEmployee(id).subscribe(result => {
        this.ngOnInit();
      }, error => console.error(error));
    }
  }

  edit(id, index) {
    if (id !== null && id !== undefined) {
      this.dynamicEdits.push(this.dynamicArray[index]);
    }
    this.dynamicArray[index].isEdit = !this.dynamicArray[index].isEdit;
  }

  addNew() {
    let dr = new DynamicGrid();
    dr = new DynamicGrid();
    this.dynamicArray.push(dr);
    dr.isEdit = true;
  }

  save() {

    if (this.dynamicEdits != []) {
      for (let i = 0; i < this.dynamicEdits.length; i++) {
        if (this.dynamicArray[i].id == null) {
          this.dynamicArray.splice(i, 1);
        }
      }
      this.employeeService.editEmployee(this.dynamicEdits).subscribe(data => {
      });
    }

    for (let i = 0; i < this.dynamicArray.length; i++) {
      if (this.dynamicArray[i].id == null) {
        this.dynamicNews.push(this.dynamicArray[i]);
      }
    }

    if (this.dynamicNews != []) {
      this.employeeService.addNewEmployee(this.dynamicNews).subscribe(data => {
      });
    }

    location.reload();
  }
}

