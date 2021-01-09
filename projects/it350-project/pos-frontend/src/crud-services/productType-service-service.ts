import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class ProductTypeServiceService {
  constructor(private http: HttpClient) {
  }

  getAllProductTypes(): Observable<any[]> {
    return this.http.get<any[]>(`${environment.apiUrl}/product-types`, {responseType: 'json'});
  }
}
