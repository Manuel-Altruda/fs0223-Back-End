package com.ProgettoSettimanale.classes;

public class Rivista extends ElementoCatalogo {
	private Periodo periodicita;

	public Rivista(String codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine, Periodo periodicita) {
		super(codiceIsbn, titolo, annoPubblicazione, numeroPagine);
		
	}

	public Periodo getPeriodicità() {
		return periodicita;
	}
	
	@Override
	public String toString() {
		return "Rivista: [ " + "Codice Isbn = " + getCodiceIsbn() + ", Titolo = " + getTitolo()
		+ ", Anno di Pubblicazione = " + getAnnoPubblicazione() + 
		" Numero Pagine = " + getNumeroPagine() + " Periodicità = " + periodicita + "]";
	}

}
