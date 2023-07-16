package com.Week_Project.classes;
	
	import java.util.Date;
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.TypedQuery;



	public class Archivio {
	    private EntityManager em;
	    private double importoMultaAlGiorno = 1.0;

	    public Archivio(EntityManager em) {
	        this.em = em;
	    }

	    public void aggiungiElemento(ElementoCatalogo elemento) {
	        em.getTransaction().begin();
	        em.persist(elemento);
	        em.getTransaction().commit();
	    }

	    public void rimuoviElemento(String isbn) {
	        ElementoCatalogo elemento = em.find(ElementoCatalogo.class, isbn);
	        if (elemento != null) {
	            em.getTransaction().begin();
	            em.remove(elemento);
	            em.getTransaction().commit();
	        }
	    }

	    public ElementoCatalogo cercaPerIsbn(String isbn) {
	        return em.find(ElementoCatalogo.class, isbn);
	    }

	    public List<ElementoCatalogo> cercaPerAnnoPubblicazione(int anno) {
	        TypedQuery<ElementoCatalogo> query = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.annoPubblicazione = :anno", ElementoCatalogo.class);
	        query.setParameter("anno", anno);
	        return query.getResultList();
	    }

	    public List<Libro> cercaPerAutore(String autore) {
	        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class);
	        query.setParameter("autore", autore);
	        return query.getResultList();
	    }

	    public List<ElementoCatalogo> cercaPerTitolo(String titolo) {
	        TypedQuery<ElementoCatalogo> query = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.titolo LIKE :titolo", ElementoCatalogo.class);
	        query.setParameter("titolo", "%" + titolo + "%");
	        return query.getResultList();
	    }

	    public List<ElementoCatalogo> cercaElementiInPrestito(String numeroTessera) {
	        TypedQuery<ElementoCatalogo> query = em.createQuery("SELECT p.elementoPrestato FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL", ElementoCatalogo.class);
	        query.setParameter("numeroTessera", numeroTessera);
	        return query.getResultList();
	    }

	    public List<Prestito> cercaPrestitiScaduti() {
	        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL", Prestito.class);
	        return query.getResultList();
	    }
	    
	    
	    /*↓↓ Questi sono metodi extra dell'esercizio ↓↓*/
	    
	    
	    public List<Libro> cercaLibriPerGenere(String genere) {
	        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.genere = :genere", Libro.class);
	        query.setParameter("genere", genere);
	        return query.getResultList();
	   }

	   public List<Rivista> cercaRivistePerPeriodicita(Rivista.Periodicita periodicita) {
	        TypedQuery<Rivista> query = em.createQuery("SELECT r FROM Rivista r WHERE r.periodicita = :periodicita", Rivista.class);
	        query.setParameter("periodicita", periodicita);
	        return query.getResultList();
	   }
	    
	    public void aggiungiPrenotazione(Prenotazione prenotazione) {
	        em.getTransaction().begin();
	        em.persist(prenotazione);
	        em.getTransaction().commit();
	   }

	   public void rimuoviPrenotazione(Long id) {
	        Prenotazione prenotazione = em.find(Prenotazione.class, id);
	        if (prenotazione != null) {
	            em.getTransaction().begin();
	            em.remove(prenotazione);
	            em.getTransaction().commit();
	        }
	   }

	   public List<Prenotazione> cercaPrenotazioniUtente(String numeroTessera) {
	        TypedQuery<Prenotazione> query = em.createQuery("SELECT p FROM Prenotazione p WHERE p.utente.numeroTessera = :numeroTessera", Prenotazione.class);
	        query.setParameter("numeroTessera", numeroTessera);
	        return query.getResultList();
	   }

	   public void aggiungiMulta(Multa multa) {
	        em.getTransaction().begin();
	        em.persist(multa);
	        em.getTransaction().commit();
	   }

	   public List<Multa> cercaMulteUtente(String numeroTessera) {
	        TypedQuery<Multa> query = em.createQuery("SELECT m FROM Multa m WHERE m.prestito.utente.numeroTessera = :numeroTessera", Multa.class);
	        query.setParameter("numeroTessera", numeroTessera);
	        return query.getResultList();
	   }
	   
	   public void calcolaMulte() {
	       List<Prestito> prestitiScaduti = cercaPrestitiScaduti();
	       for (Prestito prestito : prestitiScaduti) {
	           long giorniRitardo = (new Date().getTime() - prestito.getDataRestituzionePrevista().getTime()) / (1000 * 60 * 60 * 24);
	           double importoMulta = giorniRitardo * importoMultaAlGiorno;
	           Multa multa = new Multa(prestito, importoMulta);
	           aggiungiMulta(multa);
	       }
	   }
	}
	