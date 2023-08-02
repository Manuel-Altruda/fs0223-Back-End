package com.giorno3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.giorno3.classes.Utente;
import com.giorno3.repository.UtenteRepository;

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
    
//    public List<Utente> ricercaUtentiPerNomeCompleto(String nomeCompleto) {
//        return utenteRepository.findByNomeCompletoContainingIgnoreCase(nomeCompleto);
//    }
    
    public Page<Utente> trovaUtentiPerNomeCompleto(String nomeCompleto, Pageable pageable) {
        return utenteRepository.findByNomeCompletoContainingIgnoreCase(nomeCompleto, pageable);
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

    public Utente trovaUtentePerId(Long id) {
        return utenteRepository.findById(id).orElse(null);
    }
	
	public void eliminaUtente(Long id) {
        utenteRepository.deleteById(id);
    }
}
