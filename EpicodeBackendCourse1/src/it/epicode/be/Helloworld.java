package it.epicode.be;

import java.util.Arrays;
import java.util.Scanner;

public class Helloworld {
	
	  public static void main(String[] args) {
	        int a = 5;
	        int b = 3;
	        int prodotto = moltiplica(a, b);
	        System.out.println("Il prodotto di " + a + " e " + b + " è: " + prodotto);

	        String inputString = "Hello";
	        int inputInt = 123;
	        String risultatoConcatenazione = concatena(inputString, inputInt);
	        System.out.println("La concatenazione di " + inputString + " e " + inputInt + " è: " + risultatoConcatenazione);
	        
	        /*-------------------------------------------------------------*/
	        
	        String[] array = {"stringa1", "stringa2", "stringa3", "stringa4", "stringa5"};
	        String nuovaStringa = "Carbonara";
	        String[] nuovoArray = inserisciInArray(array, nuovaStringa);
	        System.out.println("Il nuovo array è: " + Arrays.toString(nuovoArray));
	        
	        /*-------------------------------------------------------------*/
	        
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Inserisci la prima stringa: ");
	        String primaStringa = scanner.nextLine();

	        System.out.print("Inserisci la seconda stringa: ");
	        String secondaStringa = scanner.nextLine();

	        System.out.print("Inserisci la terza stringa: ");
	        String terzaStringa = scanner.nextLine();

	        // Concatenazione delle stringhe nell'ordine di inserimento
	        String concatenazioneOrdineInserimento = primaStringa + secondaStringa + terzaStringa;
	        System.out.println("Concatenazione (Ordine di inserimento): " + concatenazioneOrdineInserimento);

	        // Concatenazione delle stringhe nell'ordine di inserimento inverso
	        String concatenazioneOrdineInserimentoInverso = terzaStringa + secondaStringa + primaStringa;
	        System.out.println("Concatenazione (Ordine di inserimento inverso): "  +  concatenazioneOrdineInserimentoInverso);
	        
	        /*-------------------------------------------------------------*/
	        
	        // Calcolo del perimetro di un rettangolo
	        System.out.println("Inserisci la lunghezza del primo lato del rettangolo:");
	        double lato1 = scanner.nextDouble();
	        System.out.println("Inserisci la lunghezza del secondo lato del rettangolo:");
	        double lato2 = scanner.nextDouble();
	        double perimetroRettangolo = calcolaPerimetroRettangolo(lato1, lato2);
	        System.out.println("Il perimetro del rettangolo è: " + perimetroRettangolo);

	        // Verifica se un numero è pari o dispari
	        System.out.println("Inserisci un numero intero:");
	        int numero = scanner.nextInt();
	        int pariDispari = verificaPariDispari(numero);
	        System.out.println("Il numero è: " + (pariDispari == 0 ? "pari" : "dispari"));

	        // Calcolo dell'area di un triangolo utilizzando la formula di Erone
	        System.out.println("Inserisci la lunghezza del primo lato del triangolo:");
	        double latoA = scanner.nextDouble();
	        System.out.println("Inserisci la lunghezza del secondo lato del triangolo:");
	        double latoB = scanner.nextDouble();
	        System.out.println("Inserisci la lunghezza del terzo lato del triangolo:");
	        double latoC = scanner.nextDouble();
	        double areaTriangolo = calcolaAreaTriangolo(latoA, latoB, latoC);
	        System.out.println("L'area del triangolo è: " + areaTriangolo);
	  }
	    

	    public static int moltiplica(int a, int b) {
	        return a * b;
	    }

	    public static String concatena(String stringa, int num) {
	        return stringa + num;
	    }

	    public static String[] inserisciInArray(String[] array, String nuovaStringa) {
	        String[] nuovoArray = new String[6];
	        nuovoArray[0] = array[0];
	        nuovoArray[1] = array[1];
	        nuovoArray[2] = nuovaStringa;
	        nuovoArray[3] = array[3];
	        nuovoArray[4] = array[4];
	        nuovoArray[5] = array[2];
	        return nuovoArray;
	    }
	    
	    public static double calcolaPerimetroRettangolo(double lato1, double lato2) {
	        return 2 * (lato1 + lato2);
	    }

	    public static int verificaPariDispari(int numero) {
	        return numero % 2;
	    }

	    public static double calcolaAreaTriangolo(double latoA, double latoB, double latoC) {
	        double semiperimetro = (latoA + latoB + latoC) / 2;
	        return Math.sqrt(semiperimetro * (semiperimetro - latoA) * (semiperimetro - latoB) * (semiperimetro - latoC));
	    }
}




