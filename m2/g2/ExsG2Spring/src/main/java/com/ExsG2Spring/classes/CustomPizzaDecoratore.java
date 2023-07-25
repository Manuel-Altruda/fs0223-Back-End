package com.ExsG2Spring.classes;

import com.ExsG2Spring.interfaces.MenuItem;

public class CustomPizzaDecoratore extends DecoratorePizza {
	
	private String nomeCustom;
    private double prezzoCustom;
	
	
	public CustomPizzaDecoratore(MenuItem pizza, String nomeCustom, double prezzoCustom) {
		super(pizza);
		this.nomeCustom = nomeCustom;
        this.prezzoCustom = prezzoCustom;
	}
	
	@Override
	public String getDescrizione() {
		return super.getDescrizione() + ", " + nomeCustom;
	}
	@Override
	public double getPrezzo() {
		return super.getPrezzo() + prezzoCustom;
	}
    
	public String getNomeCustom() {
        return nomeCustom;
    }
    
}
