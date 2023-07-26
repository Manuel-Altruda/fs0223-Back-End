package com.ExSpringG3.classes;

import com.ExSpringG3.utils.StatoTavolo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tavolo {
	private int tableNumber;
    private int maxCapacity;
    private StatoTavolo status;
    
    
	public int getTableNumber() {
		return tableNumber;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public StatoTavolo getStatus() {
		return status;
	}
	
    
}
