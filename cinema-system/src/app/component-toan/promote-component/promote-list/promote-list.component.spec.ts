import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PromoteListComponent } from './promote-list.component';

describe('PromoteListComponent', () => {
  let component: PromoteListComponent;
  let fixture: ComponentFixture<PromoteListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PromoteListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PromoteListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
