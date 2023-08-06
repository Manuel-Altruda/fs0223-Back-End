import { Component, OnInit } from '@angular/core';
import { Device } from 'src/app/models/device.model';
import { User } from 'src/app/models/user.model';
import { ApiService } from 'src/app/services/api.service';


@Component({
  selector: 'app-assegnazione',
  templateUrl: './assegnazione.component.html',
  styleUrls: ['./assegnazione.component.scss'],
})
export class AssegnazioneComponent implements OnInit {
  dispositivi: Device[] = [];
  utenti: User[] = [];
  selectedDeviceId: number | null = null;
  selectedUserId: number | null = null;

  constructor(private apiService: ApiService) {}

  ngOnInit(): void {
    this.caricaDispositivi();
    this.caricaUtenti();
  }

  caricaDispositivi(): void {
    this.apiService.getDispositivi().subscribe(
      (dispositivi) => {
        this.dispositivi = dispositivi;
      },
      (error) => {
        console.error('Errore nel caricamento dei dispositivi:', error);
      }
    );
  }

  caricaUtenti(): void {
    this.apiService.getUtenti().subscribe(
      (utenti) => {
        this.utenti = utenti;
      },
      (error) => {
        console.error('Errore nel caricamento degli utenti:', error);
      }
    );
  }

  assegnaDispositivo(): void {
    if (this.selectedDeviceId && this.selectedUserId) {
      const deviceId = this.selectedDeviceId;
      const userId = this.selectedUserId;

      this.apiService.assegnaDispositivo(deviceId, userId).subscribe(
        (response) => {
          console.log('Dispositivo assegnato con successo:', response);
          // Aggiornare lo stato dei dispositivi e degli utenti
          this.caricaDispositivi();
          this.caricaUtenti();
          // Reimposta i valori selezionati a null dopo l'assegnazione
          this.selectedDeviceId = null;
          this.selectedUserId = null;
        },
        (error) => {
          console.error('Errore durante l\'assegnazione del dispositivo:', error);
        }
      );
    }
  }

  rimuoviAssegnazione(): void {
    if (this.selectedDeviceId) {
      this.apiService.rimuoviAssegnazione(this.selectedDeviceId).subscribe(
        (response) => {
          console.log('Assegnazione del dispositivo rimossa con successo:', response);
          // Aggiornare lo stato dei dispositivi e degli utenti, se necessario
        },
        (error) => {
          console.error('Errore durante la rimozione dell\'assegnazione del dispositivo:', error);
        }
      );
    }
  }
}
