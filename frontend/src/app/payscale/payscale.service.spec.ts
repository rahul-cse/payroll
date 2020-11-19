import { TestBed } from '@angular/core/testing';

import { PayscaleService } from './payscale.service';

describe('PayscaleService', () => {
  let service: PayscaleService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PayscaleService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
