package com.giorno4.Spring.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RegolePrenotazioneService {

	 @Value("${regole.prenotazione.italiano}")
	    private String regolePrenotazioneItaliano;

	    @Value("${regole.prenotazione.inglese}")
	    private String regolePrenotazioneInglese;
	    
	    
	    public String getRegolePrenotazione(String lingua) {
	    	
	        if (lingua.equalsIgnoreCase("italiano")) {
	            return regolePrenotazioneItaliano;
	            
	        } else if (lingua.equalsIgnoreCase("inglese")) {
	            return regolePrenotazioneInglese;
	            
	        } else {
	            throw new IllegalArgumentException("Lingua non supportata: " + lingua);
	        }
	    }
	
}
