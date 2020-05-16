import { Location } from "@angular/common";
import { Component, OnInit } from "@angular/core";
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
  ValidationErrors,
} from "@angular/forms";
import { ActivatedRoute } from "@angular/router";
import { Observable } from "rxjs";
import { HttpService } from "./../../../Services/http.service";
import { AsyncEmployeeValidator } from "./../validators/async-employee.validators";
import { HttpErrorResponse } from "@angular/common/http";

@Component({
  selector: "app-add-new-edit-employee",
  templateUrl: "./add-new-edit-employee.component.html",
  styleUrls: ["./add-new-edit-employee.component.css"],
})
export class AddNewEditEmployeeComponent implements OnInit {
  employeeForm: FormGroup;
  mode: string; // should not have value, TODO: revert when done testing
  minDate: Date;
  maxDate: Date;
  employee: any;
  isInvalidPassword = true;
  taskComplete = false;
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
      })
      .then((result) => {
        this.employeeForm = this.initiateForm();
      });
  }

  getEmployee(): Promise<any> {
    if (!this.employee) {
      if (this.mode === "new") {
        return this.myHttp.getOne("employees/new").toPromise();
      } else if (this.mode === "edit") {
        return this.myHttp.getById("employees", 11).toPromise();
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
        this.employee?.dateOfBirth ? new Date(this.employee.dateOfBirth) : "",
        [Validators.required]
      ),
      gender: new FormControl(this.employee?.gender || "", [
        Validators.required,
      ]),
      idCard: new FormControl(this.employee?.idCard || "", [
        Validators.required,
        Validators.pattern(/^[\d]{9}$/),
      ]),
      email: new FormControl(
        this.employee?.email || "",
        [
          Validators.required,
          Validators.pattern(
            /^[a-zA-Z]{7,20}[\d]{0,3}\@[a-zA-Z]{2,5}\.[a-zA-Z]{2,7}$/
          ),
        ],
        this.mode === "new"
          ? [AsyncEmployeeValidator.uniqueEmail.bind(this)]
          : null
      ),
      address: new FormControl(this.employee?.address || "", [
        Validators.required,
      ]),
      phone: new FormControl(this.employee?.phone || "", [
        Validators.required,
        Validators.pattern(/^[\d]{9,11}$/),
      ]),
      username: new FormControl(
        this.employee?.users?.username || "",
        [Validators.required, Validators.pattern(/^[a-zA-Z\d]{5,15}$/)],
        this.mode === "new"
          ? [AsyncEmployeeValidator.uniqueUsername.bind(this)]
          : null
      ),
      password: new FormControl(
        "",
        this.mode === "new"
          ? [Validators.required, Validators.pattern(/^[\S]{5,15}$/)]
          : [Validators.pattern(/^[\S]{5,15}$/)]
      ),
    });
  }
  previousPage() {
    this.location.back();
  }
  onRepeatPasswordChange(submitBtn, repeatedPassword) {
    let employeePassword = this.password.value;

    if (repeatedPassword.value !== employeePassword) {
      submitBtn.disabled = true;
      this.isInvalidPassword = true;
    } else {
      submitBtn.disabled = this.employeeForm.invalid;
      this.isInvalidPassword = false;
    }
  }

  submitEmployee() {
    console.log(this.employeeForm);
    let { username, password } = this.employeeForm.value;

    this.employee.users = {
      id: this.employee.users?.id || 0,
      username,
      password: password ? password : this.employee.users.password,
    };
    this.employee.address = this.address.value;
    this.employee.dateOfBirth = this.employeeForm.get("dateOfBirth").value;
    this.employee.email = this.email.value;
    this.employee.fullName = this.fullName.value;
    this.employee.gender = this.gender.value;
    this.employee.idCard = this.idCard.value;
    this.employee.phone = this.phone.value;

    let result: Observable<any>;

    switch (this.mode) {
      case "new":
        result = this.myHttp.post("employees/new/saved", this.employee);
        break;
      case "edit":
        result = this.myHttp.update("employees/edit/saved", this.employee);
        break;
      default:
        console.log(
          "No matching value of " +
            this.mode +
            " mode.Check switch-case at 156L"
        );
    }
    result.subscribe(
      (result) => {
        console.log(result);
        this.taskComplete = true;
      },
      (httpError: HttpErrorResponse) => {
        console.log("Error Occurred: ", httpError.error);

        if (httpError.status === 406) {
          let fieldErrors = httpError.error;
          for (let prop in fieldErrors) {
            //fieldErrors[prop]->"email.pattern"
            let errorCode = (<string>fieldErrors[prop]).split(".");
            let errorObj = {};
            errorObj[errorCode[1]] = true;
            this.employeeForm.get(errorCode[0]).setErrors(errorObj);
          }
        }
      }
    );
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
  get dateOfBirth() {
    return this.employeeForm.get("dateOfBirth");
  }
}
