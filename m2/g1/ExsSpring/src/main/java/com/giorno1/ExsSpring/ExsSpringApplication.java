package com.giorno1.ExsSpring;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ExsSpring.classes.CustomPizzaDecoratore;
import com.ExsSpring.classes.DecoratoreFormatoFamiglia;
import com.ExsSpring.classes.DecoratoreTopping;
import com.ExsSpring.classes.Drink;
import com.ExsSpring.classes.Menu;
import com.ExsSpring.classes.Merchandise;
import com.ExsSpring.classes.PizzaDiBase;
import com.ExsSpring.interfaces.Pizza;

/*CLASSE BASE PER TUTTE LE PIZZE*/

@SpringBootApplication
public class ExsSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExsSpringApplication.class, args);
		
		System.out.println("Ciao Umberto Benevenuto nella Mia Pizzeria!");
		System.out.println("Jamm bell e scegli una pizza");
		
        Pizza pizzaBase = new PizzaDiBase();
        
        // Creazione dei topping
        Pizza pizzaWithTomato = new DecoratoreTopping(pizzaBase, "patatine + cheddar", 1.50);
        Pizza pizzaWithMozzarella = new DecoratoreTopping(pizzaWithTomato, "Mozzarella", 2.00);
        
        
        // Creazione delle pizze custom
        Pizza hawaiianPizza = new CustomPizzaDecoratore(pizzaWithTomato, "Hawaiian Pizza", 3.50);
       
        
        // Creazione delle pizze con formato famiglia
        Pizza familySizePizza = new DecoratoreFormatoFamiglia(pizzaBase, 5.00);
        // Altre pizze con formato famiglia
        
        // Creazione delle bevande
        Drink cola = new Drink("Cola", 2.00);
        Drink orangeJuice = new Drink("Succhio Di frutta", 2.50);
       
        
        // Creazione degli articoli di oggettistica
        Merchandise tShirt = new Merchandise("GodFather's Pizza T-Shirt", 15.99);
        Merchandise mug = new Merchandise("GodFather's Pizza cappello", 8.99);
        
        
        // Creazione del menu
        List<Pizza> pizzas = Arrays.asList(pizzaBase, pizzaWithTomato, pizzaWithMozzarella, hawaiianPizza, familySizePizza);
        List<Drink> drinks = Arrays.asList(cola, orangeJuice);
        List<Merchandise> merchandise = Arrays.asList(tShirt, mug);
        
        Menu menu = new Menu(pizzas, drinks, merchandise);
        menu.printMenu();
		
	}

}
