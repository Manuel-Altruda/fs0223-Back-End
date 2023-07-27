package com.epicode.GodfathersPizza.classes;

import java.util.ArrayList;
import java.util.List;



import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;

@Getter

public class Menu {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
	
	private List<PizzaBase> menuPizza = new ArrayList<PizzaBase>();
	private List<Drink> menuDrink = new ArrayList<Drink>();

}
