package com.ExsSpring.classes;

public class Drink {
	
	 private String nome;
	 private double prezzo;

	 public Drink(String nome, double prezzo) {
	     this.nome = nome;
	     this.prezzo = prezzo;
	 }

	 public String getName() {
	     return nome;
	 }

	 public double getPrice() {
	     return prezzo;
	 }
	
}
