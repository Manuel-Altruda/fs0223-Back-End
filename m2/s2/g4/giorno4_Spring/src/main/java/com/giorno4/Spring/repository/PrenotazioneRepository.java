package com.giorno4.Spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giorno4.Spring.classes.Postazione;
import com.giorno4.Spring.classes.Prenotazione;
import com.giorno4.Spring.classes.Utente;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
	
	List<Prenotazione> findByUtenteAndDataPrenotazione(Utente utente, Date dataPrenotazione);
	
	List<Prenotazione> findByUtente(Utente utente);
	
    List<Prenotazione> findByPostazione(Postazione postazione);
	
    List<Prenotazione> findByPostazioneAndDataPrenotazione(Postazione postazione, Date dataPrenotazione);

    List<Prenotazione> findByDataPrenotazioneBefore(Date data);
    
    List<Prenotazione> findByDataPrenotazioneBetween(Date startDate, Date endDate);

	List<Prenotazione> findByDataPrenotazione(Date dataPrenotazione);
}
	

