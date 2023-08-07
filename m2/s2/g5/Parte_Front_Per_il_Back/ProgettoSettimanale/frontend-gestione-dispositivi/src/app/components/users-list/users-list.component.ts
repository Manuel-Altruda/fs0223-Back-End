import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.scss']
})
export class UsersListComponent implements OnInit {
  users: any[] = [];

  constructor(private userService: ApiService) { }

  ngOnInit() {
    this.fetchUtenti();
  }

  fetchUtenti(): void {
    this.userService.getUtenti().subscribe(
      (data: any[]) => {
        this.users = data;
      },
      (error) => {
        console.error('Errore nel recupero degli utenti:', error);
      }
    );
  }

}
