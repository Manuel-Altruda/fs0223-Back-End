package com.ExSpringG3.classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OggettiOrdine {
	private MenuItem menu;
    private String note;
    
    
	public MenuItem getMenuItem() {
		return menu;
	}
	public String getNote() {
		return note;
	}
	
}
