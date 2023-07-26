package com.ExSpringG3.classes;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pizza extends MenuItem {
	private List<String> IngredientiBase;
    private List<String> ToppingAggiuntivi;
    private Map<String, Double> CombinazioneNomi;
    private Map<String, Double> sizePriceModifiers;
    
    
    
	public List<String> getIngredientiBase() {
		return IngredientiBase;
	}



	public List<String> getToppingAggiuntivi() {
		return ToppingAggiuntivi;
	}



	public Map<String, Double> getCombinazioneNomi() {
		return CombinazioneNomi;
	}



	public Map<String, Double> getSizePriceModifiers() {
		return sizePriceModifiers;
	}
    
    
	
}
