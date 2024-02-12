import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MainCourse } from '../models/main-course';

@Injectable({
  providedIn: 'root',
})
export class GetMainCoursesService {
  private apiURL = 'http://localhost:8080/restaurant/api/v1/main-courses';

  constructor(private http: HttpClient) {}

  getMainCourse(): Observable<MainCourse[]> {
    return this.http.get<MainCourse[]>(this.apiURL);
  }
}
