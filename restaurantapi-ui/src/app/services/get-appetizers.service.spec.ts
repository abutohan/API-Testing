import { TestBed } from '@angular/core/testing';

import { GetAppetizersService } from './get-appetizers.service';

describe('GetAppetizersService', () => {
  let service: GetAppetizersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetAppetizersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
