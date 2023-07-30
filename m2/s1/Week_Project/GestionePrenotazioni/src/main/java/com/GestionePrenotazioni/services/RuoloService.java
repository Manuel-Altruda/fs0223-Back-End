package com.GestionePrenotazioni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.classes.Ruolo;
import com.GestionePrenotazioni.repository.RuoloRepository;

@Service
public class RuoloService {

    @Autowired
    private RuoloRepository ruoloRepository;

    public void salvaRuolo(Ruolo ruolo) {
        ruoloRepository.save(ruolo);
    }
}
