package com.giorno3.classes;

public class SimboloThread extends Thread {
	private final String simbolo;
	
	public SimboloThread(String simbolo) {
		
		this.simbolo = simbolo;
			
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.print(simbolo);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
