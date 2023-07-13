package com.EventManagement.main;

import java.util.List;

import com.EventManagement.classes.*;

public class Main {

	public static void main(String[] args) {
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
        for (Persona persona : persone) {
            System.out.println(persona.getNome() + " " + persona.getCognome());
        }

        System.out.println("Locations:");
        for (Location location : locations) {
            System.out.println(location.getNome() + " - " + location.getCittà());
        }

        System.out.println("Eventi:");
        for (Evento evento : eventi) {
            System.out.println(evento.getTitolo() + " - " + evento.getDataEvento());
        }

        System.out.println("Partecipazioni:");
        for (Partecipazione partecipazione : partecipazioni) {
            System.out.println("Persona: " + partecipazione.getPersona().getNome() +
                    " Evento: " + partecipazione.getEvento().getTitolo() +
                    " Stato: " + partecipazione.getStato());
        }
    }

}


