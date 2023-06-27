package com.giorno2.main;

import com.giorno2.classes.Chiamata;
import com.giorno2.classes.Rettangolo;
import com.giorno2.classes.Sim;

public class Main {

	public static void main(String[] args) {
		Rettangolo rettangolo1 = new Rettangolo(5, 10);
        Rettangolo rettangolo2 = new Rettangolo(3, 7);

        rettangolo1.stampaRettangolo(rettangolo1);
        System.out.println();
        rettangolo2.stampaDueRettangoli(rettangolo1, rettangolo2);
        System.out.println();
        
        Sim sim = new Sim("1234567890");
        
        
        Chiamata chiamata1 = new Chiamata(5, "987654321");
        sim.aggiungiChiamata(chiamata1);

        Chiamata chiamata2 = new Chiamata(10, "555555555");
        sim.aggiungiChiamata(chiamata2);

        
        sim.stampaDatiSim();
	}
	
	

}
