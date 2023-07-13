package com.EventManagement.classes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Persona.getEventiSoldOut", query = "SELECT p FROM Persona p JOIN p.listaPartecipazioni lp JOIN lp.evento e WHERE lp.stato = :stato AND e.numeroMassimoPartecipanti = (SELECT COUNT(p) FROM Partecipazione p WHERE p.evento = e AND p.stato = :stato)")
@NamedQuery(name = "Persona.getEventiPerInvitato", query = "SELECT p FROM Persona p JOIN p.listaPartecipazioni lp JOIN lp.evento e WHERE lp.stato = :stato AND p = :invitato")
public class Persona {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String nome;
	    private String cognome;
	    private String email;

	    @Temporal(TemporalType.DATE)
	    private Date dataDiNascita;

	    @Enumerated(EnumType.STRING)
	    private Sesso sesso;

	    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
	    @OrderBy("dataEvento ASC")
	    private List<Partecipazione> listaPartecipazioni;

	    // Costruttori, getters e setters

	    public Persona() {
	    }

	    public Persona(String nome, String cognome, String email, Date dataDiNascita, Sesso sesso) {
	        this.nome = nome;
	        this.cognome = cognome;
	        this.email = email;
	        this.dataDiNascita = dataDiNascita;
	        this.sesso = sesso;
	        this.listaPartecipazioni = new ArrayList<>();
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getCognome() {
	        return cognome;
	    }

	    public void setCognome(String cognome) {
	        this.cognome = cognome;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public Date getDataDiNascita() {
	        return dataDiNascita;
	    }

	    public void setDataDiNascita(Date dataDiNascita) {
	        this.dataDiNascita = dataDiNascita;
	    }

	    public Sesso getSesso() {
	        return sesso;
	    }

	    public void setSesso(Sesso sesso) {
	        this.sesso = sesso;
	    }

	    public List<Partecipazione> getListaPartecipazioni() {
	        return listaPartecipazioni;
	    }

	    public void setListaPartecipazioni(List<Partecipazione> listaPartecipazioni) {
	        this.listaPartecipazioni = listaPartecipazioni;
	    }

	    public void addPartecipazione(Partecipazione partecipazione) {
	        listaPartecipazioni.add(partecipazione);
	        partecipazione.setPersona(this);
	    }

	    public void removePartecipazione(Partecipazione partecipazione) {
	        listaPartecipazioni.remove(partecipazione);
	        partecipazione.setPersona(null);
	    }
	}

