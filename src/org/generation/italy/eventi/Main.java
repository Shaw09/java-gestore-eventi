package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean stop = false;
		String scelta;
		
		System.out.print("Inserire il nome dell`evento: ");
		String titolo = scan.nextLine();
		System.out.print("Inserire il numero di posti massimo che si vuole: ");
		int postiTot = scan.nextInt();

		System.out.print("Inserisci il giorno dell'evento: ");
        int giorno = scan.nextInt();
        System.out.print("Inserisci il mese: ");
        int mese = scan.nextInt();
        System.out.print("Inserisci l'anno: ");
        int anno = scan.nextInt();
        LocalDate data = LocalDate.of(anno, mese, giorno);
		
        int postiPrenotati = 0;
        
		try {
			Evento evento = new Evento(titolo, data, postiTot);
			
			System.out.println("Il tuo evento: " + titolo + " con " + postiTot + " disponibili è stato finalmente creato!" + " La data dell`evento è: " + data);
			
			do {
				System.out.print("Vuoi prenotare per l`evento? (s/n) ");
				scan.nextLine();
				scelta = scan.nextLine().toLowerCase();
				if(scelta.equals("s")) {
					System.out.print("Prego digitare il numero di prenotazioni: ");
					postiPrenotati = scan.nextInt();
					for(int i = 0; i < postiPrenotati; i++) {
						evento.prenota();
					}
					postiTot = postiTot - postiPrenotati;
					System.out.println("Il numero di posti prenotati è: " + postiPrenotati + " posti disponibili: " + postiTot);
					stop = true;
				} else if(scelta.equals("n")) {
					break;
				} else {
					System.out.println("Errore, inserire un valore valido (s/n)");
				}
			} while(stop == false);
			
			if(scelta.equals("n")) {
				System.out.println("Non hai prenotato");
			} else {
				do {
					System.out.print("Vuole disdire? (s/n)");
					scan.nextLine();
					scelta = scan.nextLine().toLowerCase();
					if(scelta.equals("s")) {
						System.out.print("Inserire il numero di posti che si vuole disdire: ");
						int numeroDisdetti = scan.nextInt();
						for(int i = 0; i < postiPrenotati; i++) {
							evento.disdici();
						}
						postiPrenotati = postiPrenotati - numeroDisdetti;
						postiTot = postiTot + numeroDisdetti;
						System.out.println("Il numero di posti prenotati è: " + postiPrenotati + " posti disponibili: " + postiTot);
						stop = true;
					} else if(scelta.equals("n")) {
						break;
					} else {
						System.out.print("Errore, inserire un valore valido (s/n)");
					}
				} while(stop == false);
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		scan.close();
	}

}
