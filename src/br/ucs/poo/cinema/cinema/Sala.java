package br.ucs.poo.cinema.cinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sala implements Serializable{
	private int numero;
	private List<Assento> assentos = new ArrayList<>();
	
	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Sala() {
		
	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	/*---- Methods ---------------------------------------------------------------------------------- */
	
	
}
