package com.giorno4.main;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.giorno4.classes.Customer;
import com.giorno4.classes.Order;
import com.giorno4.classes.Product;

public class Main {

	public static void main(String[] args) {
		// Creazione dei prodotti
		Product product0 = new Product(0L, "Libro 1", "Libri", 50.0);
		Product product1 = new Product(1L, "Libro 2", "Libri", 80.0);
		Product product2 = new Product(2L, "Giocattolo 1", "Giocattoli", 150.0);
		Product product3 = new Product(3L, "Giocattolo 2", "Giocattoli", 120.0);
		Product product4 = new Product(4L, "Libro 3", "Libri", 200.0);
		
		//Creazione dei clienti
		Customer customer0 = new Customer(0L, "Pippo Baudo", 1);
		Customer customer1 = new Customer(1L, "Mast3rm", 2);
		Customer customer2 = new Customer(2L, "CiccioGamer", 2);
		
		//Creazione degli ordini
		Order order0 = new Order(0L, "Consegnato", LocalDate.of(2021, 3, 10), LocalDate.of(2021, 2, 01),
				Arrays.asList(product0, product3), customer0);
		
		Order order1 = new Order(0L, "Consegnato", LocalDate.of(2022, 5, 20), LocalDate.of(2022, 5, 25),
				Arrays.asList(product1, product4), customer1);
		
		Order order2 = new Order(0L, "Consegnato", LocalDate.of(2023, 1, 5), LocalDate.of(2023, 1, 10),
				Arrays.asList(product0, product2, product4), customer2);
		
		/*--- ESERCIZIO 1 ---*/
		List<Product> expensiveBooks = Arrays.asList(product0, product4)
				.stream()
				.filter(product -> product.getCategory().equals("Libri"))
				.filter(product -> product.getPrice() > 100)
				.collect(Collectors.toList());
		
		System.out.println("Esercizio 1: Prodotti della categoria \"Libri\" con prezzo > 100");
		
		for (Product product : expensiveBooks) {
			System.out.println(product.getName());
		}		
		/*--- FINE ESERCIZIO 1 ---*/
		
		/*--- ESERCIZIO 2 ---*/
		
		List<Order> babyOrders = Arrays.asList(order0, order1, order2)
				.stream()
				.filter(order -> order.getProducts()
				.stream()
				.anyMatch(product -> product.getCategory()
				.equals("Baby")))
				.collect(Collectors.toList());
		
		System.out.println("Esercizio 2: Ordini con prodotti della categoria Baby");
		for (Order order : babyOrders) {
			System.out.println("Ordine ID: " + order.getId());
		}
		/*--- FINE ESERCIZIO 2 ---*/
		
		/*--- ESERCIZIO 3 ---*/
		List<Product> scontoProdottiRagazzi = Arrays.asList(product2, product3)
				.stream()
				.filter(product -> product.getCategory().equals("Boys"))
				.map(product -> {
					double scontoPrezzo = product.getPrice() * 0.9;
					product.setPrice(scontoPrezzo);
					return product;
				})
				.collect(Collectors.toList());
		
		System.out.println("Esercizio 3: Prodotti della categoria Boys con sconto del 10%");
		for (Product product : scontoProdottiRagazzi) {
			System.out.println(product.getName() + "Prezzo scontato: " + product.getPrice());
		}
		/*--- FINE ESERCIZIO 3 ---*/
		
		/*--- ESERCIZIO 4 ---*/
		LocalDate startDate = LocalDate.of(2021, 2, 1);
		LocalDate endDate = LocalDate.of(2021, 4, 1);
		
		List<Product> tierOrderedProducts = Arrays.asList(order0, order1, order2)
				.stream()
				.filter(order -> order.getCustomer().getTier() == 2)
				.filter(order -> order.getOrderDate().isAfter(startDate) && order.getOrderDate().isBefore(endDate))
				.flatMap(order -> order.getProducts().stream())
				.collect(Collectors.toList());
		
		System.out.println("Esercizio 4: Prodotti ordinati dai clienti di tier 2 tra il 01-Feb-2021 e il 01-Apr-2021");
		for(Product product : tierOrderedProducts) {
			System.out.println(product.getName());
		}
		/*--- FINE ESERCIZIO 4 ---*/
	}

	
}
