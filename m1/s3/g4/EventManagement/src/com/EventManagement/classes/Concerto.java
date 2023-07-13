package com.EventManagement.classes;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    private GenereConcerto genere;

    private boolean inStreaming;

    // Costruttori, getters e setters

    public Concerto() {
    }

    public Concerto(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, GenereConcerto genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
