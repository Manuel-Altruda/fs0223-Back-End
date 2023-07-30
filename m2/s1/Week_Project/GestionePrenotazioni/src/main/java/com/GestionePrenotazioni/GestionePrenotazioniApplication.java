package com.GestionePrenotazioni;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.GestionePrenotazioni.classes.Colors;
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
import com.GestionePrenotazioni.services.RuoloService;
import com.GestionePrenotazioni.services.UtenteService;
/*CI SONO DUE VERSIONI DEL CODICE UNA STATICA E UNA DINAMICA CHE CREA L'UTENTE DALLA CLI
 * [CON QUEST'ULTIMA VERSIONE CI POTREBBERO ESSERE DEI PROBLEMI NON RISOLTI PER MANCANCANZA DI TEMPO PERSONALE, SONO SALTATI FUORI DEGLI IMPREVISTI CHE MI HANNO BLOCCATO LA CONTINUAZIONE DEL PROGETTO]*/
/* HO IMPLEMENTATO I COLORI IN CONSOLE MA NON FUNZIONANO PER COLPA DELLA MIA VERSIONE DI ECLIPSE */

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
    
    @Autowired
    private RuoloService ruoloService;
    
    private Scanner scanner;
    
    public static void main(String[] args) {
        SpringApplication.run(GestionePrenotazioniApplication.class, args);
    }

    @Override
    public void run(String... args) {
        AnsiConsole.systemInstall();
        scanner = new Scanner(System.in);

        System.out.println(Colors.ANSI_RED + "Ciao Capo Umberto, questa è la tua nuova azienda con i tuoi dipendenti");

        boolean exit = false;
        while (!exit) {
            System.out.println("Seleziona un'opzione:");
            System.out.println("1. Crea un nuovo utente ");
            System.out.println("2. Crea un nuovo dipendente");
            System.out.println("3. creaNuovoEdificio");
            System.out.println("4. Cancella una prenotazione");
            System.out.println("5. Modifica lo stipendio di un dipendente");
            System.out.println("6. Visualizza le prenotazioni nell'intervallo di date");
            System.out.println("7. Ricerca delle postazioni");
            System.out.println("8. Ricerca degli utenti");
            System.out.println("9. Ricerca degli edifici");
            System.out.println("10. Visualizza tutti i dipendenti");
            System.out.println("11. Cerca dipendenti per ruolo");
            System.out.println("12. Prenota una postazione");
            System.out.println("13. Crea nuovo Ruolo");
            System.out.println("0. Esci");
     

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                	creaNuovoUtente();
                    break;
                case 2:
                	creaNuovoDipendente();
                    break;
                case 3:
                	creaNuovoEdificio();
                    break;
                case 4:
                    cancellaPrenotazione();
                    break;
                case 5:
                    modificaStipendioDipendente();
                    break;
                case 6:
                    prenotazioniInIntervalloDate();
                    break;
                case 7:
                    ricercaPostazioni();
                    break;
                case 8:
                    ricercaUtenti();
                    break;
                case 9:
                    ricercaEdifici();
                    break;
                case 10:
                	visualizzaTuttiIDipendenti();
                    break;
                case 11:
                	cercaDipendentiPerRuolo();
                    break;
                case 12:
                	prenotaPostazione();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        AnsiConsole.systemUninstall();
        scanner.close();
    }
    

    private void getAllDipendenti() {
        List<Dipendente> dipendenti = dipendenteService.getAllDipendenti();
        if (!dipendenti.isEmpty()) {
            System.out.println("Dipendenti presenti nel sistema:");
            for (Dipendente dipendente : dipendenti) {
                System.out.println("ID: " + dipendente.getId() +
                                   ", Nome: " + dipendente.getNome() +
                                   ", Cognome: " + dipendente.getCognome() +
                                   ", Ruolo: " + dipendente.getRuolo() +
                                   ", Stipendio: " + dipendente.getStipendioBase());
            }
        } else {
            System.out.println("Nessun dipendente presente nel sistema.");
        }
    }

    private void getPrenotazioneById(Long idPrenotazione) {
        Prenotazione prenotazione = prenotazioneService.getPrenotazioneById(idPrenotazione);
        if (prenotazione != null) {
            System.out.println("Prenotazione trovata:");
            System.out.println("ID: " + prenotazione.getId() +
                               ", Data Prenotazione: " + prenotazione.getDataPrenotazione() +
                               ", Dipendente: " + prenotazione.getDipendente().getNome() +
                               ", Postazione: " + prenotazione.getPostazione().getDescrizione());
        } else {
            System.out.println("Prenotazione non trovata con l'ID specificato.");
        }
    }
    
    private void visualizzaTuttiIDipendenti() {
        List<Dipendente> dipendenti = dipendenteService.getAllDipendenti();
        if (!dipendenti.isEmpty()) {
            System.out.println("Dipendenti presenti nel sistema:");
            for (Dipendente dipendente : dipendenti) {
                System.out.println("ID: " + dipendente.getId() + ", Nome: " + dipendente.getNome() + ", Cognome: "
                        + dipendente.getCognome() + ", Ruolo: " + dipendente.getRuolo() + ", Stipendio: "
                        + dipendente.getStipendioBase());
            }
        } else {
            System.out.println("Nessun dipendente presente nel sistema.");
        }
    }

    private void creaNuovoRuolo() {
        scanner.nextLine();

        System.out.println("Inserisci il nome del ruolo:");
        String nomeRuolo = scanner.nextLine();

        Ruolo nuovoRuolo = new Ruolo();
        nuovoRuolo.setNome(nomeRuolo);

        ruoloService.salvaRuolo(nuovoRuolo);
        System.out.println("Nuovo ruolo creato con successo.");
    }
    
    private void cercaDipendentiPerRuolo() {
        System.out.println("Inserisci il ruolo da cercare:");
        String ruoloDaCercare = scanner.next();
        Ruolo ruolo = new Ruolo();
        ruolo.setNome(ruoloDaCercare);
        List<Dipendente> dipendentiPerRuolo = dipendenteService.cercaPerRuolo(ruolo);
        if (!dipendentiPerRuolo.isEmpty()) {
            System.out.println("Dipendenti con il ruolo '" + ruoloDaCercare + "':");
            for (Dipendente dipendente : dipendentiPerRuolo) {
                System.out.println("ID: " + dipendente.getId() + ", Nome: " + dipendente.getNome() + ", Cognome: "
                        + dipendente.getCognome() + ", Ruolo: " + dipendente.getRuolo() + ", Stipendio: "
                        + dipendente.getStipendioBase());
            }
        } else {
            System.out.println("Nessun dipendente trovato con il ruolo '" + ruoloDaCercare + "'.");
        }
    }

    private void prenotaPostazione() {
        System.out.println("Inserisci l'ID del dipendente:");
        Long idDipendente = scanner.nextLong();
        Dipendente dipendente = dipendenteService.getDipendenteById(idDipendente);
        if (dipendente == null) {
            System.out.println("Dipendente non trovato con l'ID specificato.");
            return;
        }

        System.out.println("Inserisci l'ID della postazione:");
        Long idPostazione = scanner.nextLong();
        Postazione postazione = postazioneService.getPostazioneById(idPostazione);
        if (postazione == null) {
            System.out.println("Postazione non trovata con l'ID specificato.");
            return;
        }

        System.out.println("Inserisci la data della prenotazione (dd/MM/yyyy):");
        scanner.nextLine(); // Consuma il carattere di newline residuo
        String dataString = scanner.nextLine();
        Date dataPrenotazione = null;
        try {
            dataPrenotazione = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);
        } catch (ParseException e) {
            System.out.println("Formato data non valido. Assicurati di inserire la data nel formato corretto (dd/MM/yyyy).");
            return;
        }

        // Verifica delle prenotazioni sovrapposte
        List<Prenotazione> prenotazioniSovrapposte = prenotazioneService.getPrenotazioniSovrapposte(postazione,
                dataPrenotazione);
        if (!prenotazioniSovrapposte.isEmpty()) {
            System.out.println("La postazione è già prenotata per l'orario specificato.");
            return;
        }

        // Crea una nuova prenotazione
        Prenotazione prenotazione = new Prenotazione(dipendente, postazione, dataPrenotazione);
        prenotazioneService.salvaPrenotazione(prenotazione);
        System.out.println("Nuova prenotazione creata con successo.");
    }

    private void cancellaPrenotazione() {
        System.out.println("Inserisci l'ID della prenotazione da cancellare:");
        Long idPrenotazioneDaCancellare = scanner.nextLong();
        Prenotazione prenotazioneDaCancellare = prenotazioneService.getPrenotazioneById(idPrenotazioneDaCancellare);
        if (prenotazioneDaCancellare == null) {
            System.out.println("Prenotazione non trovata con l'ID specificato.");
            return;
        }

        // Effettua la cancellazione
        prenotazioneService.cancellaPrenotazione(idPrenotazioneDaCancellare);
        System.out.println("Prenotazione con ID " + idPrenotazioneDaCancellare + " eliminata con successo.");
    }

    private void modificaStipendioDipendente() {
        System.out.println("Inserisci l'ID del dipendente da modificare:");
        Long idDipendenteDaModificare = scanner.nextLong();
        Dipendente dipendenteDaModificare = dipendenteService.getDipendenteById(idDipendenteDaModificare);
        if (dipendenteDaModificare == null) {
            System.out.println("Dipendente non trovato con l'ID specificato.");
            return;
        }

        dipendenteService.calcolaStipendio(dipendenteDaModificare);
        dipendenteService.modificaDipendente(dipendenteDaModificare);
        System.out.println("Stipendio del dipendente con ID " + idDipendenteDaModificare + " modificato con successo.");
    }

    private void prenotazioniInIntervalloDate() {
        System.out.println("Inserisci la data di inizio dell'intervallo (dd/MM/yyyy):");
        scanner.nextLine(); // Consuma il carattere di newline residuo
        String startDateString = scanner.nextLine();
        Date startDate = null;
        try {
            startDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDateString);
        } catch (ParseException e) {
            System.out.println("Formato data non valido. Assicurati di inserire la data nel formato corretto (dd/MM/yyyy).");
            return;
        }

        System.out.println("Inserisci la data di fine dell'intervallo (dd/MM/yyyy):");
        String endDateString = scanner.nextLine();
        Date endDate = null;
        try {
            endDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDateString);
        } catch (ParseException e) {
            System.out.println("Formato data non valido. Assicurati di inserire la data nel formato corretto (dd/MM/yyyy).");
            return;
        }

        List<Prenotazione> prenotazioniInIntervallo = prenotazioneService.ricercaPrenotazioniPerIntervalloDate(startDate,
                endDate);
        if (!prenotazioniInIntervallo.isEmpty()) {
            System.out.println("Prenotazioni nell'intervallo di date:");
            for (Prenotazione prenotazioneIntervallo : prenotazioniInIntervallo) {
                System.out.println("Data prenotazione: " + prenotazioneIntervallo.getDataPrenotazione());
            }
        } else {
            System.out.println("Nessuna prenotazione trovata nell'intervallo di date specificato.");
        }
    }

    private void ricercaPostazioni() {
        System.out.println("Inserisci il tipo di postazione (PRIVATO, OPENSPACE, SALA):");
        String tipoPostazioneString = scanner.next();
        TipoPostazione tipoPostazione;
        try {
            tipoPostazione = TipoPostazione.valueOf(tipoPostazioneString.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo postazione non valido.");
            return;
        }

        System.out.println("Inserisci la città dell'edificio:");
        String citta = scanner.next();

        System.out.println("Inserisci il numero dell'edificio:");
        int numeroEdificio = scanner.nextInt();

        Date dataPrenotazione = new Date(); // Data di oggi

        List<Postazione> postazioniTrovate = postazioneService.ricercaPostazioniAvanzata(tipoPostazione, citta,
                numeroEdificio, dataPrenotazione);
        if (!postazioniTrovate.isEmpty()) {
            System.out.println("Postazioni trovate:");
            for (Postazione postazione : postazioniTrovate) {
                System.out.println("Postazione: " + postazione.getDescrizione());
            }
        } else {
            System.out.println("Nessuna postazione trovata con i criteri specificati.");
        }
    }

    private void ricercaUtenti() {
        System.out.println("Inserisci il nome dell'utente:");
        String nomeUtente = scanner.next();

        List<Utente> utentiTrovati = utenteService.ricercaUtentiPerNomeCompleto(nomeUtente);
        if (!utentiTrovati.isEmpty()) {
            System.out.println("Utenti trovati:");
            for (Utente utente : utentiTrovati) {
                System.out.println("Utente: " + utente.getNomeCompleto());
            }
        } else {
            System.out.println("Nessun utente trovato con i criteri specificati.");
        }
    }

    private void ricercaEdifici() {
        System.out.println("Inserisci la città dell'edificio:");
        String cittaEdificio = scanner.next();

        List<Edificio> edificiTrovati = edificioService.ricercaEdificiPerCitta(cittaEdificio);
        if (!edificiTrovati.isEmpty()) {
            System.out.println("Edifici trovati:");
            for (Edificio edificio : edificiTrovati) {
                System.out.println("Edificio: " + edificio.getNome());
            }
        } else {
            System.out.println("Nessun edificio trovato con i criteri specificati.");
        }
    }
    
    private void creaNuovoUtente() {
        scanner.nextLine(); 

        System.out.println("Inserisci il nome dell'utente:");
        String nome = scanner.nextLine();

        System.out.println("Inserisci il cognome dell'utente:");
        String cognome = scanner.nextLine();

        System.out.println("Inserisci l'email dell'utente:");
        String email = scanner.nextLine();

        Utente nuovoUtente = new Utente(nome, cognome, email);
        utenteService.salvaUtente(nuovoUtente);
        System.out.println("Nuovo utente creato con successo.");
    }

    private void creaNuovoDipendente() {
        scanner.nextLine();

        System.out.println("Inserisci il nome del dipendente:");
        String nome = scanner.nextLine();

        System.out.println("Inserisci il cognome del dipendente:");
        String cognome = scanner.nextLine();

        System.out.println("Inserisci il ruolo del dipendente:");
        String ruoloNome = scanner.nextLine();
        Ruolo ruolo = new Ruolo();
        ruolo.setNome(ruoloNome);

        System.out.println("Inserisci lo stipendio base del dipendente:");
        double stipendioBase = scanner.nextDouble();

        Dipendente nuovoDipendente = new Dipendente(nome, cognome, ruolo, stipendioBase);
        dipendenteService.aggiungiDipendente(nuovoDipendente);
        System.out.println("Nuovo dipendente creato con successo.");
    }

    private void creaNuovoEdificio() {
        scanner.nextLine(); 

        System.out.println("Inserisci il nome dell'edificio:");
        String nomeEdificio = scanner.nextLine();

        System.out.println("Inserisci l'indirizzo dell'edificio:");
        String indirizzo = scanner.nextLine();

        System.out.println("Inserisci la città dell'edificio:");
        String citta = scanner.nextLine();

        Edificio nuovoEdificio = new Edificio(nomeEdificio, indirizzo, citta);
        edificioService.salvaEdificio(nuovoEdificio);
        System.out.println("Nuovo edificio creato con successo.");
    }
    
    
}
		
						/*IMPLEMENTAZIONE NEL DB STATICA*/	
		
//		System.out.println(Colors.ANSI_RED + "Ciao Capo Umberto, questa è la tua nuova azienda con i tuoi dipendenti");		
//        
//        Edificio edificio1 = new Edificio("Amarzion", "Via Rotta 104", "Galiforgnia");
//        Edificio edificio2 = new Edificio("Testla", "Via Bucati 73", "Dallas");
//        edificioService.salvaEdificio(edificio1);
//        edificioService.salvaEdificio(edificio2);
//
//        
//        Postazione postazione1 = new Postazione("POST-7701", "Postazione Privata", TipoPostazione.PRIVATO, 1, edificio1);
//        Postazione postazione2 = new Postazione("POST-99902", "Postazione OpenSpace", TipoPostazione.OPENSPACE, 1, edificio1);
//        Postazione postazione3 = new Postazione("POST-7903", "Sala Riunioni A", TipoPostazione.SALA, 10, edificio2);
//        postazioneService.salvaPostazione(postazione1);
//        postazioneService.salvaPostazione(postazione2);
//        postazioneService.salvaPostazione(postazione3);
//        
//        String ruoloDaCercare = "Manager";
//        Ruolo ruolo = new Ruolo();
//        ruolo.setNome(ruoloDaCercare);
//        ruolo.setDescrizione("Responsabile del reparto");
//        dipendenteService.aggiungiRuolo(ruolo);
//       
//        Utente utente1 = new Utente("Capo", "Giggione", "giggione@example.com");
//        Utente utente2 = new Utente("Dipendente", "Ugo", "Ugo@example.com");
//        utenteService.salvaUtente(utente1);
//        utenteService.salvaUtente(utente2);
//
//        Dipendente dipendente1 = new Dipendente();
//        dipendente1.setNome("Manuel");
//        dipendente1.setCognome("Altruda");
//        dipendente1.setRuolo(ruolo);
//        dipendente1.setStipendioBase(2500.0);
//        dipendenteService.aggiungiDipendente(dipendente1);
//        
//        
//        Date dataPrenotazione = new Date(); // Data di oggi
//        Prenotazione prenotazione = new Prenotazione(dipendente1, postazione1, dataPrenotazione);
//        prenotazioneService.salvaPrenotazione(prenotazione);
//	
//        // Cancellazione di una prenotazione
//        //prenotazioneService.cancellaPrenotazione(prenotazione.getId());      
//        
//
//        // Modifica dello stipendio di un dipendente esistente
//        Long idDipendenteDaModificare = 1L; 
//        Dipendente dipendenteDaModificare = dipendenteService.getDipendenteById(idDipendenteDaModificare);
//        dipendenteService.calcolaStipendio(dipendenteDaModificare);
//        dipendenteService.modificaDipendente(dipendenteDaModificare); // Salva le modifiche nel repository
//
//        // Ricerca dei dipendenti in base al ruolo
//
//        List<Dipendente> dipendentiPerRuolo = dipendenteService.cercaPerRuolo(ruolo);
//        if (!dipendentiPerRuolo.isEmpty()) {
//            System.out.println(Ansi.ansi().fg(Ansi.Color.CYAN).a("Dipendenti con il ruolo '" + ruoloDaCercare + "':").reset());
//            
//            for (Dipendente dipendente : dipendentiPerRuolo) {
//                System.out.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a("ID: " + dipendente.getId() + ", Nome: " + dipendente.getNome() + ", Ruolo: " + dipendente.getRuolo() + ", Stipendio: " + dipendente.getStipendioBase()).reset());
//            }
//        
//        } else {
//            System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("Nessun dipendente trovato con il ruolo '" + ruoloDaCercare + "'.").reset());
//        }
//        
//        // Eliminazione di un dipendente
////        Long idDipendenteDaEliminare = 2L;
////        dipendenteService.eliminaDipendente(idDipendenteDaEliminare);
////        System.out.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a("Dipendente con ID " + idDipendenteDaEliminare + " eliminato.").reset());
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.add(Calendar.DAY_OF_MONTH, -7); // Data inizio intervallo (7 giorni fa)
//        Date startDate = calendar.getTime();
//
//        calendar.add(Calendar.DAY_OF_MONTH, 14); // Data fine intervallo (7 giorni dopo la data inizio)
//        Date endDate = calendar.getTime();
//
//        List<Prenotazione> prenotazioniInIntervallo = prenotazioneService.ricercaPrenotazioniPerIntervalloDate(startDate, endDate);
//        if (!prenotazioniInIntervallo.isEmpty()) {
//            System.out.println(Ansi.ansi().fg(Ansi.Color.CYAN).a("Prenotazioni nell'intervallo di date:").reset());
//            
//            for (Prenotazione prenotazioneIntervallo : prenotazioniInIntervallo) {
//                System.out.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a("Data prenotazione: " + prenotazioneIntervallo.getDataPrenotazione()).reset());
//            }
//        
//        } else {
//            System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("Nessuna prenotazione trovata nell'intervallo di date specificato.").reset());
//        }
//        
//        // Ricerca delle postazioni in base a criteri specifici
//        List<Postazione> postazioniTrovate = postazioneService.ricercaPostazioniAvanzata(TipoPostazione.PRIVATO, "Galiforgnia", 1, dataPrenotazione);
//        if (!postazioniTrovate.isEmpty()) {
//            System.out.println(Ansi.ansi().fg(Ansi.Color.CYAN).a("Postazioni trovate:").reset());
//            
//            for (Postazione postazione : postazioniTrovate) {
//                System.out.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a("Postazione: " + postazione.getDescrizione()).reset());
//            }
//       
//        } else {
//            System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("Nessuna postazione trovata con i criteri specificati.").reset());
//        }
//        
//        //  ricerca utenti in base a criteri specifici
//        List<Utente> utentiTrovati = utenteService.ricercaUtentiPerNomeCompleto("Umberto");
//        if (!utentiTrovati.isEmpty()) {
//            System.out.println(Ansi.ansi().fg(Ansi.Color.CYAN).a("Utenti trovati:").reset());
//           
//            for (Utente utente : utentiTrovati) {
//                System.out.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a("Utente: " + utente.getNomeCompleto()).reset());
//            }
//        
//        } else {
//            System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("Nessun utente trovato con i criteri specificati.").reset());
//        }
//        
//        //  ricerca degli edifici in base a criteri specifici
//        List<Edificio> edificiTrovati = edificioService.ricercaEdificiPerCitta("Galiforgnia");
//        if (!edificiTrovati.isEmpty()) {
//            System.out.println(Ansi.ansi().fg(Ansi.Color.CYAN).a("Edifici trovati:").reset());
//            
//            for (Edificio edificio : edificiTrovati) {
//                System.out.println(Ansi.ansi().fg(Ansi.Color.YELLOW).a("Edificio: " + edificio.getNome()).reset());
//            }
//        
//        } else {
//            System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("Nessun edificio trovato con i criteri specificati.").reset());
//        }
//	
//        AnsiConsole.systemUninstall();
//	}
//}
