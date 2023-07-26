package com.ExSpringG3.classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem {
    private String name;
    private double price;
    
	public String getName() {
		
		return name;
	}

	public double getPrice() {
		return price;
	}
}
