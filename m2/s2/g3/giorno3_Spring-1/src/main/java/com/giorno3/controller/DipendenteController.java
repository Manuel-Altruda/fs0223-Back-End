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

import com.giorno3.classes.Dipendente;
import com.giorno3.services.DipendenteService;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {
	
	public DipendenteService dipendenteService;
	
	@GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable Long id) {
        Dipendente dipendente = dipendenteService.trovaDipendentePerId(id);
        if (dipendente != null) {
            return ResponseEntity.ok(dipendente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Dipendente> createDipendente(@RequestBody Dipendente dipendente) {
        Dipendente nuovoDipendente = dipendenteService.salvaDipendente(dipendente);
        return ResponseEntity.ok(nuovoDipendente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> updateDipendente(@PathVariable Long id, @RequestBody Dipendente dipendente) {
        Dipendente dipendenteEsistente = dipendenteService.trovaDipendentePerId(id);
        if (dipendenteEsistente != null) {
            dipendente.setId(id);
            Dipendente dipendenteAggiornato = dipendenteService.salvaDipendente(dipendente);
            return ResponseEntity.ok(dipendenteAggiornato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id) {
        Dipendente dipendenteEsistente = dipendenteService.trovaDipendentePerId(id);
        if (dipendenteEsistente != null) {
            dipendenteService.eliminaDipendente(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
}
