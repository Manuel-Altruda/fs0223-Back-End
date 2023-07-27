package com.epicode.GodfathersPizza.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.epicode.GodfathersPizza.classes.DrinkLemonade;
import com.epicode.GodfathersPizza.classes.Ordine;
import com.epicode.GodfathersPizza.classes.PizzaMargherita;
import com.epicode.GodfathersPizza.classes.PizzaSalami;
import com.epicode.GodfathersPizza.classes.Tavolo;
import com.epicode.GodfathersPizza.classes.Water;
import com.epicode.GodfathersPizza.serivices.OrdineService;

@Component
public class OrdineRunner implements CommandLineRunner {
	
	@Autowired OrdineService os;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Run.. OrdineRunner");
		
		Tavolo t1 = os.creaTavolo(1, 4);
		Tavolo t2 = os.creaTavolo(2, 6);
		Tavolo t3 = os.creaTavolo(3, 2);
		
		Ordine o1 = os.creaOrdine(1, 3, t1);
		
		PizzaMargherita pm = (PizzaMargherita) os.getMenu().getMenuPizza().get(0);
		PizzaSalami ps = (PizzaSalami) os.getMenu().getMenuPizza().get(2);
		DrinkLemonade dlem = (DrinkLemonade) os.getMenu().getMenuDrink().get(0);
		Water wa = (Water) os.getMenu().getMenuDrink().get(1);
		o1.addMeunuItem(pm);
		o1.addMeunuItem(pm);
		o1.addMeunuItem(dlem);
		o1.addMeunuItem(ps);
		o1.addMeunuItem(wa);
		o1.addMeunuItem(wa);
		
		System.out.println(o1);
		o1.getTotale();
		
	}

}
