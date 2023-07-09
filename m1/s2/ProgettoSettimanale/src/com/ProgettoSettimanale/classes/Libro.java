package com.ProgettoSettimanale.classes;

public class Libro extends ElementoCatalogo {
	private String autore;
	private String genere;
	
	public Libro(String codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
		super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
		this.autore = autore;
		this.genere = genere;
	}
	
	public String getAutore() {
		return autore;
	}
	
	public String getGenere() {
		return genere;
	}
	
	@Override
	public String toString() {
		return "Libro: [ " + "Codice Isbn = " + getCodiceIsbn() + ", Titolo = " + getTitolo()
				+ ", Anno di Pubblicazione = " + getAnnoPubblicazione() + 
				"Numero Pagine = " + getNumeroPagine() + " Autore = " + autore
				+ " Genere = " + genere + "]";
	}

}
