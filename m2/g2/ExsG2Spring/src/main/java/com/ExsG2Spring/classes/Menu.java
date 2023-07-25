package com.ExsG2Spring.classes;

import java.awt.MenuItem;
import java.util.List;

import com.ExsSpring.interfaces.Pizza;

public class Menu {
	
	private List<MenuItem> pizzas;
    private List<MenuItem> drinks;
    private List<MenuItem> merchandise;
    private double coperto;

    public Menu(List<MenuItem> pizzas, List<MenuItem> drinks, List<MenuItem> merchandise) {
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.merchandise = merchandise;
    }
    
    public double getPrezzoTotaleOrdine(Order order) {
        double totalAmount = 0.0;
        for (MenuItem item : order.getItems()) {
            totalAmount += ((Pizza) item).getPrezzo();
        }
        totalAmount += order.getTable().isOccupied() ? coperto : 0.0;
        order.setTotalAmount(totalAmount);
        return totalAmount;
    }
    
    public CustomPizzaDecoratore createPizza(String name, double price) {
        return new CustomPizzaDecoratore((com.ExsG2Spring.interfaces.MenuItem) getPizzaBase(), name, price);
    }
    
    public MenuItem getPizzaBase() {
        return (MenuItem) pizzas.get(0);
    }
    

    public void printMenu() {
        System.out.println("===== PIZZE =====");
        for (MenuItem pizza : pizzas) {
            System.out.println(((Pizza) pizza).getDescrizione() + " - Price: $" + ((Pizza) pizza).getPrezzo());
        }

        System.out.println("\n===== DRINKS =====");
        for (MenuItem drink : drinks) {
            System.out.println(drink.getName() + " - Price: $" + ((Pizza) drink).getPrezzo());
        }

        System.out.println("\n===== MERCHANDISE =====");
        for (MenuItem item : merchandise) {
            System.out.println(item.getName() + " - Price: $" + ((Pizza) item).getPrezzo());
        }
        
        }

	public List<MenuItem> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<MenuItem> pizzas) {
		this.pizzas = pizzas;
	}

	public List<MenuItem> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<MenuItem> drinks) {
		this.drinks = drinks;
	}

	public List<MenuItem> getMerchandise() {
		return merchandise;
	}

	public void setMerchandise(List<MenuItem> merchandise) {
		this.merchandise = merchandise;
	}

	public double getCoperto() {
		return coperto;
	}

	public void setCoperto(double coperto) {
		this.coperto = coperto;
	}

	public Order createOrder(Table table) {
        return new Order(table);
    }

	public double calculateTotalPriceForOrder(Order order) {
		// TODO Auto-generated method stub
		return 0;
	}
        
        
	
}
