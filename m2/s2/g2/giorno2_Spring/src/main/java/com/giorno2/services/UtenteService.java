package com.giorno2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giorno2.classes.Utente;
import com.giorno2.repository.UtenteRepository;

@Service
public class UtenteService {
	
	private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public List<Utente> listaUtenti() {
        return utenteRepository.findAll();
    }
    
    public List<Utente> ricercaUtentiPerNomeCompleto(String nomeCompleto) {
        return utenteRepository.findByNomeCompletoContainingIgnoreCase(nomeCompleto);
    }
    
    public Utente salvaUtente(Utente utente) {
        return utenteRepository.save(utente);
    }
    
    public Utente trovaUtentePerUsername(String username) {
        return (Utente) utenteRepository.findByUsername(username);
    }

    public Utente creaUtente(String username, String nomeCompleto, String email) {
        Utente utente = new Utente();
        utente.setUsername(username);
        utente.setNomeCompleto(nomeCompleto);
        utente.setEmail(email);
        return utenteRepository.save(utente);
    }
	
}
