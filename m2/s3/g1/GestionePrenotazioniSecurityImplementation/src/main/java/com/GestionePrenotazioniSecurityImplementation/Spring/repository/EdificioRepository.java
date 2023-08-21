package com.GestionePrenotazioniSecurityImplementation.Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioniSecurityImplementation.Spring.classes.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
	
    List<Edificio> findByCitta(String citta);

    List<Edificio> findByNome(String nome);

    List<Edificio> findByIndirizzo(String indirizzo);
	
}
