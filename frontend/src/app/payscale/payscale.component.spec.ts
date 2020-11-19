import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PayscaleComponent } from './payscale.component';

describe('PayscaleComponent', () => {
  let component: PayscaleComponent;
  let fixture: ComponentFixture<PayscaleComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PayscaleComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PayscaleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
