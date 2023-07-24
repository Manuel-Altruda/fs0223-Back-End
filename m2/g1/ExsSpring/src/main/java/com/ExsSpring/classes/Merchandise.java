package com.ExsSpring.classes;

public class Merchandise {
	
	private String nome;
    private double prezzo;

    public Merchandise(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public String getName() {
        return nome;
    }

    public double getPrice() {
        return prezzo;
    }
	
}
