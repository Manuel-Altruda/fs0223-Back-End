package com.giorno4.classes;

public class GestioneDipendenti {
	
	public void eseguiGestioneDipendenti() {
	        Dipendente operaio1 = new Dipendente("Mario Rossi", "Operaio", 1500);
	        Dipendente operaio2 = new Dipendente("Luigi Bianchi", "Operaio", 1500);
	        Dipendente impiegato = new Dipendente("Giovanni Verdi", "Impiegato", 2000);
	        Dipendente dirigente = new Dipendente("Carlo Gialli", "Dirigente", 3000);

	        // Promuovo l'operaio a impiegato
	        operaio1.setRuolo("Impiegato");

	        // Promuovo l'impiegato a quadro
	        impiegato.setRuolo("Quadro");

	        
	        operaio1.stampaStato();
	        operaio2.stampaStato();
	        impiegato.stampaStato();
	        dirigente.stampaStato();

	        // Calcola la somma di tutti gli stipendi con 5 ore di straordinario
	        double sommaStipendi = operaio1.getStipendio() + operaio2.getStipendio() + impiegato.getStipendio() + dirigente.getStipendio();
	        double straordinario = 5 * 10; //  l'ora di straordinario pagata 10 euro
	        double stipendiTotali = sommaStipendi + straordinario;

	        System.out.println("Somma degli stipendi: " + stipendiTotali);
	    }
}
