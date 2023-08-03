package com.giorno4.Spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giorno4.Spring.classes.Ruolo;
import com.giorno4.Spring.repository.RuoloRepository;

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
