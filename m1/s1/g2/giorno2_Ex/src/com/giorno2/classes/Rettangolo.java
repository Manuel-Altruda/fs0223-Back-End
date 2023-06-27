package com.giorno2.classes;

public class Rettangolo {
	private double altezza;
	private double larghezza;
	
	public Rettangolo (double altezza, double larghezza) {
		this.altezza = altezza;
		this.larghezza = larghezza;
	}
	
	public double calcolaArea() {
		return altezza * larghezza;
	}
	
	public double calcolaPerimetro() {
		return 2 * (altezza + larghezza);
	}
	
	public static void stampaRettangolo(Rettangolo rettangolo) {
			double area = rettangolo.calcolaArea();
			double perimetro = rettangolo.calcolaPerimetro();
			
			System.out.println("Area: " + area);
			System.out.println("Perimetro: " + perimetro);
		}
		
		public static void stampaDueRettangoli(Rettangolo rettangolo_1, Rettangolo rettangolo_2) {
			double area1 = rettangolo_1.calcolaArea();
			double perimetro1 = rettangolo_1.calcolaPerimetro();
			double area2 = rettangolo_2.calcolaArea();
			double perimetro2 = rettangolo_2.calcolaPerimetro();
			
			System.out.println("Area rettangolo 1: " + area1);
		    System.out.println("Perimetro rettangolo 1: " + perimetro1);
		    System.out.println("Area rettangolo 2: " + area2);
		    System.out.println("Perimetro rettangolo 2: " + perimetro2);
		    
		    double sommaAree = area1 + area2;
	        double sommaPerimetri = perimetro1 + perimetro2;

	        System.out.println("Somma delle aree: " + sommaAree);
	        System.out.println("Somma dei perimetri: " + sommaPerimetri);
		}
}

	
		
		
		


