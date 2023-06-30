package com.weekProject.classes;

public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile{
	
	 private int durata;
	    private int volume;

	    public RegistrazioneAudio(String titolo, int durata, int volume) {
	        super(titolo);
	        this.durata = durata;
	        this.volume = volume;
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
	            System.out.println(getTitolo());
	        }
	    }

	    public void abbassaVolume() {
	        if (volume > 0) {
	            volume--;
	        }
	    }

	    public void alzaVolume() {
	        volume++;
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
