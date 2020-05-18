import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddNewEditEmployeeComponent } from './add-new-edit-employee.component';

describe('AddNewEditEmployeeComponent', () => {
  let component: AddNewEditEmployeeComponent;
  let fixture: ComponentFixture<AddNewEditEmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddNewEditEmployeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddNewEditEmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
