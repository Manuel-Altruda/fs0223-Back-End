import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthServiceService } from 'src/app/services/authservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  user: any = {
    username: '',
    password: ''
  };
  errorMessage: string = '';

  constructor(private authService: AuthServiceService, private router: Router) {}

  login() {
    this.authService.login(this.user.username, this.user.password).subscribe(
      (response) => {
        console.log('Risposta dal server:', response);
        this.router.navigate(['/dashboard']);

      },
      (error) => {
        console.error('Errore durante il login:', error);
        this.errorMessage = 'Credenziali non valide. Riprova.';
      }
    );
  }

}
