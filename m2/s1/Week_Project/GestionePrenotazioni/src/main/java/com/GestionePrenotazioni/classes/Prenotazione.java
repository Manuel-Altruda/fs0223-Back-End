package com.GestionePrenotazioni.classes;

import java.util.Date;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.*;

@Entity
public class Prenotazione {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")    
    private Utente utente;
    
    @ManyToOne
    @JoinColumn(name = "dipendente_id", nullable = false)
    private Dipendente dipendente;
    
    
    @ManyToOne
    @JoinColumn(name = "postazione_id", nullable = false)
    private Postazione postazione;
    
    @Column(nullable = false)
    private Date dataPrenotazione;
	
    public Prenotazione() {
    }
    
    public Prenotazione(Utente utente, Postazione postazione, Date dataPrenotazione) {
        this.utente = utente;
        this.postazione = postazione;
        this.dataPrenotazione = dataPrenotazione;
    }
    
	public Prenotazione(Dipendente dipendente, Postazione postazione, Date dataPrenotazione) {
		this.dipendente = dipendente;
		this.postazione = postazione;
        this.dataPrenotazione = dataPrenotazione;
	}

	public Long getId() {
        return id;
    }

    public Utente getUtente() {
        return utente;
    }
    
    public Dipendente getDipendente() {
        return dipendente;
    }

    
    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }

    public Date getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(Date dataPrenotazione2) {
        this.dataPrenotazione = dataPrenotazione2;
    }
}
