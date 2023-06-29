package com.giorno4.main;

import com.giorno4.classes.Dipendente;
import com.giorno4.classes.GestioneDipendenti;

public class Main {

	public static void main(String[] args) {
		
		/*--- ESERCIZIO 2 ---*/
		Dipendente dipendente1 = new Dipendente(1, Dipendente.Dipartimento.PRODUZIONE);
        dipendente1.stampaDatiDipendente();
        System.out.println("Stipendio mensile: " + Dipendente.calcolaPaga(dipendente1));
        
        System.out.println("");
        
        Dipendente dipendente2 = new Dipendente(2, 1500.0, 40.0, Dipendente.Livello.IMPIEGATO, Dipendente.Dipartimento.AMMINISTRAZIONE);
        dipendente2.stampaDatiDipendente();
        System.out.println("Stipendio mensile: " + Dipendente.calcolaPaga(dipendente2, 10));

        dipendente2.promuovi();
        System.out.println("Nuovo livello: " + dipendente2.promuovi());
        System.out.println("Stipendio mensile: " + Dipendente.calcolaPaga(dipendente2));

        dipendente2.setImportoOrarioStraordinario(50.0);
        System.out.println("Nuovo importo orario straordinario: " + dipendente2.getImportoOrarioStraordinario());
        
        System.out.println("");
        
        /*--- ESERCIZIO 2 ---*/
        GestioneDipendenti gestione = new GestioneDipendenti();
        gestione.eseguiGestioneDipendenti();

	}

}
