import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  sondeData: any[] = [];

  constructor(private apiService: ApiService, private httpClient: HttpClient) {} // Inietta il servizio API

  ngOnInit(): void {
    this.fetchSondeData();
  }

  fetchSondeData() {
    const accessToken = 'eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJtYW5AZ20uY29tIiwiaWF0IjoxNjkzMTU1NTc4LCJleHAiOjE2OTQwMTk1Nzh9.kGOHiecDVHhV7y72Nmh34LzQ-Y4C37LdtLaQS3HQriuEgbHtiQ7DbDdJaoKBSGip'; // Replace with the actual access token
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${accessToken}`
    });

    this.httpClient.get('http://localhost:8060/api/auth/sonde', { headers }).subscribe(
      (response) => {
        // Handle successful response
        console.log('Sonde Data:', response);
      },
      (error) => {
        // Handle error
        console.error('Error fetching Sonde data:', error);
      }
    );
  }

}
