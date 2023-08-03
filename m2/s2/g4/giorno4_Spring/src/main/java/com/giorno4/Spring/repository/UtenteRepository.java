package com.giorno4.Spring.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giorno4.Spring.classes.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

	List<Utente> findByUsername(String username);
	
	//List<Utente> findByNomeCompleto(String nomeCompleto);
	
	// Metodo per cercare utenti per nome completo
    Page<Utente> findByNomeCompletoContainingIgnoreCase(String nome, Pageable pageable);
	
	List<Utente> findByEmail(String email);

	List<Utente> findByNomeCompletoContainingIgnoreCase(String nome);
}
