import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeTicketPriceComponent } from './see-ticket-price.component';

describe('SeeTicketPriceComponent', () => {
  let component: SeeTicketPriceComponent;
  let fixture: ComponentFixture<SeeTicketPriceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeeTicketPriceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeeTicketPriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
