package com.g1.main;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.g1.classes.Carburante;
import com.g1.classes.ContoCorrente;
import com.g1.classes.ContoOnLine;
import com.g1.exceptions.BancaException;
import com.g1.exceptions.LogBackLogic;

public class Main {
	
	public static void main(String[] args) {
		
		/*--- ESERCIZIO 1 ---*/
		Logger log = LoggerFactory.getLogger(Main.class);
		
		LogBackLogic logBackLogic = new LogBackLogic();
		logBackLogic.run();

		
		LogBackLogic l = new LogBackLogic();
		
		l.run();
		
		/*--- FINE ESERCIZIO 1 ---*/
		System.out.print(" ");
		/*--- ESERCIZIO 2 ---*/
		
		try {
            Scanner input = new Scanner(System.in);

            System.out.print("Inserisci il numero di km percorsi: ");
            double kmPercorsi = input.nextDouble();

            System.out.print("Inserisci il numero di litri di carburante consumati: ");
            double litriConsumati = input.nextDouble();

            Carburante carburante = new Carburante();
            double kmPerLitro = carburante.calcolaKmPerLitro(kmPercorsi, litriConsumati);
            System.out.println("Consumo: " + kmPerLitro + " km/litro");

            input.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            log.error("Errore durante il calcolo del consumo di carburante: {}", e.getMessage());
        }
		/*--- FINE ESERCIZIO 2 ---*/
		
		/*--- ESERCIZIO 3 ---*/
		
		ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 1000.0);

		System.out.println("Saldo conto: " + conto1.restituisciSaldo());

		try {
			conto1.preleva(1750.5);

			System.out.println("Saldo conto: " + conto1.restituisciSaldo());
		} catch (BancaException e) {
			System.out.println("Errore durante il prelievo: " + e);
			e.printStackTrace();
		}

		ContoOnLine conto2 = new ContoOnLine("Rossi Luigi", 50350.0, 1500);

		conto2.stampaSaldo();

		try {
			conto2.preleva(2000);

			conto2.stampaSaldo();

		} catch (BancaException e) {
			System.out.println("Errore durante il prelievo: " + e);
			e.printStackTrace();
		}
		/*--- FINE ESERCIZIO 3 ---*/
	
	}

}
