import { TestBed } from '@angular/core/testing';

import { GetMainCoursesService } from './get-main-courses.service';

describe('GetMainCoursesService', () => {
  let service: GetMainCoursesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetMainCoursesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
