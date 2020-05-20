import { AbstractControl, ValidationErrors } from "@angular/forms";
import { HttpService } from "../../../Services/http.service";

export class AsyncEmployeeValidator {
  constructor(private myHttp: HttpService) {}
  static async uniqueUsername(
    username: AbstractControl
  ): Promise<ValidationErrors | null> {
    let controlBind = this as any;
    let myHttp = controlBind.myHttp as HttpService;
    let employee = controlBind.employee;
    let mode = controlBind.mode;
    return new Promise((resolve) => {
      myHttp
        .getById("employees/check/user-name", username.value)
        .subscribe((isUniqueUsername) => {
          if (!isUniqueUsername) {
            if (mode === "add") {
              resolve({ takenUsername: true });
            } else if (
              mode === "edit" &&
              username.value !== employee.users.username
            ) {
              resolve({ takenUsername: true });
            }
          }
          resolve(null);
        });
    });
  }
  static async uniqueEmail(
    email: AbstractControl
  ): Promise<ValidationErrors | null> {
    let controlBind = this as any;
    let myHttp = controlBind.myHttp as HttpService;
    let employee = controlBind.employee;
    let mode = controlBind.mode;
    return new Promise((resolve) => {
      myHttp
        .getById("employees/check/email", email.value)
        .subscribe((isUniqueEmail) => {
          if (!isUniqueEmail) {
            if (mode === "add") {
              resolve({ takenEmail: true });
            } else if (mode === "edit" && email.value !== employee.email) {
              resolve({ takenEmail: true });
            }
          }
          resolve(null);
        });
    });
  }

  static async uniqueIdCard(
    idCard: AbstractControl
  ): Promise<ValidationErrors | null> {
    let controlBind = this as any;
    let myHttp = controlBind.myHttp as HttpService;
    let employee = controlBind.employee;
    let mode = controlBind.mode;
    return new Promise((resolve) => {
      myHttp
        .getById("employees/check-unique/id-card", idCard.value)
        .subscribe((isUniqueIdCard) => {
          if (!isUniqueIdCard) {
            if (mode === "add") {
              resolve({ takenIdCard: true });
            } else if (mode === "edit" && idCard.value !== employee.idCard) {
              resolve({ takenIdCard: true });
            }
          }
          resolve(null);
        });
    });
  }
}
