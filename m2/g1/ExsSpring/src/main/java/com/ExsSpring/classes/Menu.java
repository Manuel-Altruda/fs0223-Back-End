package com.ExsSpring.classes;

import java.util.List;

import com.ExsSpring.interfaces.Pizza;

public class Menu {
	
	private List<Pizza> pizzas;
    private List<Drink> drinks;
    private List<Merchandise> merchandise;

    public Menu(List<Pizza> pizzas, List<Drink> drinks, List<Merchandise> merchandise) {
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.merchandise = merchandise;
    }

    public void printMenu() {
        System.out.println("===== PIZZE =====");
        for (Pizza pizza : pizzas) {
            System.out.println(pizza.getDescrizione() + " - Price: $" + pizza.getPrezzo());
        }

        System.out.println("\n===== DRINKS =====");
        for (Drink drink : drinks) {
            System.out.println(drink.getName() + " - Price: $" + drink.getPrice());
        }

        System.out.println("\n===== MERCHANDISE =====");
        for (Merchandise item : merchandise) {
            System.out.println(item.getName() + " - Price: $" + item.getPrice());
        }
    }
	
}
