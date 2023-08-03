package com.giorno4.Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giorno4.Spring.classes.Postazione;
import com.giorno4.Spring.services.PostazioneService;

@RestController
@RequestMapping("/api/postazioni")
public class PostazioneController {
	
	@Autowired
    private PostazioneService postazioneService;
	
	@GetMapping("/{id}")
    public ResponseEntity<Postazione> getPostazioneById(@PathVariable Long id) {
        Postazione postazione = postazioneService.trovaPostazionePerId(id);
        if (postazione != null) {
            return ResponseEntity.ok(postazione);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
	
	@PostMapping
    public ResponseEntity<Postazione> createPostazione(@RequestBody Postazione postazione) {
        Postazione nuovaPostazione = postazioneService.salvaPostazione(postazione);
        return ResponseEntity.ok(nuovaPostazione);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postazione> updatePostazione(@PathVariable Long id, @RequestBody Postazione postazione) {
        Postazione postazioneEsistente = postazioneService.trovaPostazionePerId(id);
        if (postazioneEsistente != null) {
            postazione.setId(id);
            Postazione postazioneAggiornata = postazioneService.salvaPostazione(postazione);
            return ResponseEntity.ok(postazioneAggiornata);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePostazione(@PathVariable Long id) {
        Postazione postazioneEsistente = postazioneService.trovaPostazionePerId(id);
        if (postazioneEsistente != null) {
            postazioneService.eliminaPostazione(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
}
