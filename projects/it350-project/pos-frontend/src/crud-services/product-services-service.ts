import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class ProductServicesService{
  constructor(private http: HttpClient) {
  }

  getAllProducts(): Observable<any[]> {
    return this.http.get<any[]>(`${environment.apiUrl}/products`, {responseType: 'json'});
  }

  deleteProduct(id: number): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/products/${id}`, {responseType: 'json'});
  }

  addProduct(product: any): Observable<any> {
    return this.http.post<any>(`${environment.apiUrl}/products`, product, {responseType: 'json'});
  }

  editProduct(id: number): Observable<any> {
    return this.http.put<any>(`${environment.apiUrl}/products`, id, {responseType: 'json'});
  }
}
