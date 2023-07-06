package com.giorno4.classes;

public class Product {
	private Long id;
	private String name;
	private String category;
	private Double price;
	private Double scontoPrezzo;
	
	public Product(Long id, String name, String category, Double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public Double getPrice() {
		return price;
	}
	

	public void setPrice(double scontoPrezzo) {
		this.scontoPrezzo = scontoPrezzo;
		
	}
}
