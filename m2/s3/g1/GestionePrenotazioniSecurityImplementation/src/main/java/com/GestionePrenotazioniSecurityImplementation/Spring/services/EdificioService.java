package com.GestionePrenotazioniSecurityImplementation.Spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioniSecurityImplementation.Spring.classes.Edificio;
import com.GestionePrenotazioniSecurityImplementation.Spring.repository.EdificioRepository;

@Service
public class EdificioService {
	
	private final EdificioRepository edificioRepository;

    @Autowired
    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public List<Edificio> listaEdifici() {
        return edificioRepository.findAll();
    }
    
    public List<Edificio> ricercaEdificiPerCitta(String citta) {
        return edificioRepository.findByCitta(citta);
    }

    public Edificio salvaEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }
    
    public Edificio trovaEdificioPerId(Long id) {
        return edificioRepository.findById(id).orElse(null);
    }
	
}
