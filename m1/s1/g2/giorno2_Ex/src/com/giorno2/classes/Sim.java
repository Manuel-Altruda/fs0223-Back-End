package com.giorno2.classes;

import java.util.ArrayList;
import java.util.List;

public class Sim {
	 
	private String numeroTelefono;
    private double creditoDisponibile;
    private List<Chiamata> ultimeChiamate;

    public Sim(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
        this.creditoDisponibile = 0;
        this.ultimeChiamate = new ArrayList<>();
    }
	public void stampaDatiSim() {
		
	    System.out.println("Numero di telefono: " + numeroTelefono);
	    System.out.println("Credito disponibile: " + creditoDisponibile + " euro");
	    System.out.println();
	    System.out.println("Ultime chiamate effettuate:");
	    if (ultimeChiamate.isEmpty()) {
	        System.out.println("Nessuna chiamata effettuata.");
	    } else {
	        for (Chiamata chiamata : ultimeChiamate) {
	            System.out.println("Numero chiamato: " + chiamata.getNumeroChiamato());
	            System.out.println("Durata: " + chiamata.getDurata() + " minuti");
	            System.out.println("-------------------------");
	           }
	       }
	   }
	
	public void aggiungiChiamata(Chiamata chiamata) {
        ultimeChiamate.add(chiamata);

        // Limita la lista delle chiamate alle ultime 5
        if (ultimeChiamate.size() > 5) {
            ultimeChiamate.remove(0);
        }
    }
}
