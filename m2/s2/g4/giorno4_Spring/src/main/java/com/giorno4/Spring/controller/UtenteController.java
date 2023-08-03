package com.giorno4.Spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giorno4.Spring.classes.Utente;
import com.giorno4.Spring.services.UtenteService;

@RestController
@RequestMapping("/api/utenti")
public class UtenteController {

	@Autowired
    private UtenteService utenteService;

    @GetMapping
    public Page<Utente> getUtenti(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size,
                                  @RequestParam(defaultValue = "nomeCompleto") String sortBy,
                                  @RequestParam(defaultValue = "asc") String sortOrder) {
        // Imposta i parametri di paginazione e ordinamento
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));
        // Esegue la ricerca paginata degli utenti
        return utenteService.trovaUtentiPerNomeCompleto("", pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utente> getUtenteById(@PathVariable Long id) {
        Utente utente = utenteService.trovaUtentePerId(id);
        if (utente != null) {
            return ResponseEntity.ok(utente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Utente> createUtente(@RequestBody Utente utente) {
        Utente nuovoUtente = utenteService.salvaUtente(utente);
        return ResponseEntity.ok(nuovoUtente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utente> updateUtente(@PathVariable Long id, @RequestBody Utente utente) {
        Utente utenteEsistente = utenteService.trovaUtentePerId(id);
        if (utenteEsistente != null) {
            utente.setId(id);
            Utente utenteAggiornato = utenteService.salvaUtente(utente);
            return ResponseEntity.ok(utenteAggiornato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtente(@PathVariable Long id) {
        Utente utenteEsistente = utenteService.trovaUtentePerId(id);
        if (utenteEsistente != null) {
            utenteService.eliminaUtente(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
