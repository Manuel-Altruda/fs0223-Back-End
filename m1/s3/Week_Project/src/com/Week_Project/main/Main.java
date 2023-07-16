package com.Week_Project.main;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Week_Project.classes.Archivio;
import com.Week_Project.classes.Libro;
import com.Week_Project.classes.Multa;
import com.Week_Project.classes.Prestito;
import com.Week_Project.classes.Rivista;
import com.Week_Project.classes.Utente;

	public class Main {
		
        
	    public static void main(String[] args) {
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo-bibliotecario");
	    	EntityManager em = emf.createEntityManager();
	        Archivio archivio = new Archivio(em);

	        
	        Libro libro = new Libro(4218, "La scienza Gaia ", 1954, 1000, "Friedrich Nietzsche", "Filosofia", "Friedrich Nietzsche");
	        archivio.aggiungiElemento(libro);

	         
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Inserisci il genere dei libri da cercare: ");
	        String genere = scanner.nextLine();
	        List<Libro> libri = archivio.cercaLibriPerGenere(genere);
	        for (Libro l : libri) {
	            System.out.println(l.getTitolo() + " di " + l.getAutore() + ", editore: " + l.getEditore());
	        }

	        
	        Rivista rivista = new Rivista(19328, "Hacker's Day", 1878, 150, Rivista.Periodicita.MENSILE);
	        rivista.setIsbn(1820); // Assegno manualmente un ID unico
	        rivista.setTitolo("Titolo rivista");
	        rivista.setAnnoPubblicazione(2022);
	        rivista.setNumeroPagine(50);
	        rivista.setPeriodicita(Rivista.Periodicita.SETTIMANALE);
	        archivio.aggiungiElemento(rivista);

	        
	        System.out.print("Inserisci la periodicita delle riviste da cercare (SETTIMANALE, MENSILE, SEMESTRALE): ");
	        String periodicita = scanner.nextLine();
	        List<Rivista> riviste = archivio.cercaRivistePerPeriodicita(Rivista.Periodicita.valueOf(periodicita));
	        for (Rivista r : riviste) {
	            System.out.println(r.getTitolo() + ", periodicita: " + r.getPeriodicita());
	        }

	        
	        Utente utente = new Utente("Manuel", "Altruda", new Date(), "6101");
	        em.getTransaction().begin();
	        em.persist(utente);
	        em.getTransaction().commit();
	        
	        Utente utente2 = new Utente("Giuseppe", "Giallo", new Date(), "8220");
	        em.getTransaction().begin();
	        em.persist(utente2);
	        em.getTransaction().commit();

	        Prestito prestito = new Prestito(utente2, libro, new Date());
	        
	        Calendar calendar = Calendar.getInstance();
	        calendar.add(Calendar.DAY_OF_MONTH, -40); // prestito scaduto da 10 giorni
	        prestito.setDataInizioPrestito(calendar.getTime());
	        em.getTransaction().begin();
	        em.persist(prestito);
	        em.getTransaction().commit();

	        archivio.calcolaMulte(); 
	        

	        System.out.print("Inserisci il numero tessera dell'utente per cercare le sue multe: ");
	        String numeroTessera = scanner.nextLine();
	        List<Multa> multe = archivio.cercaMulteUtente(numeroTessera);
	        for (Multa m : multe) {
	            System.out.println("Multa di " + m.getImporto() + " euro per il prestito del libro " + m.getPrestito().getElementoPrestato().getTitolo());
	        } 
	        System.out.println("Utente: " + utente + "non ha multe ");
	        

	        scanner.close();
	        em.close();
	        emf.close();
	    }
	}
