package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		boolean stop = false;
		boolean errore = false;
		String scelta;
		
		System.out.print("Inserire il nome dell`evento: ");
		String titolo = scan.nextLine();
		System.out.print("Inserire il numero di posti massimo che si vuole: ");
		int postiTot = scan.nextInt();
//		System.out.print("Inserire la data dell`evento: ");
//		String date = scan.nextLine();
	
//		LocalDate data = LocalDate.parse(date);
//		System.out.println(data);
		
		System.out.print("Inserisci il giorno dell'evento: ");
        int giorno = scan.nextInt();
        System.out.print("Inserisci il mese: ");
        int mese = scan.nextInt();
        System.out.print("Inserisci l'anno: ");
        int anno = scan.nextInt();
        LocalDate data = LocalDate.of(anno, mese, giorno);
		
		try {
			Evento evento = new Evento(titolo, data, postiTot);
			
			System.out.println("Il tuo evento: " + titolo + " con " + postiTot + " disponibili è stato finalmente creato!" + " La data dell`evento è: " + data);
			
			do {
				System.out.print("Vuoi prenotare per l`evento? (s/n) ");
				scan.nextLine();
				scelta = scan.nextLine().toLowerCase();
				if(scelta.equals("s")) {
					stop = true;
				} else if(scelta.equals("n")) {
					main(args);
					break;
				} else {
					System.out.println("Errore, inserire un valore valido (s/n)");
				}
				
			} while(stop == false);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.print("Prego digitare il numero di prenotazioni: ");
		int postiPrenotati = scan.nextInt();
		postiTot = postiTot - postiPrenotati;
		System.out.println("Il numero di posti prenotati è: " + postiPrenotati + " posti disponibili: " + postiTot);
		
		do {
			System.out.print("Vuole disdire? (s/n)");
			scan.nextLine();
			scelta = scan.nextLine().toLowerCase();
			if(scelta.equals("s")) {
				System.out.print("Inserire il numero di posti che si vuole disdire: ");
				int numeroDisdetti = scan.nextInt();
				postiPrenotati = postiPrenotati - numeroDisdetti;
				postiTot = postiTot + numeroDisdetti;
				stop = true;
			} else if(scelta.equals("n")) {
				break;
			} else {
				System.out.print("Errore, inserire un valore valido (s/n)");
			}
		} while(stop == false);
		
		System.out.println("Il numero di posti prenotati è: " + postiPrenotati + " posti disponibili: " + postiTot);
		
		scan.close();
	}

}
