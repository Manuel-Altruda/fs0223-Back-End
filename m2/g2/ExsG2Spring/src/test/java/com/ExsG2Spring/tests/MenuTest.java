package com.ExsG2Spring.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ExsG2Spring.classes.CustomPizzaDecoratore;
import com.ExsG2Spring.classes.Menu;
import com.ExsG2Spring.classes.Order;
import com.ExsG2Spring.classes.Table;
import com.ExsG2Spring.interfaces.MenuItem;
import com.ExsG2Spring.interfaces.Pizza;

class MenuTest {

	private Menu menu;

    @Test
    public void testTotalPriceForOrder() {
        MenuItem pizzaMargherita = (MenuItem) menu.getPizzaBase();
        MenuItem hawaiianPizza = new CustomPizzaDecoratore((MenuItem) pizzaMargherita, "Hawaiian Pizza", 3.50);

        Order order = new Order(new Table(1, 4, true));
//        order.addItem((java.awt.MenuItem) pizzaMargherita);
//        order.addItem((java.awt.MenuItem) hawaiianPizza);

        double totalPrice = menu.getPrezzoTotaleOrdine(order);
        double expectedTotalPrice = pizzaMargherita.getPrezzo() + hawaiianPizza.getPrezzo() + menu.getCoperto();

        assertEquals(expectedTotalPrice, totalPrice, 0.01);
    }
}




