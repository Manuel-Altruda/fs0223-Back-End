package com.GestionePrenotazioni.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.classes.Edificio;
import com.GestionePrenotazioni.classes.Postazione;
import com.GestionePrenotazioni.classes.TipoPostazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
	
	List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);
	
	List<Postazione> findByTipoAndEdificio(TipoPostazione tipo, Edificio edificio);
	
	@Query("SELECT p FROM Postazione p WHERE p.edificio.citta = :citta")
	List<Postazione> findByEdificio_Citta(@Param("citta") String citta);

	List<Postazione> findByEdificio_CittaAndEdificio_Nome(String citta, String nomeEdificio);

	// Trovo tutte le postazioni con una capacità massima maggiore o uguale a quella specificata
    List<Postazione> findByNumeroMassimoOccupantiGreaterThanEqual(int capacitaMinima);

    List<Postazione> findByDataDisponibile(Date data);
    // Trovo tutte le postazioni disponibili per una data specificata
    List<Postazione> findByDisponibileTrueAndDataDisponibile(Date data);
	
	List<Postazione> findByTipo(TipoPostazione tipo);

	List<Postazione> findByTipoAndEdificio_CittaAndNumeroMassimoOccupantiGreaterThanEqualAndIdNotIn(TipoPostazione tipo,
			String citta, int capacitaMinima, List<Long> prenotazioniPostazioniOccupate);
}

