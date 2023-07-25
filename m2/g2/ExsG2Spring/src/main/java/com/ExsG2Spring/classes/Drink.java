package com.ExsG2Spring.classes;

import com.ExsG2Spring.interfaces.MenuItem;

public class Drink implements MenuItem {
	
	 private String nome;
	 private double prezzo;

	 public Drink(String nome, double prezzo) {
	     this.nome = nome;
	     this.prezzo = prezzo;
	 }
	 
	
	  public String getDescrizione() {
	      return nome;
	  }

	  
	   public String getNome() {
		    return nome;
		}
	    
	   	public double getPrezzo() {
	        return prezzo;
	    }
	 
	 

	 
	
}
