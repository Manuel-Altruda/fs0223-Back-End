package com.SistemaAntiIncendio.Spring.data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alarms") 
public class AlarmData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_sonda")
    private String idSonda;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "smoke_level")
    private double smokeLevel;
    public AlarmData(String idSonda, double latitude, double longitude, double smokeLevel) {
        this.setIdSonda(idSonda);
        this.setLatitude(latitude);
        this.setLongitude(longitude);
        this.setSmokeLevel(smokeLevel);
    }

	public String getIdSonda() {
		return idSonda;
	}

	public void setIdSonda(String idSonda) {
		this.idSonda = idSonda;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getSmokeLevel() {
		return smokeLevel;
	}

	public void setSmokeLevel(double smokeLevel) {
		this.smokeLevel = smokeLevel;
	}

    
}	
