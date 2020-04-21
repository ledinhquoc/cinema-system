import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeTickersPricesComponent } from './see-tickers-prices.component';

describe('SeeTickersPricesComponent', () => {
  let component: SeeTickersPricesComponent;
  let fixture: ComponentFixture<SeeTickersPricesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeeTickersPricesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeeTickersPricesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
