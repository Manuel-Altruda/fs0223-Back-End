package com.epicode.GodfathersPizza.serivices;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.GodfathersPizza.repository.MenuRepository;
import com.epicode.GodfathersPizza.classes.Menu;

@Service
public class MenuService {
	
	private final MenuRepository menuRepository;

	 
	    public MenuService(MenuRepository menuRepository) {
	        this.menuRepository = menuRepository;
	    }
	
	 	// Metodo per salvare un nuovo menu
	    public Menu saveMenu(Menu menu) {
	        return menuRepository.save(menu);
	    }

	    // Metodo per recuperare un menu per ID
	    public Menu getMenuById(Long id) {
	        return menuRepository.findById(id).orElse(null);
	    }
	 
	@Autowired  private ObjectProvider<Menu> menuProvider;

	public void stampaMenu() {
		System.out.println("***** Menu *****");
		System.out.println("Pizzas");
		
		menuProvider.getObject().getMenuPizza().forEach(p -> System.out.println(p.getMenuLine()));
		
		System.out.println();
		
		System.out.println("Drink");
		
		menuProvider.getObject().getMenuDrink().forEach(d -> System.out.println(d.getMenuLine()));
		
		System.out.println();
		
		System.out.println("***** FINE *****");
		
	}

}
