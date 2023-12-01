package br.ucs.poo.cinema.cinema;

import java.io.Serializable;

public class Assento implements Serializable{
	private char fileira;
	private int numero;
	private int salaNumber;
	private boolean reserva;

	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Assento(int sala, char f, int n ) {
		setFileira(f);
		setNumero(n);
		setSalaNumber(sala);
		setReserva(false);
	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */
	public char getFileira() {
		return fileira;
	}

	public void setFileira(char fileira) {
		this.fileira = fileira;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getSalaNumber() {
		return salaNumber;
	}

	public void setSalaNumber(int salaNumber) {
		this.salaNumber = salaNumber;
	}

	public void setReserva(boolean b){
		this.reserva = b;
	}

	public Boolean getReserva (){
		return this.reserva;
	}

	/*---- Methods ---------------------------------------------------------------------------------- */

	public String toString(){
		return String.format("%s %d",Character.toString(fileira), numero);
 
	}
}
