package com.ExSpringG3.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Menu {
	private List<MenuItem> menuItems;

    @Autowired
    public Menu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Autowired
    @Value("${table.cost}")
    private double tableCost;

    public void printMenu() {
        System.out.println("------- GodFather's Pizza Menu -------");
        for (MenuItem item : menuItems) {
            System.out.println(item.getName() + " - $" + item.getPrice());
            if (item instanceof Pizza) {
                Pizza pizza = (Pizza) item;
                System.out.println("Base Ingredients: " + String.join(", ", pizza.getIngredientiBase()));
                System.out.println("Additional Toppings: " + String.join(", ", pizza.getToppingAggiuntivi()));
                System.out.println("Named Combinations: " + pizza.getCombinazioneNomi());
                System.out.println("Size Price Modifiers: " + pizza.getSizePriceModifiers());
            } else if (item instanceof Drink) {
                Drink drink = (Drink) item;
                System.out.println("Nutritional Information: " + drink.getInformazioniNutrizionali());
            }
            System.out.println("------------------------------------");
        }
    }

    public MenuItem findMenuItemByName(String name) {
        for (MenuItem item : menuItems) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public double getCostoTavolo() {
        return tableCost;
    }
}

