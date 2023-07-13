package com.EventManagement.classes;
import java.util.Date;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Evento.getPartiteVinteInCasa", query = "SELECT e FROM PartitaDiCalcio e WHERE e.squadraVincente = e.squadraDiCasa")
@NamedQuery(name = "Evento.getPartiteVinteInTrasferta", query = "SELECT e FROM PartitaDiCalcio e WHERE e.squadraVincente = e.squadraOspite")
@NamedQuery(name = "Evento.getPartitePareggiate", query = "SELECT e FROM PartitaDiCalcio e WHERE e.squadraVincente IS NULL")
public class PartitaDiCalcio extends Evento {

    private String squadraDiCasa;
    private String squadraOspite;
    private String squadraVincente; // null se pareggio
    private int numeroGolSquadraDiCasa;
    private int numeroGolSquadraOspite;

    // Costruttori, getters e setters

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, String squadraDiCasa, String squadraOspite, String squadraVincente, int numeroGolSquadraDiCasa, int numeroGolSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGolSquadraDiCasa() {
        return numeroGolSquadraDiCasa;
    }

    public void setNumeroGolSquadraDiCasa(int numeroGolSquadraDiCasa) {
        this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
    }

    public int getNumeroGolSquadraOspite() {
        return numeroGolSquadraOspite;
    }

    public void setNumeroGolSquadraOspite(int numeroGolSquadraOspite) {
        this.numeroGolSquadraOspite = numeroGolSquadraOspite;
    }
}

