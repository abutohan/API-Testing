import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Appetizer } from '../models/appetizer';
import { CONSTANTS } from 'src/environments/constants';

@Injectable({
  providedIn: 'root',
})
export class GetAppetizersService {
  private apiURL = `${CONSTANTS.DOMAIN}/${CONSTANTS.ENDPOINT_APPETIZERS}`;

  constructor(private http: HttpClient) {}

  getAppetizers(): Observable<Appetizer[]> {
    return this.http.get<Appetizer[]>(this.apiURL);
  }
  getSingleAppetizers(id: number): Observable<Appetizer> {
    return this.http.get<Appetizer>(`${this.apiURL}/${id}`);
  }
}
