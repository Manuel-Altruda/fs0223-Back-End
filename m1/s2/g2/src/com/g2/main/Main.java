package com.g2.main;


import java.util.List;
import java.util.Scanner;


import com.g2.methods.Ex1_methods;
import com.g2.methods.Ex2_methods;

public class Main {
	
	public static void main(String[] args) {
		/*Ex1_methods m = new Ex1_methods();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Inserisci il numero di elementi: ");
		int numeroElementi = scanner.nextInt();
		
		m.getParole(numeroElementi);
		
		m.stampaParoleDuplicate();
		
		m.stampaNumeroParoleDistinte();
		
		m.stampaElencoParoleDistinte();
		
		scanner.close();*/
		
		Ex2_methods m1 = new Ex2_methods();
		
		List<Integer> listaCombinata = null;
		
		
		int N = 10;
		m1.generateRandomList(N);
			
	    
		System.out.println("Lista casuale: " + N);

		
		m1.listaInvertita(listaCombinata);
	    
		
		System.out.println("Lista combinata: " + listaCombinata);

	    boolean stampaPosizioni1 = true; // Stampa le posizioni pari
	    m1.stampaPosizioni(stampaPosizioni1);
	}

	



}
