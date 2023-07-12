package com.GestioneEventi.main;

import java.time.LocalDate;
import com.GestioneEventi.classes.Evento;
import com.GestioneEventi.classes.EventoDAO;
import com.GestioneEventi.classes.TipoEvento;


public class Main {

    public static void main(String[] args) {
        // Creazione e salvataggio di un nuovo evento
        Evento evento1 = new Evento("Evento 1", LocalDate.now(), "Descrizione evento 1", TipoEvento.PUBBLICO, 100);
        EventoDAO eventoDAO = new EventoDAO();
        eventoDAO.save(evento1);

        // Recupero dell'evento tramite ID
        Evento eventoRecuperato = eventoDAO.getById(evento1.getId());
        System.out.println("Evento recuperato: " + eventoRecuperato.getTitolo());

        // Eliminazione dell'evento
        eventoDAO.delete(eventoRecuperato);

        // Refresh dell'evento
        eventoDAO.refresh(eventoRecuperato);
        System.out.println("Evento refresh: " + eventoRecuperato.getTitolo());
    }
}


