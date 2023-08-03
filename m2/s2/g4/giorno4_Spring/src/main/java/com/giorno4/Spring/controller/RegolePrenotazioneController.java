package com.giorno4.Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giorno4.Spring.classes.RegolePrenotazione;
import com.giorno4.Spring.services.RegolePrenotazioneService;

@RestController
@RequestMapping("/api")
public class RegolePrenotazioneController {
	
	@Autowired
    private RegolePrenotazioneService regolePrenotazioneService;

    @GetMapping("/regole-prenotazione")
    public ResponseEntity<RegolePrenotazione> getRegolePrenotazione(@RequestParam("lingua") String lingua) {
        String testoRegole = regolePrenotazioneService.getRegolePrenotazione(lingua);
        if (testoRegole.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        RegolePrenotazione response = new RegolePrenotazione();
        if (lingua.equalsIgnoreCase("italiano")) {
            response.setItaliano(testoRegole);
        } else {
            response.setInglese(testoRegole);
        }
        return ResponseEntity.ok(response);
    }
	
}
