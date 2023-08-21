package com.GestionePrenotazioniSecurityImplementation.Spring;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.GestionePrenotazioniSecurityImplementation.Spring.classes.Colors;
import com.GestionePrenotazioniSecurityImplementation.Spring.classes.Dipendente;
import com.GestionePrenotazioniSecurityImplementation.Spring.classes.Edificio;
import com.GestionePrenotazioniSecurityImplementation.Spring.classes.Postazione;
import com.GestionePrenotazioniSecurityImplementation.Spring.classes.Prenotazione;
import com.GestionePrenotazioniSecurityImplementation.Spring.classes.Ruolo;
import com.GestionePrenotazioniSecurityImplementation.Spring.classes.TipoPostazione;
import com.GestionePrenotazioniSecurityImplementation.Spring.classes.Utente;
import com.GestionePrenotazioniSecurityImplementation.Spring.services.DipendenteService;
import com.GestionePrenotazioniSecurityImplementation.Spring.services.EdificioService;
import com.GestionePrenotazioniSecurityImplementation.Spring.services.PostazioneService;
import com.GestionePrenotazioniSecurityImplementation.Spring.services.PrenotazioneService;
import com.GestionePrenotazioniSecurityImplementation.Spring.services.RuoloService;
import com.GestionePrenotazioniSecurityImplementation.Spring.services.UtenteService;

@SpringBootApplication
public class GestionePrenotazioniSecurityImplementationApplication implements CommandLineRunner {
	
	@Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private PrenotazioneService prenotazioneService;
    
    @Autowired
    private static RuoloService ruoloService;
    
    
    
	
	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniSecurityImplementationApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	  System.out.println(Colors.ANSI_RED + "Ciao Capo Umberto, questa è la tua nuova azienda con i tuoi dipendenti");		
      
      Edificio edificio1 = new Edificio("Amarzion", "Via Rotta 104", "Galiforgnia");
      Edificio edificio2 = new Edificio("Testla", "Via Bucati 73", "Dallas");
      edificioService.salvaEdificio(edificio1);
      edificioService.salvaEdificio(edificio2);

      
      Postazione postazione1 = new Postazione("POST-7701", "Postazione Privata", TipoPostazione.PRIVATO, 1, edificio1);
      Postazione postazione2 = new Postazione("POST-99902", "Postazione OpenSpace", TipoPostazione.OPENSPACE, 1, edificio1);
      Postazione postazione3 = new Postazione("POST-7903", "Sala Riunioni A", TipoPostazione.SALA, 10, edificio2);
      postazioneService.salvaPostazione(postazione1);
      postazioneService.salvaPostazione(postazione2);
      postazioneService.salvaPostazione(postazione3);
      
      String ruoloDaCercare = "Manager";
      Ruolo ruolo = new Ruolo();
      ruolo.setNome(ruoloDaCercare);
      ruolo.setDescrizione("Responsabile del reparto");
      dipendenteService.aggiungiRuolo(ruolo);
     
      Utente utente1 = new Utente("Capo", "Giggione", "giggione@example.com");
      Utente utente2 = new Utente("Dipendente", "Ugo", "Ugo@example.com");
      utenteService.salvaUtente(utente1);
      utenteService.salvaUtente(utente2);

      Dipendente dipendente1 = new Dipendente(ruoloDaCercare, ruoloDaCercare, ruolo, 1, 2);
      dipendente1.setNome("Manuel");
      dipendente1.setCognome("Altruda");
      dipendente1.setRuolo(ruolo);
      dipendente1.setStipendioBase(2500.0);
      dipendenteService.aggiungiDipendente(dipendente1);
      
      
      Date dataPrenotazione = new Date(0); // Data di oggi
      Prenotazione prenotazione = new Prenotazione(dipendente1, postazione1, dataPrenotazione);
      prenotazioneService.salvaPrenotazione(prenotazione);
	
      // Cancellazione di una prenotazione
      //prenotazioneService.cancellaPrenotazione(prenotazione.getId());      
      

      // Modifica dello stipendio di un dipendente esistente
      Long idDipendenteDaModificare = 1L; 
      Dipendente dipendenteDaModificare = dipendenteService.getDipendenteById(idDipendenteDaModificare);
      dipendenteService.calcolaStipendio(dipendenteDaModificare);
      dipendenteService.modificaDipendente(dipendenteDaModificare); // Salva le modifiche nel repository

      // Ricerca dei dipendenti in base al ruolo

      List<Dipendente> dipendentiPerRuolo = dipendenteService.cercaPerRuolo(ruolo);
      if (!dipendentiPerRuolo.isEmpty()) {
          System.out.println(Colors.ANSI_RED + "Dipendenti con il ruolo '" + ruoloDaCercare + "':");
          
          for (Dipendente dipendente : dipendentiPerRuolo) {
              System.out.println(Colors.ANSI_RED + "ID: " + dipendente.getId() + ", Nome: " + dipendente.getNome() + ", Ruolo: " + dipendente.getRuolo() + ", Stipendio: " + dipendente.getStipendioBase());
          }
      
      } else {
          System.out.println(Colors.ANSI_RED + "Nessun dipendente trovato con il ruolo '" + ruoloDaCercare + "'.");
      }
      
      // Eliminazione di un dipendente
      Long idDipendenteDaEliminare = 2L;
      dipendenteService.eliminaDipendente(idDipendenteDaEliminare);
      System.out.println(Colors.ANSI_RED + "Dipendente con ID " + idDipendenteDaEliminare + " eliminato.");

      Calendar calendar = Calendar.getInstance();
      calendar.add(Calendar.DAY_OF_MONTH, -7); // Data inizio intervallo (7 giorni fa)
      Date startDate = (Date) calendar.getTime();

      calendar.add(Calendar.DAY_OF_MONTH, 14); // Data fine intervallo (7 giorni dopo la data inizio)
      Date endDate = (Date) calendar.getTime();

      List<Prenotazione> prenotazioniInIntervallo = prenotazioneService.ricercaPrenotazioniPerIntervalloDate(startDate, endDate);
      if (!prenotazioniInIntervallo.isEmpty()) {
          System.out.println(Colors.ANSI_RED + "Prenotazioni nell'intervallo di date:");
          
          for (Prenotazione prenotazioneIntervallo : prenotazioniInIntervallo) {
              System.out.println(Colors.ANSI_RED + "Data prenotazione: " + prenotazioneIntervallo.getDataPrenotazione());
          }
      
      } else {
          System.out.println(Colors.ANSI_RED + "Nessuna prenotazione trovata nell'intervallo di date specificato.");
      }
      
      // Ricerca delle postazioni in base a criteri specifici
      List<Postazione> postazioniTrovate = postazioneService.ricercaPostazioniAvanzata(TipoPostazione.PRIVATO, "Galiforgnia", 1, dataPrenotazione);
      if (!postazioniTrovate.isEmpty()) {
          System.out.println(Colors.ANSI_RED + "Postazioni trovate:");
          
          for (Postazione postazione : postazioniTrovate) {
              System.out.println(Colors.ANSI_RED + "Postazione: " + postazione.getDescrizione());
          }
     
      } else {
          System.out.println(Colors.ANSI_RED + "Nessuna postazione trovata con i criteri specificati.");
      }
      
      //  ricerca utenti in base a criteri specifici
      List<Utente> utentiTrovati = utenteService.ricercaUtentiPerNomeCompleto("Umberto");
      if (!utentiTrovati.isEmpty()) {
          System.out.println(Colors.ANSI_RED + "Utenti trovati:");
         
          for (Utente utente : utentiTrovati) {
              System.out.println(Colors.ANSI_RED + "Utente: " + utente.getNomeCompleto());
          }
      
      } else {
          System.out.println(Colors.ANSI_RED + "Nessun utente trovato con i criteri specificati.");
      }
      
      //  ricerca degli edifici in base a criteri specifici
      List<Edificio> edificiTrovati = edificioService.ricercaEdificiPerCitta("Galiforgnia");
      if (!edificiTrovati.isEmpty()) {
          System.out.println(Colors.ANSI_RED +"Edifici trovati:");
          
          for (Edificio edificio : edificiTrovati) {
              System.out.println(Colors.ANSI_RED + "Edificio: " + edificio.getNome());
          }
      
      } else {
          System.out.println(Colors.ANSI_RED + "Nessun edificio trovato con i criteri specificati.");
      }
	
      
	}



	}
	

