package org.generation.italy.eventi;

import java.time.LocalDate;

public class Evento {
	// attributi
	private String titolo;
	private LocalDate data;
	private int postiTot;
	private int postiPrenotati;
	
	
	// costruttore
	public Evento(String titolo, LocalDate data, int postiTot) throws Exception {
		
		if(postiTot > 0) {
			this.postiTot = postiTot;
		} else {
			throw new Exception("Errore: il valore non è valido");
		}
		
		this.titolo = titolo;
		this.data = LocalDate.now();
		this.postiPrenotati = 0;
		
	}
	
	
	// getter & setter
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPostiTot() {
		return postiTot;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	
	// metodi
	public prenota
	
	
	
}
