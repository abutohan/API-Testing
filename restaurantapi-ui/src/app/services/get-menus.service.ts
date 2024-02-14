import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Menu } from '../models/menu';
import { CONSTANTS } from 'src/environments/constants';

@Injectable({
  providedIn: 'root',
})
export class GetMenusService {
  private apiURL = `${CONSTANTS.DOMAIN}/${CONSTANTS.ENDPOINT_MENU}`;

  constructor(private http: HttpClient) {}

  getMenu(): Observable<Menu[]> {
    return this.http.get<Menu[]>(this.apiURL);
  }
}
