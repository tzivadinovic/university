import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class CashRegisterServicesService{
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any[]> {
    return this.http.get<any[]>(`${environment.apiUrl}/cash-registers`, {responseType: 'json'});
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/cash-registers/${id}`, {responseType: 'json'});
  }

  add(cashRegister: any): Observable<any> {
    return this.http.post<any>(`${environment.apiUrl}/cash-registers`, cashRegister, {responseType: 'json'});
  }

  edit(id: number): Observable<any> {
    return this.http.put<any>(`${environment.apiUrl}/cash-registers`, id, {responseType: 'json'});
  }
}
