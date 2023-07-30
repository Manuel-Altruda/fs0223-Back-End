package com.GestionePrenotazioni.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.classes.Postazione;
import com.GestionePrenotazioni.classes.Prenotazione;
import com.GestionePrenotazioni.classes.Utente;
import com.GestionePrenotazioni.repository.PostazioneRepository;
import com.GestionePrenotazioni.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	
	private final PrenotazioneRepository prenotazioneRepository;
	private final PostazioneRepository postazioneRepository;
	
    @Autowired
    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository, PostazioneRepository postazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
		this.postazioneRepository = postazioneRepository;
    }

    public boolean effettuaPrenotazione(Utente utente, Postazione postazione, Date dataPrenotazione) {
    	if (utente == null || postazione == null || dataPrenotazione == null) {
            return false; // Controllo per evitare parametri nulli
        }
    	
    	List<Prenotazione> prenotazioniUtente = prenotazioneRepository.findByUtenteAndDataPrenotazione(utente, dataPrenotazione);
        List<Prenotazione> prenotazioniPostazione = prenotazioneRepository.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);

        if (!prenotazioniUtente.isEmpty() || !prenotazioniPostazione.isEmpty()) {
            return false; // L'utente o la postazione hanno già una prenotazione per quella data
        }
        
        if (dataPrenotazione.before(new Date())) {
            return false; // Non è possibile prenotare per date passate
        }
		return false;
        
    }
    
    /*logica interattiva*/
    public List<Prenotazione> getPrenotazioniSovrapposte(Postazione postazione, Date dataPrenotazione) {
        // Ottieni tutte le prenotazioni per la postazione specificata
        List<Prenotazione> prenotazioniPostazione = prenotazioneRepository.findByPostazione(postazione);

        // Filtra le prenotazioni sovrapposte
        List<Prenotazione> prenotazioniSovrapposte = new ArrayList<>();
        for (Prenotazione prenotazione : prenotazioniPostazione) {
            if (prenotazione.getDataPrenotazione().equals(dataPrenotazione)) {
                prenotazioniSovrapposte.add(prenotazione);
            }
        }

        return prenotazioniSovrapposte;
  } 
    
    public Prenotazione getPrenotazioneById(Long id) {
        return prenotazioneRepository.findById(id).orElse(null);
    }
    /*FINE*/
    

    
    /*EXTRA*/
        public boolean eliminaPrenotazione(Long prenotazioneId, Utente utenteAutenticato) {
            Optional<Prenotazione> prenotazioneOptional = prenotazioneRepository.findById(prenotazioneId);

            if (prenotazioneOptional.isPresent()) {
                Prenotazione prenotazione = prenotazioneOptional.get();
                if (prenotazione.getUtente().equals(utenteAutenticato)) {
                    prenotazioneRepository.delete(prenotazione);
                    return true;
                }
            }

            return false;
        }
       
        
        
        /*EXTRA*/

        public boolean aggiornaPrenotazione(Long prenotazioneId, Date nuovaDataPrenotazione, Postazione nuovaPostazione, Utente utenteAutenticato) {
            Optional<Prenotazione> prenotazioneOptional = prenotazioneRepository.findById(prenotazioneId);

            if (prenotazioneOptional.isPresent()) {
                Prenotazione prenotazione = prenotazioneOptional.get();
                
                if (prenotazione.getUtente().equals(utenteAutenticato)) {
                	
                    // Effettuo i controlli di validazione per la nuova data e postazione
                    if (nuovaDataPrenotazione == null || nuovaPostazione == null) {
                        return false; // Controlli di validazione falliti
                    }

                    prenotazione.setDataPrenotazione(nuovaDataPrenotazione);
                    prenotazione.setPostazione(nuovaPostazione);
                    prenotazioneRepository.save(prenotazione);
                    return true;
                }
            }

            return false;
    }
        /*EXTRA*/
        public List<Prenotazione> getPrenotazioniPassatePerUtente(Utente utente) {
        	
            // Ottengo la data odierna per fare un confronto
            Date dataOdierna = new Date();

            // Recupero l'elenco delle prenotazioni passate per l'utente specificato
            return prenotazioneRepository.findByUtenteAndDataPrenotazione(utente, dataOdierna);
        }
 
		
		/*EXTRA*/
		public Prenotazione aggiornaPrenotazione(Long prenotazioneId, Date newDataPrenotazione, Long newPostazioneId) {
		    Prenotazione prenotazione = prenotazioneRepository.findById(prenotazioneId)
		            .orElseThrow(() -> new NoSuchElementException("Prenotazione non trovata"));

		    if (newDataPrenotazione != null) {
		        prenotazione.setDataPrenotazione(newDataPrenotazione);
		    }

		    if (newPostazioneId != null) {
		        Postazione postazione = postazioneRepository.findById(newPostazioneId)
		                .orElseThrow(() -> new NoSuchElementException("Postazione non trovata"));
		        prenotazione.setPostazione(postazione);
		    }

		    try {
		        return prenotazioneRepository.save(prenotazione);
		    } catch (Exception e) {
		        
		        e.printStackTrace();
		        throw new RuntimeException("Errore durante l'aggiornamento della prenotazione.");
		    }
		}
		
		public Prenotazione aggiornaPrenotazione(Prenotazione prenotazione) {
	        Prenotazione prenotazioneEsistente = prenotazioneRepository.findById(prenotazione.getId())
	                .orElseThrow(() -> new NoSuchElementException("Prenotazione non trovata"));

	        prenotazioneEsistente.setUtente(prenotazione.getUtente());
	        prenotazioneEsistente.setPostazione(prenotazione.getPostazione());
	        prenotazioneEsistente.setDataPrenotazione(prenotazione.getDataPrenotazione());

	        return prenotazioneRepository.save(prenotazioneEsistente);
	    }
		
		/*EXTRA*/
		// Metodo per la cancellazione di una prenotazione
	    public void cancellaPrenotazione(Long prenotazioneId) {
	        Prenotazione prenotazione = prenotazioneRepository.findById(prenotazioneId)
	                .orElseThrow(() -> new NoSuchElementException("Prenotazione non trovata"));

	        // Effettuo controlli aggiuntivi per vedere se la prenotazione è già scaduta
	        Date now = new Date();
	        if (prenotazione.getDataPrenotazione().before(now)) {
	            throw new IllegalArgumentException("Impossibile cancellare una prenotazione scaduta.");
	        }

	        prenotazioneRepository.delete(prenotazione);
	    }
	    
	    public Prenotazione salvaPrenotazione(Prenotazione prenotazione) {
	        return prenotazioneRepository.save(prenotazione);
	    }
	    
	    /*EXTRA*/
	    
	    // Metodo per la cancellazione automatica delle prenotazioni scadute
	    
	    @Scheduled(cron = "0 0 0 * * *") // Esegui ogni giorno a mezzanotte
	    public void cancellaPrenotazioniScadute() {
	        Date now = new Date();
	        List<Prenotazione> prenotazioniScadute = prenotazioneRepository.findByDataPrenotazioneBefore(now);
	        prenotazioneRepository.deleteAll(prenotazioniScadute);
	    }
	    
	    /*EXTRA*/
	    public List<Prenotazione> ricercaPrenotazioniPerIntervalloDate(Date startDate, Date endDate) {
	        return prenotazioneRepository.findByDataPrenotazioneBetween(startDate, endDate);
	    }
}
