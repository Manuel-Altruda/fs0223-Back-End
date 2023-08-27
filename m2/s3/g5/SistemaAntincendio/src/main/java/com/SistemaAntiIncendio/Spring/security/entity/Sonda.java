package com.SistemaAntiIncendio.Spring.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Sonda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String id_sonda;
    private Double latitude;
    private Double longitude;
    private Integer smoke_level;
    
	public String getId_sonda() {
		return id_sonda;
	}
	public void setId_sonda(String id_sonda) {
		this.id_sonda = id_sonda;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Integer getSmoke_level() {
		return smoke_level;
	}
	public void setSmoke_level(Integer smoke_level) {
		this.smoke_level = smoke_level;
	}
}
