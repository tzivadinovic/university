import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class AddressServicesService{
  constructor(private http: HttpClient) {
  }

  getAllAddresses(): Observable<any[]> {
    return this.http.get<any[]>(`${environment.apiUrl}/addresses`, {responseType: 'json'});
  }

  deleteAddress(id: number): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/addresses/${id}`, {responseType: 'json'});
  }

  addAddress(address: any): Observable<any> {
    return this.http.post<any>(`${environment.apiUrl}/addresses`, address, {responseType: 'json'});
  }

  editAddress(id: number): Observable<any> {
    return this.http.put<any>(`${environment.apiUrl}/addresses`, id, {responseType: 'json'});
  }
}
