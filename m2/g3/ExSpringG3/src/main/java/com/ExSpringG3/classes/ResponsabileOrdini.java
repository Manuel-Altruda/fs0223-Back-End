package com.ExSpringG3.classes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponsabileOrdini {
	 private List<Ordine> orders;

	    @Autowired
	    private Menu menu;

	    @Autowired
	    public ResponsabileOrdini() {
	        this.orders = new ArrayList<>();
	    }

	    public void addItemToOrder(Ordine order, String itemName, String note) {
	    	MenuItem menuItem = menu.findMenuItemByName(itemName);
	        if (menuItem != null) {
	            OggettiOrdine orderItem = OggettiOrdine.builder()
	                    .menuItem(menuItem)
	                    .note(note)
	                    .build();
	            order.getOggettiOrdine().add(orderItem);
	            System.out.println(itemName + " added to the order.");
	        } else {
	            System.out.println("Item not found in the menu.");
	        }
	    }

	    public void calculateTotalAmount(Ordine order) {
	        double totalAmount = 0;
	        for (OggettiOrdine orderItem : order.getOggettiOrdine()) {
	            totalAmount += orderItem.getMenuItem().getPrice();
	        }
	        totalAmount += order.getTavolo().getMaxCapacity() * menu.getCostoTavolo();
	        order.setContoTotale(totalAmount);
	    }

	    public void printOrder(Ordine order) {
	        System.out.println("------- Order -------");
	        System.out.println("Order ID: " + order.getOrderId());
	        System.out.println("Table Number: " + order.getTavolo().getTableNumber());
	        System.out.println("Table Capacity: " + order.getTavolo().getMaxCapacity());
	        System.out.println("Table Status: " + order.getTavolo().getStatus());
	        System.out.println("Items: ");
	        for (OggettiOrdine orderItem : order.getOggettiOrdine()) {
	            System.out.println(orderItem.getMenuItem().getName() + " - $" + orderItem.getMenuItem().getPrice());
	            if (!orderItem.getNote().isEmpty()) {
	                System.out.println("Note: " + orderItem.getNote());
	            }
	        }
	        System.out.println("Total Amount: $" + order.getContoTotale());
	        System.out.println("---------------------");
	    }
}
