import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../environments/environment';

@Injectable({
  providedIn: 'root'
})

export class ProcurementServicesService{
  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any[]> {
    return this.http.get<any[]>(`${environment.apiUrl}/procurements`, {responseType: 'json'});
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/procurements/${id}`, {responseType: 'json'});
  }

  add(object: any): Observable<any> {
    return this.http.post<any>(`${environment.apiUrl}/procurements`, object, {responseType: 'json'});
  }

  edit(id: number): Observable<any> {
    return this.http.put<any>(`${environment.apiUrl}/procurements`, id, {responseType: 'json'});
  }
}
