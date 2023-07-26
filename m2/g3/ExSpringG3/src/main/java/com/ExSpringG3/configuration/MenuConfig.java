package com.ExSpringG3.configuration;

import java.awt.Menu;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;

import com.ExSpringG3.classes.Drink;
import com.ExSpringG3.classes.Merchandise;
import com.ExSpringG3.classes.OggettiOrdine;
import com.ExSpringG3.classes.Ordine;
import com.ExSpringG3.classes.Pizza;
import com.ExSpringG3.classes.ResponsabileOrdini;



@Configuration
public class MenuConfig {

    @Value("${costo.tavolo}")
    private String tableCost;

    @Bean
    public Menu menu() {
        return new Menu(tableCost);
    }

    @Bean
    @Scope("prototype")
    public Ordine order() {
        return new Ordine();
    }

    @Bean
    @Scope("prototype")
    public OggettiOrdine orderItem() {
        return new OggettiOrdine();
    }

    @Bean
    public Pizza margherita() {
        return Pizza.builder()
                .name("Margherita")
                .price(8.5)
                .baseIngredients(Arrays.asList("Tomato", "Mozzarella"))
                .additionalToppings(Arrays.asList("Ham", "Mushrooms", "Olives", "Pepperoni", "Anchovies"))
                .namedCombinations(Collections.singletonMap("Hawaiian Pizza", 2.0))
                .build();
    }

    @Bean
    public Drink coke() {
        return Drink.builder()
                .name("Coca-Cola")
                .price(2.5)
                .nutritionalInformation("Calories: 140")
                .build();
    }

    @Bean
    public Drink orangeJuice() {
        return Drink.builder()
                .name("Orange Juice")
                .price(2.0)
                .nutritionalInformation("Calories: 120")
                .build();
    }

    @Bean
    public Merchandise tShirt() {
        return Merchandise.builder()
                .name("GodFather's Pizza T-Shirt")
                .price(15.0)
                .build();
    }

    // Define other merchandise items here if needed

    // You can add more configuration for additional menu items

    @Bean
    public OggettiOrdine orderManager() {
        return new OggettiOrdine();
    }
}
