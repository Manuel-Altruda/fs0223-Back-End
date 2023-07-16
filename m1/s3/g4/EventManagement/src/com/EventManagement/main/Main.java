package com.EventManagement.main;

import java.util.Date;
import java.util.List;

import com.EventManagement.classes.*;

public class Main {

	public static void main(String[] args) {
	// Creazione di un'istanza di Persona
        Persona persona = new Persona("Manuel", "Altruda", "manuel@email.com",
                new Date(), Sesso.MASCHIO);

        // Creazione di un'istanza di Location
        Location location = new Location("Italia", "Napoli");

        // Creazione di un'istanza di Evento
        Evento evento = new Evento("Via Crucis", new Date(),
                "Camminerete per tutta napoli per glorificare l'altissimo", TipoEvento.PUBBLICO, 100);
		
        // Creazione dei DAO
        PersonaDAO personaDAO = new PersonaDAO();
        LocationDAO locationDAO = new LocationDAO();
        EventoDAO eventoDAO = new EventoDAO();
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO();

        // Recupero di tutte le entità dal database
        List<Persona> persone = personaDAO.getAllPersone();
        List<Location> locations = locationDAO.getAllLocations();
        List<Evento> eventi = eventoDAO.getAllEventi();
        List<Partecipazione> partecipazioni = partecipazioneDAO.getAllPartecipazioni();

        // Stampa delle entità recuperate
        System.out.println("Persone:");
        for (Persona persona1 : persone) {
            System.out.println(persona.getNome() + " " + persona1.getCognome());
        }

        System.out.println("Locations:");
        for (Location location1 : locations) {
            System.out.println(location.getNome() + " - " + location.getCittà());
        }

        System.out.println("Eventi:");
        for (Evento evento1 : eventi) {
            System.out.println(evento.getTitolo() + " - " + evento1.getDataEvento() + " - " + evento.getDescrizione());
        }

        System.out.println("Partecipazioni:");
        for (Partecipazione partecipazione : partecipazioni) {
            System.out.println("Persona: " + partecipazione.getPersona().getNome() +
                    " Evento: " + partecipazione.getEvento().getTitolo() +
                    " Stato: " + partecipazione.getStato());
        }
    }

}


