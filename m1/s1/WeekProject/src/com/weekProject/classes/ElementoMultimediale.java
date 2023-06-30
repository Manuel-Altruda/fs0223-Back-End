package com.weekProject.classes;

public abstract class ElementoMultimediale {
	
	private String titolo;
	
	public ElementoMultimediale(String titolo) {
		this.titolo = titolo;
	}
	
	public String getTitolo() {
		return titolo;
	}
	
	public abstract void esegui();
	public abstract void play();
	public abstract void show();

}
