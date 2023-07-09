package com.ProgettoSettimanale.classes;

public abstract class ElementoCatalogo {
	private String codiceIsbn;
	private String titolo;
	private int annoPubblicazione;
	private int numeroPagine;
	
	public ElementoCatalogo(String codiceIsbn, String titolo, int annoPubblicazione, int numeroPagine) {
		this.codiceIsbn = codiceIsbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
	}
	
	public String getCodiceIsbn() {
		return codiceIsbn;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public int getAnnoPubblicazione() {
		return annoPubblicazione;
	}
	
	public int getNumeroPagine() {
		return numeroPagine;
	}
	
	@Override
	public String toString() {
		return "Elemento Catalogo:[ " + "Codice Isbn = " + codiceIsbn + ", titolo = " + titolo 
				+ '\'' + ", Anno Pubblicazione = " + annoPubblicazione + 
				", Numero Pagine = " + numeroPagine + "]";
	}

}
