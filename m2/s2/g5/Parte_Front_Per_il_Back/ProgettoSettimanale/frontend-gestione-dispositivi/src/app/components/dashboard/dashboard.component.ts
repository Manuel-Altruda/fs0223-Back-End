import { AuthServiceService } from './../../services/authservice.service';
import { Component } from '@angular/core';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {
  username: string = '';
  userRole: string = '';
  constructor(private authService: AuthServiceService) {
    const userData = this.authService.getUser();
    this.username = userData ? userData.name : 'Guest';
    this.userRole = this.authService.getUserRole()!; // Recupera il ruolo dell'utente dal servizio di autenticazione
  }

  ngOnInit(): void {
    const role = this.authService.getUserRole();
    this.userRole = role ? role : '';
  }

  logout() {
    this.authService.logout();
  }

}
