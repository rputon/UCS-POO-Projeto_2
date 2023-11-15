package br.ucs.poo.cinema.cinema;

import java.io.Serializable;

public class Sala implements Serializable{
	private int numero;
	private Assento assentos;
	
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

	public Assento getAssentos() {
		return assentos;
	}

	public void setAssentos(Assento assentos) {
		this.assentos = assentos;
	}
	
	/*---- Methods ---------------------------------------------------------------------------------- */
	
	
}
