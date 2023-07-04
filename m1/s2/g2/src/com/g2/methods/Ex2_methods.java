package com.g2.methods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Ex2_methods {
	List<Integer> list = new ArrayList<>();
	Set<Integer> set1 = new HashSet<>(list);
	List<Integer> listaCombinata = new ArrayList<>(list);
	Set<Integer> set2 = new HashSet<>(listaCombinata);
	
	public List<Integer> generateRandomList(int N) {
		
		List<Integer> randomList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			
			int randomNumber = (int) (Math.random() * 101);
			randomList.add(randomNumber);
		}
		Collections.sort(randomList);
		return randomList;
		
	} 
	
	public List<Integer> listaInvertita(List<Integer> listaCombinata) {
		
		Collections.reverse(list);
		listaCombinata.addAll(list);
		return listaCombinata;
	}
	
	public List<Integer> stampaPosizioni(boolean stampaPosizione) {
		System.out.print("Valori in Posizioni: ");
		if (stampaPosizione) {
			System.out.println("pari: ");
			for(int i = 0; i < list.size(); i += 2) {
				System.out.println(list.get(i));
			}
		} else {
			System.out.println("dispari: ");
			for(int i = 0; i < list.size(); i += 2) {
				System.out.println(list.get(i));
			}
		}
		return list;
	}

}
