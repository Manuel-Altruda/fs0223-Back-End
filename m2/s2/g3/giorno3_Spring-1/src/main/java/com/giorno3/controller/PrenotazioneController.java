package com.giorno3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giorno3.classes.Prenotazione;
import com.giorno3.services.PrenotazioneService;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {
	
	public PrenotazioneService prenotazioneService;
	
	@GetMapping("/{id}")
    public ResponseEntity<Prenotazione> getPrenotazioneById(@PathVariable Long id) {
        Prenotazione prenotazione = prenotazioneService.trovaPrenotazionePerId(id);
        if (prenotazione != null) {
            return ResponseEntity.ok(prenotazione);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Prenotazione> createPrenotazione(@RequestBody Prenotazione prenotazione) {
        Prenotazione nuovaPrenotazione = prenotazioneService.salvaPrenotazione(prenotazione);
        return ResponseEntity.ok(nuovaPrenotazione);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prenotazione> updatePrenotazione(@PathVariable Long id, @RequestBody Prenotazione prenotazione) {
        Prenotazione prenotazioneEsistente = prenotazioneService.trovaPrenotazionePerId(id);
        if (prenotazioneEsistente != null) {
            prenotazione.setId(id);
            Prenotazione prenotazioneAggiornata = prenotazioneService.salvaPrenotazione(prenotazione);
            return ResponseEntity.ok(prenotazioneAggiornata);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrenotazione(@PathVariable Long id) {
        Prenotazione prenotazioneEsistente = prenotazioneService.trovaPrenotazionePerId(id);
        if (prenotazioneEsistente != null) {
            prenotazioneService.eliminaPrenotazione(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
}
