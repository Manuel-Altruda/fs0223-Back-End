package com.ExSpringG3.classes;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ordine {
    private int orderId;
    private Tavolo table;
    private List<OggettiOrdine> orderItems;
    private double totalAmount;
    
    
	public int getOrderId() {
		return orderId;
	}
	public Tavolo getTavolo() {
		return table;
	}
	public List<OggettiOrdine> getOggettiOrdine() {
		return orderItems;
	}
	public double getContoTotale() {
		return totalAmount;
	}
	public void setContoTotale(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
    
}
