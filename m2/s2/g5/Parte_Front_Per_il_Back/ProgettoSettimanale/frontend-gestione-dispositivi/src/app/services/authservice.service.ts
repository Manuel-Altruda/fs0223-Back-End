import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable} from 'rxjs';
import { User } from '../interface/user';


@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  private currentUserSubject: BehaviorSubject<User | null>;;//aggiunta in caso di bug delete
  public currentUser: Observable<User | null>;//aggiunta in caso di bug delete


  private apiUrl = 'http://localhost:8080/api/auth';
  private token: string | null = null;
  private userRole: string = '';
  user: string = "${user}";

  constructor(private http: HttpClient) {
    this.currentUserSubject = new BehaviorSubject<User | null>(null);//aggiunta in caso di bug delete
    this.currentUser = this.currentUserSubject.asObservable();//aggiunta in caso di bug delete
  }

 // registerUser(newUser: any) {
 //   return this.http.post<any>(`${this.apiUrl}/user/register`, newUser);
 // }

 register(user: any): Observable<any> {
  const registerUrl = `${this.apiUrl}/register`;
  return this.http.post(registerUrl, user);
}

login(username: string, password: string): Observable<User> { // ho aggiunto User al posto di any in caso di bug
  const loginUrl = `${this.apiUrl}/login`;
  return this.http.post<any>(loginUrl, { username, password });


}

  logout(): void {
    // Rimuovi i dati dal localStorage
    localStorage.removeItem('token');
    localStorage.removeItem('userRole');

  }

  loginUser(userData: any) {
    return this.http.post<any>(`${this.apiUrl}/login`, userData);
  }

  // Salva il token JWT nel localStorage dopo il login
  saveToken(token: string): void {
    localStorage.setItem('accessToken', token);
  }

  getUserRole() {
    return this.userRole || localStorage.getItem('userRole');
  }

  getUser(): any {
    return this.user;
  }

  // Recupera il token JWT dal localStorage
  getToken(): string | null {
    return this.token || localStorage.getItem('accessToken');
  }

  // Rimuove il token JWT dal localStorage dopo il logout
  removeToken(): void {
    localStorage.removeItem('accessToken');
  }

  isLoggedIn(): boolean {
    return !!this.getToken();
  }

  registerUser(newUser: any) {
    return this.http.post<any>(`${this.apiUrl}/user/register`, newUser);
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



  public get currentUserValue(): User | null {
    return this.currentUserSubject.value;
  }

}
