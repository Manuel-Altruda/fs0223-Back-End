package com.giorno3.ExSpringG3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ExSpringG3.classes.Menu;
import com.ExSpringG3.classes.Ordine;
import com.ExSpringG3.classes.ResponsabileOrdini;
import com.ExSpringG3.classes.Tavolo;
import com.ExSpringG3.utils.StatoTavolo;

@SpringBootApplication
@ComponentScan(basePackages = "com.ExSpringG3.classes")
@ComponentScan(basePackages = "com.ExSpringG3.utils")
@ComponentScan(basePackages = "com.ExSpringG3.configuration")
public class ExSpringG3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExSpringG3Application.class, args);
	}
	
	private Menu menu;
    private ResponsabileOrdini responsabileOrdini;
    
    public ExSpringG3Application(Menu menu, ResponsabileOrdini ro) {
    	this.menu = menu;
    	this.responsabileOrdini  = ro;
    }
    
    
	@Override
	public void run(String... args) throws Exception {
		menu.printMenu();
		Tavolo t = customUserProvider.getObject();
		// Creare un tavolo di esempio
        Tavolo table1 = table1.builder()
                .tableNumber(1)
                .maxCapacity(4)
                .status(StatoTavolo.FREE)
                .build();

        // Creare un ordine di esempio
        Ordine order1 = Ordine.builder()
                .orderId(1)
                .table(table1)
                .build();

        // Aggiungere alcuni elementi del menu all'ordine
        responsabileOrdini.addItemToOrder(order1, "Margherita", "senza cipolla");
        responsabileOrdini.addItemToOrder(order1, "Hawaiian Pizza", "Con patatine");

        // Calcolare l'importo totale dell'ordine
        responsabileOrdini.calculateTotalAmount(order1);

        // Stampare l'ordine a video
        responsabileOrdini.printOrder(order1);
    }
    
}
