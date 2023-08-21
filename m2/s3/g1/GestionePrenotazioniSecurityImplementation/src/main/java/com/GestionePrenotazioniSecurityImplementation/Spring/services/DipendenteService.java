package com.GestionePrenotazioniSecurityImplementation.Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioniSecurityImplementation.Spring.classes.Dipendente;
import com.GestionePrenotazioniSecurityImplementation.Spring.classes.Ruolo;
import com.GestionePrenotazioniSecurityImplementation.Spring.repository.DipendenteRepository;
import com.GestionePrenotazioniSecurityImplementation.Spring.repository.RuoloRepository;

@Service
public class DipendenteService {
    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private RuoloRepository ruoloRepository;
    
    public void calcolaStipendio(Dipendente dipendente) {
        
        double stipendioBase = dipendente.getStipendioBase();
        double stipendioCalcolato = stipendioBase;

 
        double incrementoStipendio;
        if (dipendente.getRuolo().equals("Manager")) {
        	
            incrementoStipendio = 0.1; // 10% di incremento 
        
        } else if (dipendente.getRuolo().equals("Sviluppatore")) {
         
        	incrementoStipendio = 0.05; // 5% di incremento 
        
        } else if (dipendente.getRuolo().equals("Amministratore")) {
        
        	incrementoStipendio = 0.08; // 8% di incremento 
       
        } else if (dipendente.getRuolo().equals("Contabile")) {
         
        	incrementoStipendio = 0.07; // 7% di incremento 
        
        } else if (dipendente.getRuolo().equals("Analyst")) {
         
        	incrementoStipendio = 0.09; // 9% di incremento 
        
        } else {

        	incrementoStipendio = 0.0; // Nessun incremento per ruoli non specificati
        
        }

        
        stipendioCalcolato += stipendioBase * incrementoStipendio;

        dipendente.setStipendio(stipendioCalcolato);
    }
    
    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }
    
    public Dipendente aggiungiDipendente(Dipendente dipendente) {
    	  
        if (dipendente.getId() != null) {
            throw new IllegalArgumentException("Il dipendente da aggiungere non deve avere un ID assegnato.");
        }
        
        calcolaStipendio(dipendente);
        return dipendenteRepository.save(dipendente);
    }

    public Dipendente modificaDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public void eliminaDipendente(Long idDipendente) {
        dipendenteRepository.deleteById(idDipendente);
    }

    public List<Dipendente> cercaPerNome(String nome) {
        return dipendenteRepository.findByNomeContaining(nome);
    }

    public List<Dipendente> cercaPerRuolo(Ruolo ruolo) {
        return dipendenteRepository.findByRuolo(ruolo);
    }

    public List<Dipendente> cercaPerStipendioMinimo(double stipendioMinimo) {
        return dipendenteRepository.findByStipendioBaseGreaterThan(stipendioMinimo);
    }

    public List<Dipendente> cercaPerStipendioMassimo(double stipendioMassimo) {
        return dipendenteRepository.findByStipendioBaseLessThan(stipendioMassimo);
    }

    public List<Dipendente> cercaPerStipendioTra(double stipendioMinimo, double stipendioMassimo) {
        return dipendenteRepository.findByStipendioBaseBetween(stipendioMinimo, stipendioMassimo);
    }

    public List<Dipendente> cercaPerCognome(String cognome) {
        return dipendenteRepository.findByCognomeContaining(cognome);
    }

    public Dipendente getDipendenteById(Long id) {
        
    	Optional<Dipendente> dipendenteOptional = dipendenteRepository.findById(id);
        
    	if (dipendenteOptional.isPresent()) {
    		
            return dipendenteOptional.get();
            
        } else {
        	
            throw new IllegalArgumentException("Dipendente non trovato con ID: " + id);
        }
    }

    public Ruolo aggiungiRuolo(Ruolo ruolo) {
        // Controlla se il ruolo ha un ID già assegnato (non è nuovo)
        if (ruolo.getId() != null) {
            throw new IllegalArgumentException("Il ruolo da aggiungere non deve avere un ID assegnato.");
        }

        return ruoloRepository.save(ruolo);
    }
}
