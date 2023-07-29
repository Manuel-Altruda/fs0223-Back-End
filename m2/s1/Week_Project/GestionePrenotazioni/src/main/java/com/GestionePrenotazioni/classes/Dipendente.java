package com.GestionePrenotazioni.classes;

import jakarta.persistence.*;

@Entity
@Table(name = "dipendente")
public class Dipendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false)
    private double stipendioBase;

    @Column(nullable = false)
    private double stipendioCalcolato;

    @ManyToOne
    @JoinColumn(name = "ruolo_id")
    private Ruolo ruolo;
    
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRuolo() {
		return nome;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

	public double getStipendioBase() {
		return stipendioBase;
	}

	public void setStipendioBase(double stipendioBase) {
		this.stipendioBase = stipendioBase;
	}

	public double getStipendioCalcolato() {
		return stipendioCalcolato;
	}

	public void setStipendio(double stipendioCalcolato) {
		this.stipendioCalcolato = stipendioCalcolato;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setRuolo(String string) {
		this.ruolo = ruolo;
		
	}

	

	

	
	
}
