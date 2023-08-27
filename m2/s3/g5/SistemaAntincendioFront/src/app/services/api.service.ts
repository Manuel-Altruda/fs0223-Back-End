import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {

  private apiUrl = 'http://localhost:8060/api/auth';

  constructor(private http: HttpClient) { }

  registerUser(newUser: any) {
    return this.http.post<any>(`${this.apiUrl}/user/register`, newUser);
  }

  loginUser(userData: any) {
    return this.http.post<any>(`${this.apiUrl}/login`, userData);
  }

  getUtenti(): Observable<any> {
    return this.http.get(`${this.apiUrl}/utenti`);
  }

  getSondeData(): Observable<any> {
    return this.http.get(`${this.apiUrl}/sonde`);
  }

}

