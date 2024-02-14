import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Drink } from '../models/drink';
import { Observable } from 'rxjs';
import { CONSTANTS } from 'src/environments/constants';

@Injectable({
  providedIn: 'root',
})
export class GetDrinksService {
  private apiURL = `${CONSTANTS.DOMAIN}/${CONSTANTS.ENDPOINT_DRINKS}`;

  constructor(private http: HttpClient) {}

  getDrinks(): Observable<Drink[]> {
    return this.http.get<Drink[]>(this.apiURL);
  }
}
