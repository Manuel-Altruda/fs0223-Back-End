package com.epicode.GodfathersPizza.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public abstract class Drink implements FoodItem {
	
	private String name;
	private Double price;
	private Double calories;

	public String getMenuLine() {
		return this.name + " - caloreis: " + this.calories + " - price: " + this.price;  
	}

}
