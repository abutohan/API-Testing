import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Appetizer } from '../models/appetizer';

@Injectable({
  providedIn: 'root',
})
export class GetAppetizersService {
  private apiURL = 'http://localhost:8080/restaurant/api/v1/appetizers';

  constructor(private http: HttpClient) {}

  getAppetizers(): Observable<Appetizer[]> {
    return this.http.get<Appetizer[]>(this.apiURL);
  }
}
