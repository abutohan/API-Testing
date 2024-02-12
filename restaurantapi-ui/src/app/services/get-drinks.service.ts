import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Drink } from '../models/drink';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class GetDrinksService {
  private apiURL = 'http://localhost:8080/restaurant/api/v1/drinks';

  constructor(private http: HttpClient) {}

  getDrinks(): Observable<Drink[]> {
    return this.http.get<Drink[]>(this.apiURL);
  }
}
