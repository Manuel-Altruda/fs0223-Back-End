package com.Week_Project.classes;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Utente utente;
    @ManyToOne
    private ElementoCatalogo elementoPrestato;
    private Date dataInizioPrestito;
    private Date dataRestituzionePrevista;
    private Date dataRestituzioneEffettiva;

    public Prestito() {}

    public Prestito(Utente utente, ElementoCatalogo elementoPrestato, Date dataInizioPrestito) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = calcolaDataRestituzionePrevista(dataInizioPrestito);
    }
    
    private Date calcolaDataRestituzionePrevista(Date dataInizioPrestito) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataInizioPrestito);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        return calendar.getTime();
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

    public ElementoCatalogo getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(ElementoCatalogo elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public Date getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(Date dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = calcolaDataRestituzionePrevista(dataInizioPrestito);
    }

    public Date getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(Date dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public Date getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(Date dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }
}
