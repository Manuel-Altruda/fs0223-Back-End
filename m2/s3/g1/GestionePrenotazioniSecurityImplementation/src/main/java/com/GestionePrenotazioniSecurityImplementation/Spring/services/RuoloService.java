package com.GestionePrenotazioniSecurityImplementation.Spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioniSecurityImplementation.Spring.classes.Ruolo;
import com.GestionePrenotazioniSecurityImplementation.Spring.repository.RuoloRepository;

@Service
public class RuoloService {

    @Autowired
    private RuoloRepository ruoloRepository;

    public void salvaRuolo(Ruolo ruolo) {
        ruoloRepository.save(ruolo);
    }
}
