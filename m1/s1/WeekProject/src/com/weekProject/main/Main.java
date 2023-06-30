package com.weekProject.main;

import java.util.Scanner;

import com.weekProject.classes.ElementoMultimediale;
import com.weekProject.classes.Immagine;
import com.weekProject.classes.RegistrazioneAudio;
import com.weekProject.classes.Riproducibile;
import com.weekProject.classes.Video;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        // Creazione degli elementi multimediali
        for (int i = 0; i < 5; i++) {
            System.out.print("Inserisci il titolo dell'elemento: ");
            String titolo = scanner.nextLine();

            System.out.print("Inserisci la durata dell'elemento: ");
            int durata = Integer.parseInt(scanner.nextLine());

            System.out.print("Inserisci il tipo di elemento (1 = Registrazione Audio, 2 = Video, 3 = Immagine): ");
            int tipo = Integer.parseInt(scanner.nextLine());

            if (tipo == 1) {
                System.out.print("Inserisci il volume della registrazione audio: ");
                int volume = Integer.parseInt(scanner.nextLine());

                elementi[i] = new RegistrazioneAudio(titolo, durata, volume);
            } else if (tipo == 2) {
                System.out.print("Inserisci il volume del video: ");
                int volume = Integer.parseInt(scanner.nextLine());

                System.out.print("Inserisci la luminosita del video: ");
                int luminosita = Integer.parseInt(scanner.nextLine());

                elementi[i] = new Video(titolo, durata, volume, luminosita);
            } else if (tipo == 3) {
                System.out.print("Inserisci la luminosita dell'immagine: ");
                int luminosita = Integer.parseInt(scanner.nextLine());

                elementi[i] = new Immagine(titolo, luminosita);
            }
        }

        int scelta;
        do {
            System.out.println("Quale elemento vuoi eseguire? (1-5, 0 per terminare)");
            scelta = Integer.parseInt(scanner.nextLine());

            if (scelta >= 1 && scelta <= 5) {
                ElementoMultimediale elemento = elementi[scelta - 1];
                if (elemento instanceof Riproducibile) {
                    ((Riproducibile) elemento).play();
                } else if (elemento instanceof Immagine) {
                    ((Immagine) elemento).show();
                }
            }
        } while (scelta != 0);

        scanner.close();
    }

}
