package com.giorno4.classes;

public class Dipendente {
	
	/*--- ESERCIZIO 1 ---*/
	private static Livello livello;
    private static Dipartimento dipartimento;
	private static double stipendioBase = 1000.0;
	
    private int matricola;
    private double stipendio;
    private double importoOrarioStraordinario;
    
    
    public Dipendente(int matricola, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendioBase;
        this.importoOrarioStraordinario = 30.0;
        Dipendente.livello = Livello.OPERAIO;
        Dipendente.dipartimento = dipartimento;
        
    }  
    
    public Dipendente(int matricola, double stipendio, double importoOrarioStraordinario, Livello livello, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.importoOrarioStraordinario = importoOrarioStraordinario;
        Dipendente.livello = livello;
        Dipendente.dipartimento = dipartimento;
    }
    
    public void stampaDatiDipendente() {
        System.out.println("Matricola: " + matricola);
        System.out.println("Stipendio: " + stipendio);
        System.out.println("Importo orario straordinario: " + importoOrarioStraordinario);
        System.out.println("Livello: " + livello);
        System.out.println("Dipartimento: " + dipartimento);
    }
    
    public Livello promuovi() {
        if (livello == Livello.OPERAIO) {
            livello = Livello.IMPIEGATO;
            stipendio = stipendioBase * 1.2;
        } else if (livello == Livello.IMPIEGATO) {
            livello = Livello.QUADRO;
            stipendio = stipendioBase * 1.5;
        } else if (livello == Livello.QUADRO) {
            livello = Livello.DIRIGENTE;
            stipendio = stipendioBase * 2;
        } else {
            System.out.println("Errore: Il dipendente è già un dirigente.");
        }
        return livello;
    }
    
    public static double calcolaPaga(Dipendente dipendente) {
        return dipendente.stipendio;
    }

    public static double calcolaPaga(Dipendente dipendente, int oreStraordinario) {
        double stipendioConStraordinario = dipendente.stipendio + (oreStraordinario * dipendente.importoOrarioStraordinario);
        return stipendioConStraordinario;
    }
    
    public double getStipendio() {
        return stipendio;
    }

    public double getImportoOrarioStraordinario() {
        return importoOrarioStraordinario;
    }

    public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
        this.importoOrarioStraordinario = importoOrarioStraordinario;
    }
    
    public enum Livello {
   	 	OPERAIO,
        IMPIEGATO,
        QUADRO,
        DIRIGENTE
   }
    
    public enum Dipartimento {
    	PRODUZIONE,
        AMMINISTRAZIONE,
        VENDITE
    } /*--- FINE ESERCIZIO 1 ---*/
    
    /*--- ESERCIZIO 2 ---*/
    private String nome;
	private String ruolo;

	public Dipendente(String nome, String ruolo, double stipendio) {
        this.nome = nome;
        this.ruolo = ruolo;
        this.stipendio = stipendio;
        
	}
        
        public void setRuolo(String ruolo) {
            this.ruolo = ruolo;
        }

        public void setStipendio(double stipendio) {
            this.stipendio = stipendio;
        }

        public String getNome() {
            return nome;
        }

        public String getRuolo() {
            return ruolo;
        }

        public double getStipendio1() {
            return stipendio;
        }

        public void stampaStato() {
            System.out.println("Nome: " + nome + ", Ruolo: " + ruolo + ", Stipendio: " + stipendio);
        
    }
}
