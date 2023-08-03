package com.giorno4.Spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giorno4.Spring.classes.Ruolo;
import com.giorno4.Spring.services.RuoloService;

@RestController
@RequestMapping("/api/ruoli")
public class RuoloController {
	
	public RuoloService ruoloService;
	
	@GetMapping("/{id}")
    public ResponseEntity<Ruolo> getRuoloById(@PathVariable Long id) {
        Ruolo ruolo = ruoloService.trovaRuoloPerId(id);
        if (ruolo != null) {
            return ResponseEntity.ok(ruolo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ruolo> createRuolo(@RequestBody Ruolo ruolo) {
        Ruolo nuovoRuolo = ruoloService.salvaRuolo(ruolo);
        return ResponseEntity.ok(nuovoRuolo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ruolo> updateRuolo(@PathVariable Long id, @RequestBody Ruolo ruolo) {
        Ruolo ruoloEsistente = ruoloService.trovaRuoloPerId(id);
        if (ruoloEsistente != null) {
            ruolo.setId(id);
            Ruolo ruoloAggiornato = ruoloService.salvaRuolo(ruolo);
            return ResponseEntity.ok(ruoloAggiornato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRuolo(@PathVariable Long id) {
        Ruolo ruoloEsistente = ruoloService.trovaRuoloPerId(id);
        if (ruoloEsistente != null) {
            ruoloService.eliminaRuolo(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
}
