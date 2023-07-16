package com.Week_Project.classes;



import javax.persistence.Entity;

	
	@Entity
	public class Libro extends ElementoCatalogo {
		private String titolo;
		private String autore;
	    private String genere;
	    private String editore; /*EXTRA*/

	    public Libro() {}

	    public Libro(int isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere, String editore) {
	        super(isbn, editore, annoPubblicazione, numeroPagine);
	        this.titolo = titolo;
	        this.autore = autore;
	        this.genere = genere;
	        this.editore = editore;
	    }

	    public String getAutore() {
	        return autore;
	    }

	    public void setAutore(String autore) {
	        this.autore = autore;
	    }
	    
	    public String getTitolo() {
	        return titolo;
	    }
	    
	    public void setTitolo(String titolo) {
	       this.titolo = titolo;
	    }

	    public String getGenere() {
	        return genere;
	    }

	    public void setGenere(String genere) {
	        this.genere = genere;
	    }
	    
	    public String getEditore() {
	    	return editore;
	    }
	    
	    public void setEditore(String editore) {
	    	this.editore = editore;
	    }
	}

