package com.giorno4.Spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.giorno4.Spring.classes.Edificio;
import com.giorno4.Spring.repository.EdificioRepository;

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
	
    public void eliminaEdificio(Long id) {
        edificioRepository.deleteById(id);
    }
    
    public Page<Edificio> trovaEdificiPerCitta(String citta, Pageable pageable) {
        return edificioRepository.findByCittaContainingIgnoreCase(citta, pageable);
    }
    
}
