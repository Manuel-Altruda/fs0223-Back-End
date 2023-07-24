package com.ExsSpring.classes;

import com.ExsSpring.interfaces.Pizza;

public class PizzaDiBase implements Pizza{
	
	
	@Override
	public String getDescrizione() {
		return "Pizza Margherita (Pomodoro, Mozzarella)";
	}

	@Override
	public double getPrezzo() {
		return 4.50;
	}
	
}
