package com.ExsSpring.classes;

import com.ExsSpring.interfaces.Pizza;

public abstract class DecoratorePizza implements Pizza {
	
	protected Pizza pizza;

	 public DecoratorePizza(Pizza pizza) {
	        this.pizza = pizza;
	    }
}
