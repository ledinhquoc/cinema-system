import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BanVeComponent } from './ban-ve.component';

describe('BanVeComponent', () => {
  let component: BanVeComponent;
  let fixture: ComponentFixture<BanVeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BanVeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BanVeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
