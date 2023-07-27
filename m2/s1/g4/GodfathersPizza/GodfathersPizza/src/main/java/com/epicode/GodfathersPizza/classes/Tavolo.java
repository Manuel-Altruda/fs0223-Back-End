package com.epicode.GodfathersPizza.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tavolo {
	
	private Integer numero;
	private Integer numeroMassimoCoperti;
	private Boolean occupato = false;

}
