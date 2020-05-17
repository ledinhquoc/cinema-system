import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DatepickerMinMaxComponent } from './datepicker-min-max.component';

describe('DatepickerMinMaxComponent', () => {
  let component: DatepickerMinMaxComponent;
  let fixture: ComponentFixture<DatepickerMinMaxComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DatepickerMinMaxComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DatepickerMinMaxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
