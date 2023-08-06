import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  private apiUrl = 'http://localhost:8080/api/auth';
  constructor(private http: HttpClient) { }

  registerUser(newUser: any) {
    return this.http.post<any>(`${this.apiUrl}/user/register`, newUser);
  }

  loginUser(userData: any) {
    return this.http.post<any>(`${this.apiUrl}/login`, userData);
  }

  assegnaDispositivo(deviceId: number, userId: number): Observable<any> {
    const url = `${this.apiUrl}/api/devices/${deviceId}/assign/${userId}`;
    return this.http.post<any>(url, {});
  }

  rimuoviAssegnazione(deviceId: number): Observable<any> {
    const url = `${this.apiUrl}/api/devices/${deviceId}/unassign`;
    return this.http.post<any>(url, {});
  }

  getUtenti(): Observable<any> {
    return this.http.get(`${this.apiUrl}/utenti`);
  }

  getDispositivi(): Observable<any> {
    return this.http.get(`${this.apiUrl}/dispositivi`);
  }
}
