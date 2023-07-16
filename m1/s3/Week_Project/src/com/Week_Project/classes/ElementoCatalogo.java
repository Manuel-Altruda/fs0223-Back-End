package com.Week_Project.classes;



import javax.persistence.*;




@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ElementoCatalogo {
    @Id
	protected int isbn;
    protected String titolo;
    protected int annoPubblicazione;
    protected int numeroPagine;

    public ElementoCatalogo() {}

    public ElementoCatalogo(int isbn, String titolo, int annoPubblicazione, int numeroPagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    public int getIsbn() {
        return isbn;
    }

    public int setIsbn(int isbn) {
        return this.isbn = isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }
}


