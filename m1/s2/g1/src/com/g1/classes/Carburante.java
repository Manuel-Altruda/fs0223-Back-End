package com.g1.classes;

public class Carburante {
	
	public double calcolaKmPerLitro(double kmPercorsi, double litriConsumati) throws ArithmeticException {
        if (litriConsumati == 0) {
            throw new ArithmeticException("Divisione per zero");
        }

        return kmPercorsi / litriConsumati;
    }

}
