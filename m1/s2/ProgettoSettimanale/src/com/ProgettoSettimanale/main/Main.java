package com.ProgettoSettimanale.main;

// import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ProgettoSettimanale.classes.CatalogoBibliotecario;
import com.ProgettoSettimanale.classes.ElementoCatalogo;
import com.ProgettoSettimanale.classes.Libro;
import com.ProgettoSettimanale.classes.Periodo;
import com.ProgettoSettimanale.classes.Rivista;

public class Main {
    private static final String FILE_PATH = "archivio.txt";
    // private static File file = new File("doc/test.txt");
    private static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        CatalogoBibliotecario catalogo = new CatalogoBibliotecario();

        // Aggiunta di elementi al catalogo
        catalogo.aggiungiElemento(new Libro("9780123456789", "L'ignoranza delle persone colte", 2015, 110, "William Hazlit", "Autobiografia"));
        catalogo.aggiungiElemento(new Rivista("9789876543210", "Hacker Journal", 2021, 100, Periodo.MENSILE));
        catalogo.aggiungiElemento(new Libro("9780123456788", "Come si diventa ciò che si è", 1908, 202, "Friedrich Nietzsche", "Autobiografia"));
        catalogo.aggiungiElemento(new Rivista("9789876543211", "Il Mio Computer Idea", 2021, 80, Periodo.SETTIMANALE));

        // Ricerca per anno di pubblicazione {LE GRAFFE ALL'INTERNO DEL LOG.INFO VANNO A RICHIAMARE IL TESTO SCRITTO NEI METODI}
        int annoRicerca = 2021;
        List<ElementoCatalogo> risultatiRicercaAnno = catalogo.ricercaPerAnnoPubblicazione(annoRicerca);
        log.info("Risultati ricerca per anno di pubblicazione {}: {}", annoRicerca, risultatiRicercaAnno);

        // Ricerca per autore
        String autoreRicerca = "Friedrich Nietzsche"; // se qua scrivo altro mi trova un array diverso, anche vuoto
        List<ElementoCatalogo> risultatiRicercaAutore = catalogo.ricercaPerAutore(autoreRicerca);
        log.info("Risultati ricerca per autore {}: {}", autoreRicerca, risultatiRicercaAutore);

        // Rimozione di un elemento
        String codiceIsbnRimozione = "9789876543210";
        catalogo.rimuoviElemento(codiceIsbnRimozione);
        log.info("Elemento con codice ISBN {} rimosso.", codiceIsbnRimozione);

        // Salvataggio su disco dell'archivio
        try {
            catalogo.salvaArchivioSuDisco(FILE_PATH);
            log.info("Archivio salvato su disco.");
        } catch (IOException e) {
            log.error("Errore durante il salvataggio dell'archivio su disco.", e);
        }

        // Caricamento dal disco dell'archivio
        try {
            CatalogoBibliotecario catalogoCaricato = CatalogoBibliotecario.caricaArchivioDaDisco(FILE_PATH);
            log.info("Archivio caricato dal disco: {}", catalogoCaricato);
        } catch (IOException e) {
            log.error("Errore durante il caricamento dell'archivio dal disco.", e);
        }
    }
}


