package com.giorno4.Spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giorno4.Spring.classes.Ruolo;

public interface RuoloRepository extends JpaRepository<Ruolo, Long> {
	
//	Ruolo findByNome(String nome);
//
//    // Trova tutti i ruoli con stipendio minore o uguale a quello specificato
//    List<Ruolo> findByStipendioBaseLessThanOrEqual(double stipendioMassimo);
//
//    // Trova tutti i ruoli con stipendio maggiore o uguale a quello specificato
//    List<Ruolo> findByStipendioBaseGreaterThanOrEqual(double stipendioMinimo);
//    
//    List<Ruolo> findByStipendioBaseGreaterThanEqual(double stipendioBase);
//    
//    // Trova tutti i ruoli con stipendio compreso tra quello minimo e massimo specificato
//    List<Ruolo> findByStipendioBaseBetween(double stipendioMinimo, double stipendioMassimo);
//	
}
