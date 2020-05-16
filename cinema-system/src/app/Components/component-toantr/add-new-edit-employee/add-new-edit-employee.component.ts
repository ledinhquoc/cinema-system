import { Router, ActivatedRoute } from "@angular/router";
import { Validators, AbstractControl } from "@angular/forms";
import { HttpService } from "./../../../Services/http.service";
import { FormGroup, FormControl } from "@angular/forms";
import { FormBuilder } from "@angular/forms";
import { Component, OnInit } from "@angular/core";
import { EmployeeUsernameAsyncValidatorDirective } from "../Directives/employee-username-async-validator/employee-username-async-validator.directive";
import { Location } from "@angular/common";

@Component({
  selector: "app-add-new-edit-employee",
  templateUrl: "./add-new-edit-employee.component.html",
  styleUrls: ["./add-new-edit-employee.component.css"],
})
export class AddNewEditEmployeeComponent implements OnInit {
  employeeForm: FormGroup;
  mode = "new"; // should not have value, TODO: revert when done testing
  minDate: Date;
  maxDate: Date;
  employee: any;
  isInvalidPassword = true;
  constructor(
    private form: FormBuilder,
    private myHttp: HttpService,
    private location: Location,
    private route: ActivatedRoute
  ) {
    const currentYear = new Date().getFullYear();
    this.minDate = new Date(currentYear - 40, 0, 1);
    this.maxDate = new Date(currentYear - 18, 11, 31);
  }

  ngOnInit(): void {
    this.employee = this.route.snapshot.data?.employee;
    this.mode = this.route.snapshot.data.mode;
    this.getEmployee()
      .then((emp) => {
        this.employee = emp;
        console.log("good afternoon", this.employee);
      })
      .then((result) => {
        this.employeeForm = this.initiateForm();
      });
  }

  getEmployee(): Promise<any> {
    if (!this.employee) {
      console.log("Hi, im in getEmployee() function!");
      if (this.mode === "new") {
        return this.myHttp.getOne("employees/new").toPromise();
      } else if (this.mode === "edit") {
        return this.myHttp.getById("employees", 1).toPromise();
      } else {
        console.log("getEmployee() says : unmatched 'mode'!", this.mode);
      }
    }
    return;
  }

  initiateForm(): FormGroup {
    return this.form.group({
      fullName: new FormControl(this.employee?.fullName || "", [
        Validators.required,
        // Validators.pattern(/^\X+[\s]?\X+[\D]+$/),
      ]),
      dateOfBirth: new FormControl(
        this.employee.dateOfBirth ? new Date(this.employee.dateOfBirth) : "",
        [Validators.required]
      ),
      gender: new FormControl(this.employee?.gender || "", [
        Validators.required,
      ]),
      idCard: new FormControl(this.employee?.idCard || "", [
        Validators.required,
        Validators.pattern(/^[\d]{9}$/),
      ]),
      email: new FormControl(this.employee?.email || "", [
        Validators.required,
        Validators.pattern(
          /^[a-zA-Z]{7,20}[\d]{0,3}\@[a-zA-Z]{2,5}\.[a-zA-Z]{2,7}$/
        ),
      ]),
      address: new FormControl(this.employee?.address || "", [
        Validators.required,
      ]),
      phone: new FormControl(this.employee?.phone || "", [
        Validators.required,
        Validators.pattern(/^[\d]{9,11}$/),
      ]),
      username: new FormControl(
        {
          value: this.employee?.users?.username || "",
          disabled: this.mode === "edit",
        },
        [Validators.required, Validators.pattern(/^[a-zA-Z\d]{5,15}$/)]
        // [new EmployeeUsernameAsyncValidatorDirective(this.myHttp).validate]
      ),
      password: new FormControl("", [
        // Validators.required,
        Validators.pattern(/^[\S]{5,15}$/),
      ]),
    });
  }
  previousPage() {
    this.location.back();
  }
  onRepeatPasswordChange(submitBtn, repeatedPassword) {
    let employeePassword = this.password.value;
    console.log("good evening", employeePassword);

    if (repeatedPassword.value !== employeePassword) {
      console.log("repeatedPassword.value", repeatedPassword.value);
      submitBtn.disabled = true;
      this.isInvalidPassword = true;
    } else {
      submitBtn.disabled = false;
      this.isInvalidPassword = false;
      console.log(
        "Hi, im here cus 2nd pw is matched w/ 1st pw. Im gonna print it out, checkout ur self",
        this.employeeForm
      );
    }
  }

  get username() {
    return this.employeeForm.get("username");
  }
  get password() {
    return this.employeeForm.get("password");
  }
  get fullName() {
    return this.employeeForm.get("fullName");
  }
  get gender() {
    return this.employeeForm.get("gender");
  }
  get email() {
    return this.employeeForm.get("email");
  }
  get idCard() {
    return this.employeeForm.get("idCard");
  }
  get phone() {
    return this.employeeForm.get("phone");
  }
  get address() {
    return this.employeeForm.get("address");
  }
}
