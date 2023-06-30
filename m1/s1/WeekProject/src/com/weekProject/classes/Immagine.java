package com.weekProject.classes;

public class Immagine extends ElementoMultimediale {
	
	private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    @Override
    public void play() {
        // Immagine non riproducibile, quindi non fa nulla
    }

    @Override
    public void show() {
        for (int i = 0; i < luminosita; i++) {
            System.out.print("*");
        }
        System.out.println(getTitolo());
    }

    @Override
    public void esegui() {
        show();
    }
}
