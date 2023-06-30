package com.weekProject.classes;

public class Video extends ElementoMultimediale implements Riproducibile {
	private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    @Override
    public int getDurata() {
        return durata;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            for (int j = 0; j < volume; j++) {
                System.out.print(".");
            }
            for (int j = 0; j < luminosita; j++) {
                System.out.print("*");
            }
            System.out.println(getTitolo());
        }
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        if (luminosita > 0) {
            luminosita--;
        }
    }

    @Override
    public void show() {
        play();
    }

    @Override
    public void esegui() {
        play();
    }
}
