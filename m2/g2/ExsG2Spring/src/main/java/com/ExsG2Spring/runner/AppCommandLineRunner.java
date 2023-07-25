package com.ExsG2Spring.runner;

import java.awt.MenuItem;
import java.util.Arrays;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ExsG2Spring.classes.CustomPizzaDecoratore;
import com.ExsG2Spring.classes.Drink;
import com.ExsG2Spring.classes.Menu;
import com.ExsG2Spring.classes.Merchandise;
import com.ExsG2Spring.classes.Order;
import com.ExsG2Spring.classes.PizzaDiBase;
import com.ExsG2Spring.classes.Table;
import com.ExsG2Spring.interfaces.Pizza;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

    private final Menu menu;
    private final Logger logger;

   
    public AppCommandLineRunner(Menu menu, Logger logger) {
        this.menu = menu;
        this.logger = logger;
    }

    @Override
    public void run(String... args) {
        Order order = menu.createOrder(new Table(1, 4, true));

        MenuItem pizzaMargherita = menu.getPizzaBase();
        CustomPizzaDecoratore hawaiianPizza = menu.createPizza("Hawaiian Pizza", 3.50);
        Drink coke = new Drink("Coca-Cola", 2.0);
        Merchandise tShirt = new Merchandise("GodFather's Pizza T-Shirt", 15.0);

//        order.addItem(pizzaMargherita);
//        order.addItem(hawaiianPizza);
//        order.addItem(coke);
//        order.addItem(tShirt);
//        order.addNoteToItem(hawaiianPizza, "No pineapple, extra ham");

        double totalAmount = menu.calculateTotalPriceForOrder(order);
        order.setTotalAmount(totalAmount);

        logger.info("Order Details:");
        logger.info("Table Number: " + order.getTable().getTableNumber());
        logger.info("Items:");
        for (MenuItem item : order.getItems()) {
            String note = order.getItemNotes().getOrDefault(item, "");
            logger.info(((com.ExsG2Spring.interfaces.MenuItem) item).getDescrizione() + " - Price: $" + ((com.ExsG2Spring.interfaces.MenuItem) item).getPrezzo() + " - Note: " + note);
        }
        logger.info("Cover Charge: $" + menu.getCoperto());
        logger.info("Total Amount: $" + totalAmount);
    }
}
