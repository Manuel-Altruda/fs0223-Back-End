package com.giorno3.classes;

public class SumThread extends Thread {
	private int array [];
	private int inizioIndice;
	private int fineIndice;
	private int sommaParziale [];
	private int indiceThread;
	
	public SumThread (int array [], int inizioIndice, int fineIndice, int sommaParziale[], int indiceThread) {
		this.array = array;
		this.inizioIndice = inizioIndice;
		this.fineIndice = fineIndice;
		this.sommaParziale = sommaParziale;
		this.indiceThread = indiceThread;
	}
	
	public void run() {
		int sum = 0;
		for (int i = inizioIndice; i < fineIndice; i++) {
			sum += array[i];
		}
		sommaParziale[indiceThread] = sum;
	}
	
}
