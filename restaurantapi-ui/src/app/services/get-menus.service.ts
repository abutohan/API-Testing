import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Menu } from '../models/menu';

@Injectable({
  providedIn: 'root',
})
export class GetMenusService {
  private apiURL = 'http://localhost:8080/restaurant/api/v1/menu';

  constructor(private http: HttpClient) {}

  getMenu(): Observable<Menu[]> {
    return this.http.get<Menu[]>(this.apiURL);
  }
}
