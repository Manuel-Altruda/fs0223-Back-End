package com.GestionePrenotazioni;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.GestionePrenotazioni.classes.Dipendente;
import com.GestionePrenotazioni.classes.Edificio;
import com.GestionePrenotazioni.classes.Postazione;
import com.GestionePrenotazioni.classes.Prenotazione;
import com.GestionePrenotazioni.classes.Ruolo;
import com.GestionePrenotazioni.classes.TipoPostazione;
import com.GestionePrenotazioni.classes.Utente;
import com.GestionePrenotazioni.services.DipendenteService;
import com.GestionePrenotazioni.services.EdificioService;
import com.GestionePrenotazioni.services.PostazioneService;
import com.GestionePrenotazioni.services.PrenotazioneService;
import com.GestionePrenotazioni.services.UtenteService;

/* HO IMPLEMENTATO I COLORI IN CONSOLE MA NON FUNZIONANO PER COLPA DELLA VERSIONE DI ECLIPSE */

@SpringBootApplication
public class GestionePrenotazioniApplication implements CommandLineRunner {
	
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
	
	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
	}
	
	public void run(String... args) {
		AnsiConsole.systemInstall();
		
		System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).a("Ciao Capo Umberto, questa è la tua nuova azienda con i tuoi dipendenti").reset());		
        
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

        Dipendente dipendente1 = new Dipendente();
        dipendente1.setNome("Manuel");
        dipendente1.setCognome("Altruda");
        dipendente1.setRuolo(ruolo);
        dipendente1.setStipendioBase(2500.0);
        dipendenteService.aggiungiDipendente(dipendente1);
        
        
        Date dataPrenotazione = new Date(); // Data di oggi
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
            System.out.println(Ansi.ansi().fg(Ansi.Color.CYAN).a("Dipendenti con il ruolo '" + ruoloDaCercare + "':").reset());
            
            for (Dipendente dipendente : dipendentiPerRuolo) {
                System.out.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a("ID: " + dipendente.getId() + ", Nome: " + dipendente.getNome() + ", Ruolo: " + dipendente.getRuolo() + ", Stipendio: " + dipendente.getStipendioBase()).reset());
            }
        
        } else {
            System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("Nessun dipendente trovato con il ruolo '" + ruoloDaCercare + "'.").reset());
        }
        
        // Eliminazione di un dipendente
//        Long idDipendenteDaEliminare = 2L;
//        dipendenteService.eliminaDipendente(idDipendenteDaEliminare);
//        System.out.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a("Dipendente con ID " + idDipendenteDaEliminare + " eliminato.").reset());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -7); // Data inizio intervallo (7 giorni fa)
        Date startDate = calendar.getTime();

        calendar.add(Calendar.DAY_OF_MONTH, 14); // Data fine intervallo (7 giorni dopo la data inizio)
        Date endDate = calendar.getTime();

        List<Prenotazione> prenotazioniInIntervallo = prenotazioneService.ricercaPrenotazioniPerIntervalloDate(startDate, endDate);
        if (!prenotazioniInIntervallo.isEmpty()) {
            System.out.println(Ansi.ansi().fg(Ansi.Color.CYAN).a("Prenotazioni nell'intervallo di date:").reset());
            
            for (Prenotazione prenotazioneIntervallo : prenotazioniInIntervallo) {
                System.out.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a("Data prenotazione: " + prenotazioneIntervallo.getDataPrenotazione()).reset());
            }
        
        } else {
            System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("Nessuna prenotazione trovata nell'intervallo di date specificato.").reset());
        }
        
        // Ricerca delle postazioni in base a criteri specifici
        List<Postazione> postazioniTrovate = postazioneService.ricercaPostazioniAvanzata(TipoPostazione.PRIVATO, "Galiforgnia", 1, dataPrenotazione);
        if (!postazioniTrovate.isEmpty()) {
            System.out.println(Ansi.ansi().fg(Ansi.Color.CYAN).a("Postazioni trovate:").reset());
            
            for (Postazione postazione : postazioniTrovate) {
                System.out.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a("Postazione: " + postazione.getDescrizione()).reset());
            }
       
        } else {
            System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("Nessuna postazione trovata con i criteri specificati.").reset());
        }
        
        //  ricerca utenti in base a criteri specifici
        List<Utente> utentiTrovati = utenteService.ricercaUtentiPerNomeCompleto("Umberto");
        if (!utentiTrovati.isEmpty()) {
            System.out.println(Ansi.ansi().fg(Ansi.Color.CYAN).a("Utenti trovati:").reset());
           
            for (Utente utente : utentiTrovati) {
                System.out.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a("Utente: " + utente.getNomeCompleto()).reset());
            }
        
        } else {
            System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("Nessun utente trovato con i criteri specificati.").reset());
        }
        
        //  ricerca degli edifici in base a criteri specifici
        List<Edificio> edificiTrovati = edificioService.ricercaEdificiPerCitta("Galiforgnia");
        if (!edificiTrovati.isEmpty()) {
            System.out.println(Ansi.ansi().fg(Ansi.Color.CYAN).a("Edifici trovati:").reset());
            
            for (Edificio edificio : edificiTrovati) {
                System.out.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a("Edificio: " + edificio.getNome()).reset());
            }
        
        } else {
            System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("Nessun edificio trovato con i criteri specificati.").reset());
        }
	
        AnsiConsole.systemUninstall();
	}
}
