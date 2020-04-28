import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PromotionlistComponent } from './promotionlist.component';

describe('PromotionlistComponent', () => {
  let component: PromotionlistComponent;
  let fixture: ComponentFixture<PromotionlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PromotionlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PromotionlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
