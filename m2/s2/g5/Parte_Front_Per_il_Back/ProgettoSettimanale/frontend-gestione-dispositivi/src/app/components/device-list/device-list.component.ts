import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.scss']
})
export class DeviceListComponent implements OnInit {
  device: any[] = [];

  constructor(private deviceService: ApiService) { }

  ngOnInit() {
    this.fetchDispositivi();
  }

  fetchDispositivi(): void {
    this.deviceService.getDispositivi().subscribe(
      (data: any[]) => {
        this.device = data;
      },
      (error) => {
        console.error('Errore nel recupero dei dispositivi:', error);
      }
    );
  }


}
