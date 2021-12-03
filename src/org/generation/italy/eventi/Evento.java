package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
		
		if(data.isAfter(LocalDate.now())) {
			this.data = data;
		} else {
			throw new Exception("Errore: data non valida");
		}
		
		this.titolo = titolo;
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
	public void prenota() throws Exception {
		if(data.isBefore(LocalDate.now())) {
			throw new Exception("Errore: data non valida");
		} else if(postiPrenotati == postiTot) {
			throw new Exception("Errore: non ci sono posti disponibili");
		} else {
			postiPrenotati++;
		}
	}
	
	public void disdici() throws Exception {
		if(data.isBefore(LocalDate.now())) {
			throw new Exception("Errore: data non valida");
		} else if(postiPrenotati == 0) {
			throw new Exception("Errore: non ci sono posti prenotati");
		} else {
			postiPrenotati--;
		}
	}


	@Override
	public String toString() {
		String dataFormattata;
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataFormattata = this.data.format(df);
		return dataFormattata + " - " + this.titolo;
	}
		
	
}
