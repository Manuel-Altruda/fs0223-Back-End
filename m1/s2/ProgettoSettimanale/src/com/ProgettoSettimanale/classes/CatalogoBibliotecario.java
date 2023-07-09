package com.ProgettoSettimanale.classes;

  
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class CatalogoBibliotecario {
    private List<ElementoCatalogo> archivio;

    public CatalogoBibliotecario() {
        archivio = new ArrayList<>();
    }

    public void aggiungiElemento(ElementoCatalogo elemento) {
        archivio.add(elemento);
    }

    public void rimuoviElemento(String codiceIsbn) {
        archivio.removeIf(elemento -> elemento.getCodiceIsbn().equals(codiceIsbn));
    }

    public List<ElementoCatalogo> ricercaPerAnnoPubblicazione(int anno) {
        return archivio.stream()
                .filter(elemento -> elemento.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());
    }

    public List<ElementoCatalogo> ricercaPerAutore(String autore) {
        return archivio.stream()
                .filter(elemento -> elemento instanceof Libro)
                .filter(elemento -> ((Libro) elemento).getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    public void salvaArchivioSuDisco(String filePath) throws IOException {
        List<String> lines = archivio.stream()
                .map(ElementoCatalogo::toString)
                .collect(Collectors.toList());
        Files.write(Path.of(filePath), lines);
    }

    public static CatalogoBibliotecario caricaArchivioDaDisco(String filePath) throws IOException {
        CatalogoBibliotecario catalogo = new CatalogoBibliotecario();
        List<String> lines = Files.readAllLines(Path.of(filePath));
        for (String line : lines) {
            String[] tokens = line.split(",");
            if (tokens.length >= 4) {
                String tipoElemento = tokens[0];
                String codiceIsbn = tokens[1];
                String titolo = tokens[2];
                int annoPubblicazione = Integer.parseInt(tokens[3]);
                int numeroPagine = Integer.parseInt(tokens[4]);
                if (tipoElemento.equals("Libro")) {
                    String autore = tokens[5];
                    String genere = tokens[6];
                    catalogo.aggiungiElemento(new Libro(codiceIsbn, titolo, annoPubblicazione, numeroPagine, autore, genere));
                } else if (tipoElemento.equals("Rivista")) {
                    String periodicitaStr = tokens[5];
                    Periodo periodicita = Periodo.valueOf(periodicitaStr);
                    catalogo.aggiungiElemento(new Rivista(codiceIsbn, titolo, annoPubblicazione, numeroPagine, periodicita));
                }
            }
        }
        return catalogo;
    }

    @Override
    public String toString() {
        return "CatalogoBibliotecario{" +
                "archivio=" + archivio +
                '}';
    }
}