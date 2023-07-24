package com.ExsSpring.classes;

import com.ExsSpring.interfaces.Pizza;

public class CustomPizzaDecoratore extends DecoratorePizza {
	
	private String nomeCustom;
    private double prezzoCustom;
	
	
	public CustomPizzaDecoratore(Pizza pizza, String nomeCustom, double prezzoCustom) {
		super(pizza);
		this.nomeCustom = nomeCustom;
        this.prezzoCustom = prezzoCustom;
	}
	
	@Override
	public String getDescrizione() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public double getPrezzo() {
		// TODO Auto-generated method stub
		return pizza.getPrezzo() + prezzoCustom;
	}
    
	public String getNomeCustom() {
        return nomeCustom;
    }
    
}
