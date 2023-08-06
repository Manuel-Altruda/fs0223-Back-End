import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-utenti-dispositivi',
  templateUrl: './utenti-dispositivi.component.html',
  styleUrls: ['./utenti-dispositivi.component.scss']
})
export class UtentiDispositiviComponent implements OnInit {

  utenti: any[] = [];
  dispositivi: any[] = [];

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.fetchUtenti();
    this.fetchDispositivi();
  }

  fetchUtenti(): void {
    this.apiService.getUtenti().subscribe(
      (data: any[]) => {
        this.utenti = data;
      },
      (error) => {
        console.error('Errore nel recupero degli utenti:', error);
      }
    );
  }

  fetchDispositivi(): void {
    this.apiService.getDispositivi().subscribe(
      (data: any[]) => {
        this.dispositivi = data;
      },
      (error) => {
        console.error('Errore nel recupero dei dispositivi:', error);
      }
    );
  }

}
