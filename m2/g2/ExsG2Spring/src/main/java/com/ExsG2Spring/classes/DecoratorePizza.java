package com.ExsG2Spring.classes;

import com.ExsG2Spring.interfaces.MenuItem;

public abstract class DecoratorePizza implements MenuItem {
	
	protected MenuItem pizza;

	 public DecoratorePizza(MenuItem pizza) {
	        this.pizza = pizza;
	    }
	 
	 @Override
	    public String getDescrizione() {
	        return pizza.getDescrizione();
	    }

	    @Override
	    public double getPrezzo() {
	        return pizza.getPrezzo();
	    }
}
