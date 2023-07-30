package com.GestionePrenotazioni.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.classes.Postazione;
import com.GestionePrenotazioni.classes.Prenotazione;
import com.GestionePrenotazioni.classes.TipoPostazione;
import com.GestionePrenotazioni.repository.PostazioneRepository;
import com.GestionePrenotazioni.repository.PrenotazioneRepository;

@Service
public class PostazioneService {
	private final PostazioneRepository postazioneRepository;
	private final PrenotazioneRepository prenotazioneRepository;
	@Autowired
    public PostazioneService(PostazioneRepository postazioneRepository, PrenotazioneRepository prenotazioneRepository) {
        this.postazioneRepository = postazioneRepository;
        this.prenotazioneRepository = prenotazioneRepository;
	}

    public List<Postazione> cercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }
    
    public List<Postazione> trovaPostazioniPerEdificio(String citta, String nomeEdificio) {
        return postazioneRepository.findByEdificio_CittaAndEdificio_Nome(citta, nomeEdificio);
    }

    public List<Postazione> trovaPostazioniPerEdificio(String citta) {
        return postazioneRepository.findByEdificio_Citta(citta);
    }
    
    public Postazione getPostazioneById(Long id) {
        return postazioneRepository.findById(id).orElse(null);
    }
    
    /*EXTRA*/
    public boolean verificaDisponibilitaPostazione(Long postazioneId, Date dataPrenotazione) {
        Optional<Postazione> postazioneOptional = postazioneRepository.findById(postazioneId);

        if (postazioneOptional.isPresent()) {
            Postazione postazione = postazioneOptional.get();
            
            // Verifico se la data specificata rientra nei limiti di apertura e chiusura della postazione
            if (!verificaOrariAperturaChiusura(postazione, dataPrenotazione)) {
                return false; // La postazione non è disponibile per la data specificata
            }

            // Verifico se la postazione è stata prenotata per la data specificata
            List<Prenotazione> prenotazioni = prenotazioneRepository.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
            if (prenotazioni.isEmpty()) {
                return true; // La postazione è disponibile per la data specificata
            }
        }

        return false; // La postazione non esiste o non è stata trovata o è già prenotata per quella data
    }
   
    /*EXTRA*/
    private boolean verificaOrariAperturaChiusura(Postazione postazione, Date dataPrenotazione) {
       
    	// Ottengo l'orario di apertura e chiusura della postazione
        LocalTime orarioApertura = postazione.getOrarioApertura();
        LocalTime orarioChiusura = postazione.getOrarioChiusura();

        // Converto la data della prenotazione in LocalTime per poter confrontare gli orari
        LocalTime orarioPrenotazione = dataPrenotazione.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        // Verifico che l'orario di prenotazione sia compreso tra l'orario di apertura e chiusura
        if (orarioPrenotazione.isBefore(orarioApertura) || orarioPrenotazione.isAfter(orarioChiusura)) {
            return false; // La postazione non è disponibile per la data specificata
        }

        return true; // La postazione è disponibile per la data specificata
    }
    
    public List<Postazione> ricercaPostazioniAvanzataLvl2(TipoPostazione tipo, String citta, int capacitaMinima, Date dataPrenotazione) {
        return postazioneRepository.findByTipoAndEdificio_CittaAndNumeroMassimoOccupantiGreaterThanEqualAndIdNotIn(tipo, citta, capacitaMinima, getPrenotazioniPostazioniOccupate(dataPrenotazione));
    }
    
    /*EXTRA*/
    public List<Postazione> ricercaPostazioniAvanzata(TipoPostazione tipo, String citta, int capacitaMinima, Date dataPrenotazione) {
       
    	List<Postazione> postazioniFiltrate;

        // Filtro le postazioni in base al tipo
        if (tipo != null) {
            postazioniFiltrate = postazioneRepository.findByTipo(tipo);
        } else {
            postazioniFiltrate = postazioneRepository.findAll();
        }

        // Filtro le postazioni in base alla città
        if (citta != null && !citta.isEmpty()) {
            postazioniFiltrate = postazioneRepository.findByEdificio_Citta(citta);
        }

        // Filtro le postazioni in base alla capacità minima
        if (capacitaMinima > 0) {
            postazioniFiltrate.removeIf(postazione -> postazione.getNumeroMassimoOccupanti() < capacitaMinima);
        }

        // Filtro le postazioni in base alla disponibilità per la data specificata
        if (dataPrenotazione != null) {
            postazioniFiltrate.removeIf(postazione -> !verificaDisponibilitaPostazione(postazione, dataPrenotazione));
        }

        return postazioniFiltrate;
    }
    
    /*EXTRA*/
    private boolean verificaDisponibilitaPostazione(Postazione postazione, Date dataPrenotazione) {
        // Converto la data di prenotazione in LocalDate per facilitare i confronti
        LocalDate localDatePrenotazione = dataPrenotazione.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        if (postazione == null || postazione.getOrarioApertura() == null || postazione.getOrarioChiusura() == null) {
            return false;
        }
        
        // Verifo se la data di prenotazione rientra nei limiti di apertura e chiusura della postazione
        LocalTime orarioApertura = postazione.getOrarioApertura();
        LocalTime orarioChiusura = postazione.getOrarioChiusura();
        LocalTime orarioPrenotazione = dataPrenotazione.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        if (orarioPrenotazione.isBefore(orarioApertura) || orarioPrenotazione.isAfter(orarioChiusura)) {
            return false; // La postazione non è disponibile per la data specificata
        }

        // Verifico se la postazione è stata prenotata per la data specificata
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
        if (!prenotazioni.isEmpty()) {
            return false; // La postazione è già prenotata per la data specificata
        }

        return true; // La postazione è disponibile per la data specificata
    }
    
    public List<Postazione> ricercaPostazioniPerTipo(TipoPostazione tipo) {
        return postazioneRepository.findByTipo(tipo);
    }
    
    private List<Long> getPrenotazioniPostazioniOccupate(Date dataPrenotazione) {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findByDataPrenotazione(dataPrenotazione);
        List<Long> postazioniOccupateIds = new ArrayList<>();
        for (Prenotazione prenotazione : prenotazioni) {
            postazioniOccupateIds.add(prenotazione.getPostazione().getId());
        }
        return postazioniOccupateIds;
    }
    
    
    
    public Postazione salvaPostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }
}
