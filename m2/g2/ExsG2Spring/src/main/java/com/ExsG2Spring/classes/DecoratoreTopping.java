package com.ExsG2Spring.classes;

import com.ExsG2Spring.interfaces.MenuItem;

public class DecoratoreTopping extends DecoratorePizza{
	
	private String topping;
    private double prezzo;
	
    public DecoratoreTopping(MenuItem pizza, String topping, double prezzo) {
        super(pizza);
        this.topping = topping;
        this.prezzo = prezzo;
    }
    
    @Override
    public String getDescrizione() {
        return pizza.getDescrizione() + ", " + topping;
    }

    @Override
    public double getPrezzo() {
        return pizza.getPrezzo() + prezzo;
    }

}
