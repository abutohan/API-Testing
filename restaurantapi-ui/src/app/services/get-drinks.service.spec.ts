import { TestBed } from '@angular/core/testing';

import { GetDrinksService } from './get-drinks.service';

describe('GetDrinksService', () => {
  let service: GetDrinksService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetDrinksService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
