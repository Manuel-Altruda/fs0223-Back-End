import { AuthServiceService } from '../../services/authservice.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ApiService } from 'src/app/services/api.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {
  user: any = {
    name: '',
    lastname: '',
    email: '',
    username: '',
    password: ''
  };
  errorMessage: string = '';

  constructor(private authService: AuthServiceService,  private router: Router) {}

  register() {
    this.authService.register(this.user).subscribe(
      (response) => {
        console.log('Risposta dal server:', response);
        this.router.navigate(['/login']);
      },
      (error) => {
        console.error('Errore durante la registrazione:', error);
        this.errorMessage = 'Errore durante la registrazione. Riprova più tardi.';
      }
    );
  }
}
