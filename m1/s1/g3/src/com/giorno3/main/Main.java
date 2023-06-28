package com.giorno3.main;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		/*--- ESERCIZIO 1 IF-ELSE-IF-MAIN ---*/
		
		String messaggioOutput = "Ciao a tutti!";
		int anno = 2028;
		
		boolean isStringa = stringaPariDispari(messaggioOutput);
		boolean isAnnoBisestile = annoBisestile(anno);
		
		System.out.println("La stringa ha un numero di caratteri pari? " + isStringa);
		System.out.println("L'anno è bisestile? " + isAnnoBisestile);
		
		/*--- ESERCIZIO 2 SWITCH-MAIN*/ /*SE COMMENTO QUESTO ESERCIZIO IL NUMERO 3 FUNZIONA*/
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un intero: ");
        int numero = scanner.nextInt();
        scanner.close();

        if (numero >= 0 && numero <= 3) {
            //String numeroInLettere = convertiInLettere(numero);
            //System.out.println("Il numero " + numero + " scritto in lettere è: " + numeroInLettere);
        } else {
           //System.out.println("Errore: il numero inserito non è compreso tra 0 e 3.");
        }
        
        /*--- ESERCIZIO 3 WHILE-MAIN ---*/
        
        Scanner scanner_2 = new Scanner(System.in);
        String input;

        do {
            System.out.print("Inserisci una stringa (:q per uscire): ");
            input = scanner_2.nextLine();

            if (!input.equals(":q")) {
                //suddividiStringa(input);
            }
            
        } while (!input.equals(":q"));
        System.out.print("Programma terminato!");
        scanner_2.close();
        
        
        /*--- ESERCIZIO 4 FOR-MAIN ---*/
        
        Scanner scanner_3 = new Scanner(System.in);

        System.out.print("Inserisci un numero intero: ");
        int numero2 = scanner_3.nextInt();

        System.out.println("Conto alla rovescia:");
        contaAllaRovescia(numero2);

        scanner_3.close();
        /*--- FINE ESERCIZIO 4 ---*/
        
	}
	/*--- ESERCIZIO 1 IF-ELSE-IF ---*/
	
	public static boolean stringaPariDispari(String inputString) {
        int length = inputString.length();
        return length % 2 == 0;
    }
	
	 public static boolean annoBisestile(int year) {
	        if (year % 4 == 0) {
	            if (year % 100 == 0) {
	                return year % 400 == 0;
	            } else {
	                return true;
	            }
	        } else {
	            return false;
	        }
	    }/*--- FINE ESERCIZIO 1 ---*/

	 /*--- ESERCIZIO 2 SWITCH ---*/
	 
	 public static String convertiInLettere(int numero) {
	        String numeroInLettere;
	        switch (numero) {
	            case 0:
	                numeroInLettere = "zero";
	                break;
	            case 1:
	                numeroInLettere = "uno";
	                break;
	            case 2:
	                numeroInLettere = "due";
	                break;
	            case 3:
	                numeroInLettere = "tre";
	                break;
	            default:
	                numeroInLettere = "numero non valido";
	        }
	        return numeroInLettere;
	    } /*--- FINE ESERCIZIO 2 ---*/
	 
	 /*--- ESERCIZIO 3 WHILE ---*/
	 
	 public static void suddividiStringa(String input) {
		 StringBuilder result = new StringBuilder();
	        for (int i = 0; i < input.length(); i++) {
	            char character = input.charAt(i);
	            result.append(character);
	            if (i < input.length() - 1) {
	                result.append(", ");
	            }
	        }
	        System.out.println("Questa è la stringa suddivisa in caratteri separati da virgola:");
	        System.out.println(result.toString());
	        System.out.println();
	        
	    }/*--- FINE ESERCIZIO 3 ---*/
	 
	 /*--- ESERCIZIO 4 FOR-MAIN ---*/
	 
	 public static void contaAllaRovescia(int numero) {
	        if (numero >= 0) {
	            for (int i = numero; i >= 0; i--) {
	                System.out.println(i);
	            }
	        } else {
	            System.out.println("Errore: il numero deve essere non negativo.");
	        }
	    }
	}

