package com.giorno2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giorno2.classes.Dipendente;
import com.giorno2.classes.Ruolo;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Long> {
	
	 List<Dipendente> findByRuolo(Ruolo ruolo);
	 
	 List<Dipendente> findByNomeContaining(String nome);
	 
	 List<Dipendente> findByStipendioBaseGreaterThan(double stipendioMinimo);
	 
	 List<Dipendente> findByStipendioBaseLessThan(double stipendioMassimo);
	 
	 List<Dipendente> findByStipendioBaseBetween(double stipendioMinimo, double stipendioMassimo);

	 List<Dipendente> findByCognomeContaining(String cognome);
	
}
