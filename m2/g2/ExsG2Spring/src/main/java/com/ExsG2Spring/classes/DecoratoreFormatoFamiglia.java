package com.ExsG2Spring.classes;

import com.ExsG2Spring.interfaces.MenuItem;
import com.ExsG2Spring.interfaces.Pizza;

public class DecoratoreFormatoFamiglia extends DecoratorePizza{
	
	private double prezzoFamiglia;
	
	public DecoratoreFormatoFamiglia(Pizza pizza, double prezzoFamiglia) {
        super((MenuItem) pizza);
        this.prezzoFamiglia = prezzoFamiglia;
    }

	@Override
	public String getDescrizione() {
		// TODO Auto-generated method stub
		return pizza.getDescrizione() + " (Formato Famiglia)";
	}

	@Override
	public double getPrezzo() {
		// TODO Auto-generated method stub
		return pizza.getPrezzo() + prezzoFamiglia;
	}
	
}
