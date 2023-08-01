package com.giorno2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giorno2.classes.Ruolo;
import com.giorno2.repository.RuoloRepository;

@Service
public class RuoloService {

    @Autowired
    private RuoloRepository ruoloRepository;

    public void salvaRuolo(Ruolo ruolo) {
        ruoloRepository.save(ruolo);
    }
}
