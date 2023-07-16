package com.Week_Project.classes;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


/*Questa classe è un'aggiunta extra dell'esercizio*/

@Entity
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Utente utente;
    
    @ManyToOne
    private ElementoCatalogo elementoPrenotato;
    
    private Date dataPrenotazione;
    
    public Prenotazione() {}

    public Prenotazione(Utente utente, ElementoCatalogo elementoPrenotato, Date dataPrenotazione) {
        this.utente = utente;
        this.elementoPrenotato = elementoPrenotato;
        this.dataPrenotazione = dataPrenotazione;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoCatalogo getElementoPrenotato() {
        return elementoPrenotato;
    }

    public void setElementoPrenotato(ElementoCatalogo elementoPrenotato) {
        this.elementoPrenotato = elementoPrenotato;
    }

    public Date getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(Date dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }
}
