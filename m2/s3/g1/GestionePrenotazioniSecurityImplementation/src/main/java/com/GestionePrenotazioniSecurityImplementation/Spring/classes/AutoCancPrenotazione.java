package com.GestionePrenotazioniSecurityImplementation.Spring.classes;

import org.springframework.scheduling.annotation.Scheduled;

import com.GestionePrenotazioniSecurityImplementation.Spring.services.PrenotazioneService;

/*EXTRA*/
public class AutoCancPrenotazione {
	
	 private final PrenotazioneService prenotazioneService;

	 public AutoCancPrenotazione(PrenotazioneService prenotazioneService) {
	        this.prenotazioneService = prenotazioneService;
	    }

	 @Scheduled(cron = "0 0 0 * * ?") // Esegue il job ogni giorno a mezzanotte
	    public void cancellaPrenotazioniScadute() {
	        try {
	            prenotazioneService.cancellaPrenotazioniScadute();
	        } catch (Exception e) {
	           
	            e.printStackTrace();
	        }
	    }
	 
}
