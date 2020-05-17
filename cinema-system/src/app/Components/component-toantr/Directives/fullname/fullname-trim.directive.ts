import { Directive, ElementRef, HostListener } from "@angular/core";

@Directive({
  selector: "[appFullnameTrim]",
})
export class FullnameTrimDirective {
  constructor(private el: ElementRef) {}

  @HostListener("focusin") onfocusin() {
    let value = this.el.nativeElement.value;
    value = (<string>value).trim();
    this.el.nativeElement.value = value;
  }
}
