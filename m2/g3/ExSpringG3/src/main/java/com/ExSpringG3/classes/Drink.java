package com.ExSpringG3.classes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Drink extends MenuItem {
	private String informazioniNutrizionali;

	public String getInformazioniNutrizionali() {
		return informazioniNutrizionali;
	}
}
