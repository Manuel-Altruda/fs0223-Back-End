package com.SistemaAntiIncendio.Spring.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaAntiIncendio.Spring.security.entity.Sonda;
import com.SistemaAntiIncendio.Spring.security.service.SondaService;

@RestController
@RequestMapping("/api/auth")
public class SondaController {
	
	@Autowired
    private SondaService sondaService;

    @GetMapping("/sonde")
    public ResponseEntity<List<Sonda>> getSonde() {
        List<Sonda> sonde = sondaService.getAllSonde(); // Esempio: metodo per ottenere i dati delle sonde
        return ResponseEntity.ok(sonde);
    }
	
}
