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

import com.giorno4.Spring.classes.Edificio;
import com.giorno4.Spring.services.EdificioService;

@RestController
@RequestMapping("/api/edifici")
public class EdificioController {

	@Autowired
    private EdificioService edificioService;

    @GetMapping
    public Page<Edificio> getEdifici(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(defaultValue = "citta") String sortBy,
                                     @RequestParam(defaultValue = "asc") String sortOrder) {
        // Imposta i parametri di paginazione e ordinamento
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortOrder), sortBy));
        // Esegue la ricerca paginata degli edifici
        return edificioService.trovaEdificiPerCitta("", pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Edificio> getEdificioById(@PathVariable Long id) {
        Edificio edificio = edificioService.trovaEdificioPerId(id);
        if (edificio != null) {
            return ResponseEntity.ok(edificio);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Edificio> createEdificio(@RequestBody Edificio edificio) {
        Edificio nuovoEdificio = edificioService.salvaEdificio(edificio);
        return ResponseEntity.ok(nuovoEdificio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Edificio> updateEdificio(@PathVariable Long id, @RequestBody Edificio edificio) {
        Edificio edificioEsistente = edificioService.trovaEdificioPerId(id);
        if (edificioEsistente != null) {
            edificio.setId(id);
            Edificio edificioAggiornato = edificioService.salvaEdificio(edificio);
            return ResponseEntity.ok(edificioAggiornato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEdificio(@PathVariable Long id) {
        Edificio edificioEsistente = edificioService.trovaEdificioPerId(id);
        if (edificioEsistente != null) {
            edificioService.eliminaEdificio(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
