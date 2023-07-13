package com.EventManagement.classes;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Persona.getGareDiAtleticaPerVincitore", query = "SELECT p FROM GaraDiAtletica g JOIN g.vincitore p WHERE p = :vincitore")
@NamedQuery(name = "Persona.getGareDiAtleticaPerPartecipante", query = "SELECT p FROM GaraDiAtletica g JOIN g.setAtleti p WHERE p = :partecipante")
public class GaraDiAtletica extends Evento {

    @ManyToMany
    private Set<Persona> setAtleti;

    @ManyToOne
    private Persona vincitore;

    // Costruttori, getters e setters

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Set<Persona> setAtleti, Persona vincitore) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(Set<Persona> setAtleti) {
        this.setAtleti = setAtleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
}
