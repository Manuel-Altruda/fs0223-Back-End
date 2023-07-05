package com.giorno3.classes;

public class Presenza {
	private String nome;
	private int giorniPresenza;
	
	
	public Presenza(String nome, int giorniPresenza) {
		this.nome = nome;
		this.giorniPresenza = giorniPresenza;
	}

	public int getGiorniPresenza() {
		return giorniPresenza;
	}

	public String getNome() {
		return nome;
	}

}
