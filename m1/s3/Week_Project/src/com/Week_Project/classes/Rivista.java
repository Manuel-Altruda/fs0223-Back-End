package com.Week_Project.classes;

import javax.persistence.Entity;


@Entity
public class Rivista extends ElementoCatalogo {
    public enum Periodicita { SETTIMANALE, MENSILE, SEMESTRALE }
    
    private Periodicita periodicita;

    public Rivista() {}
    
    public Rivista(int isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super();
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
        this.periodicita = periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }
    
    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
    
    public void getIsbn(int isbn) {
        this.isbn = isbn;
    }
    
    public void setIsbn(Periodicita periodicita) {
        this.periodicita = periodicita;
    }
    
    
    
    
} 
