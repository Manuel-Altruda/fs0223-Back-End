package com.giorno3.main;

import java.util.Random;

import com.giorno3.classes.Presenza;
import com.giorno3.classes.RegistroPresenze;
import com.giorno3.classes.SimboloThread;
import com.giorno3.classes.SumThread;

public class Main {
	private static final int ARRAY_SIZE = 3000;
	private static final int THREAD_COUNTER = 3;

	public static void main(String[] args) {
		/*--- ESERCIZIO 1 ---*/
		Thread thread = new SimboloThread("*");
		Thread thread1 = new SimboloThread("#");
		
		thread.start();
		thread1.start();
		/*--- FINE ESERCIZIO 1 ---*/
		
		/*--- ESERCIZIO 2 ---*/
		int[] array = generateRandomArray(ARRAY_SIZE);
		int[] sommaParziale = new int [THREAD_COUNTER];
		SumThread[] threads = new SumThread[THREAD_COUNTER];
		
		int partitionSize = ARRAY_SIZE / THREAD_COUNTER;
		for (int i = 0; i < THREAD_COUNTER; i++) {
			int inizioIndice = i * partitionSize;
			int fineIndice = (i == THREAD_COUNTER - 1) ? ARRAY_SIZE : inizioIndice + partitionSize;
			threads[i] = new SumThread(array, inizioIndice, fineIndice, array, i);
			threads[i].start();
		}
		
		try {
			for (SumThread thread2 : threads) {
				thread2.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int totalSum = 0;
		for (int sum : array) {
			totalSum += sum;
		}
		System.out.println("Somma Totale: " + totalSum);
		
		/*--- ESERCIZIO 3 ---*/
		RegistroPresenze registroPresenze = new RegistroPresenze();
		registroPresenze.aggiungiPresenza("Mario Rossi", 5);
		registroPresenze.aggiungiPresenza("Silvio Berlusconi", 7);
		registroPresenze.aggiungiPresenza("Gianni Morandi", 7);
		
		registroPresenze.salvaPresenzaSuFile("presenze.txt");
		
		RegistroPresenze registroPresenze2 = new RegistroPresenze();
		registroPresenze2.caricaPresenzeDaFile("presenze.txt");
		
		for (Presenza presenza : registroPresenze2.presenze) {
			System.out.println("Nome: " + presenza.getNome() + ", Giorni di presenza: " + presenza.getGiorniPresenza());
			
		}
		/*--- FINE ESERCIZIO 3 ---*/
	}

	private static int[] generateRandomArray(int size) {
		int array[] = new int[size];
		Random random = new Random();
		for (int i = 0; i < size; i++) {
			array[i] = random.nextInt(100);
		}
		return array;
	}
	/*--- FINE ESERCIZIO 2 ---*/
	
	
	
}
	

