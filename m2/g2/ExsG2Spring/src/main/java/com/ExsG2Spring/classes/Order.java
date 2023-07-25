package com.ExsG2Spring.classes;

import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Order {
	private Table table;
    private List<MenuItem> items;
    private Map<MenuItem, String> itemNotes;
    private double totalAmount;
    
	public Order(Table table) {
		super();
		this.table = table;
		this.items = new ArrayList<>();
		this.itemNotes = new HashMap<>();
		this.totalAmount = 0.0;
	}

	 public Table getTable() {
	        return table;
	    }

	    public List<MenuItem> getItems() {
	        return items;
	    }

	    public void addItem(CustomPizzaDecoratore hawaiianPizza) {
	        items.addAll((Collection<? extends MenuItem>) hawaiianPizza);
	    }

	    public void addNoteToItem(MenuItem item, String note) {
	        itemNotes.put(item, note);
	    }

	    public Map<MenuItem, String> getItemNotes() {
	        return itemNotes;
	    }

	    public double getTotalAmount() {
	        return totalAmount;
	    }

	    public void setTotalAmount(double totalAmount) {
	        this.totalAmount = totalAmount;
	    }
	
}
