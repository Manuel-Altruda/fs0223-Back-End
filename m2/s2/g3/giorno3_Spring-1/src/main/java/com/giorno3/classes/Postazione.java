package com.giorno3.classes;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Postazione {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String codice;

    @Column(nullable = false)
    private String descrizione;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPostazione tipo;

    @Column(nullable = false)
    private int numeroMassimoOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id", nullable = false)
    private Edificio edificio;

    private LocalTime orarioApertura;
    private LocalTime orarioChiusura;
	
    private Date dataDisponibile;
    private Date disponibile;
    
    public Postazione() {
    }
    
    public Postazione(String codice, String descrizione, TipoPostazione tipo, int numeroMassimoOccupanti, Edificio edificio) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numeroMassimoOccupanti = numeroMassimoOccupanti;
        this.edificio = edificio;
    }
    
    public Date isDisponibile() {
        return disponibile;
    }
    
    public void setDisponibile(Date disponibile) {
        this.disponibile = disponibile;
    }
    
	public LocalTime getOrarioApertura() {
        return orarioApertura;
    }

    public void setOrarioApertura(LocalTime orarioApertura) {
        this.orarioApertura = orarioApertura;
    }

    public LocalTime getOrarioChiusura() {
        return orarioChiusura;
    }

    public void setOrarioChiusura(LocalTime orarioChiusura) {
        this.orarioChiusura = orarioChiusura;
    }
    
    public int getNumeroMassimoOccupanti() {
        return numeroMassimoOccupanti;
    }

	public Long getId() {
		return this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getDataDisponibile() {
		return dataDisponibile;
	}

	public void setDataDisponibile(Date dataDisponibile) {
		this.dataDisponibile = dataDisponibile;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
