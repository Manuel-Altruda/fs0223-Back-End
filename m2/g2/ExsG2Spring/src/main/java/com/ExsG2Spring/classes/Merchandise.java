package com.ExsG2Spring.classes;

import com.ExsG2Spring.interfaces.MenuItem;

public class Merchandise implements MenuItem {
	
	private String nome;
    private double prezzo;

    public Merchandise(String nome, double prezzo) {
        this.nome = nome;
        this.prezzo = prezzo;
    }
    
    public String getDescrizione() {
        return nome;
    }
    
    public String getName() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }
	
}
