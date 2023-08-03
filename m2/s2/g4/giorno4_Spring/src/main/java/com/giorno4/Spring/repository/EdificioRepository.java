package com.giorno4.Spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giorno4.Spring.classes.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, Long> {
	
    List<Edificio> findByCitta(String citta);

    List<Edificio> findByNome(String nome);

    List<Edificio> findByIndirizzo(String indirizzo);

    Page<Edificio> findByCittaContainingIgnoreCase(String citta, Pageable pageable);
    
}
