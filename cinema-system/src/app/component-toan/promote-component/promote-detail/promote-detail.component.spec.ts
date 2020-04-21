import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PromoteDetailComponent } from './promote-detail.component';

describe('PromoteDetailComponent', () => {
  let component: PromoteDetailComponent;
  let fixture: ComponentFixture<PromoteDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PromoteDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PromoteDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
