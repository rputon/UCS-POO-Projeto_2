package br.ucs.poo.cinema.cinema;

import java.util.Date;

public class Horario {
	private Date data;
	private double hora;
	private Sala numero;

	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Horario() {

	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getHora() {
		return hora;
	}

	public void setHora(double hora) {
		this.hora = hora;
	}

	public Sala getNumero() {
		return numero;
	}

	public void setNumero(Sala numero) {
		this.numero = numero;
	}

	/*---- Methods ---------------------------------------------------------------------------------- */
}
