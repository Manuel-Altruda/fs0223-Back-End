package com.ExsSpring.classes;

import com.ExsSpring.interfaces.Pizza;

public class DecoratoreFormatoFamiglia extends DecoratorePizza{
	
	private double prezzoFamiglia;
	
	public DecoratoreFormatoFamiglia(Pizza pizza, double prezzoFamiglia) {
        super(pizza);
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
