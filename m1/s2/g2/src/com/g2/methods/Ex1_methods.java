package com.g2.methods;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex1_methods {
	Set<String> parole = new HashSet<>();
	
	/*--- Metodo per ottenere le parole dall'utente ---*/
	
	public Set<String> getParole(int numeroElementi) {
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i = 0; i < numeroElementi; i++) {
			
			System.out.print("Inserisci la parola " + (i + 1) + ": ");
	        String parola = scanner.next();
	        parole.add(parola);	
		}
		
		scanner.close();
		return parole;
	}
	
	/*--- Metodo per stampare le parole duplicate ---*/
		
		public void  stampaParoleDuplicate()  {
			Set<String> paroleDuplicate = new HashSet<>();
			Set<String> paroleUniche = new HashSet<>();
		
		for (String parola : parole) {
			
			if (!paroleUniche.add(parola)) {
				paroleDuplicate.add(parola);
			} 
		}
		
		System.out.println("Parole Duplicate: ");
		for (String parola : paroleDuplicate) {
			System.out.println(parola);
		}
	}
	
	/*--- Metodo per stampare il numero delle parole distinte ---*/
	
	public void stampaNumeroParoleDistinte() {
		int numeroParoleDistinte = parole.size();
		System.out.println("Numero di parole distinte: " + numeroParoleDistinte);	
	}
	
	/*--- Metodo per stampare l'elenco delle parole distinte ---*/
	
	public void stampaElencoParoleDistinte() {	
		System.out.println("Elenco parole distinte: ");
		
		for (String parola : parole) {
			System.out.println(parola);
		}
		
	}

	

}
