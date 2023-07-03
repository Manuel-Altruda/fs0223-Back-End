package com.g1.exceptions;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.g1.main.Main;

public class LogBackLogic {
	
	Logger log = LoggerFactory.getLogger(Main.class);
	private int[] array;

    public LogBackLogic() {
        array = new int[5];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            printArray();
            System.out.println("Inserisci un numero (0 per uscire): ");

            try {
                int value = Integer.parseInt(scanner.nextLine());

                if (value == 0) {
                    exit = true;
                    System.out.println("! PROGRAMMA CHIUSO !");
                	System.out.print(" ");
                } else {
                    System.out.println("Inserisci la posizione (da 0 a 4): ");
                    int position = Integer.parseInt(scanner.nextLine());

                    array[position] = value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Errore: Inserisci un numero valido.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Errore: " + e.getMessage());
                // Logback: Configurazione per gestire l'errore e creare un file di log
                org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LogBackLogic.class);
                logger.error(e.getMessage(), e);
            }
        }
    }

    private void printArray() {
        System.out.print("Array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
