package br.ucs.poo.cinema.cinema;

import java.time.LocalTime;
import java.util.Date;

public class Horario {
	private Date data;
	private LocalTime hora;
	private Sala numero;

	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Horario(Date data, LocalTime hora) {
		setData(data);
		setHora(hora);
	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
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
