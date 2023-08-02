package com.giorno3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giorno3.classes.Ruolo;
import com.giorno3.repository.RuoloRepository;

@Service
public class RuoloService {

    @Autowired
    private RuoloRepository ruoloRepository;

    public Ruolo trovaRuoloPerId(Long id) {
        return ruoloRepository.findById(id).orElse(null);
    }
    
    public Ruolo salvaRuolo(Ruolo ruolo) {
        return ruoloRepository.save(ruolo);
    }
    
    public void eliminaRuolo(Long id) {
        ruoloRepository.deleteById(id);
    }
    
}
