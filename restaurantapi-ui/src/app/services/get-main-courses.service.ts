import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MainCourse } from '../models/main-course';
import { CONSTANTS } from 'src/environments/constants';

@Injectable({
  providedIn: 'root',
})
export class GetMainCoursesService {
  private apiURL = `${CONSTANTS.DOMAIN}/${CONSTANTS.ENDPOINT_MAINCOURSES}`;

  constructor(private http: HttpClient) {}

  getMainCourse(): Observable<MainCourse[]> {
    return this.http.get<MainCourse[]>(this.apiURL);
  }
  getSingleMainCourse(id: number): Observable<MainCourse> {
    return this.http.get<MainCourse>(`${this.apiURL}/${id}`);
  }
}
