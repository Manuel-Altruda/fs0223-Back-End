package com.giorno2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giorno2.classes.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

	List<Utente> findByUsername(String username);
	
	List<Utente> findByNomeCompleto(String nomeCompleto);
	
	List<Utente> findByEmail(String email);

	List<Utente> findByNomeCompletoContainingIgnoreCase(String nomeCompleto);
}
