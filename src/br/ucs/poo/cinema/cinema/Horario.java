package br.ucs.poo.cinema.cinema;

import java.time.LocalDate;
import java.time.LocalTime;

public class Horario {
	private LocalDate data;
	private LocalTime hora;
	private Sala numero;

	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Horario(LocalDate data, LocalTime hora) {
		setData(data);
		setHora(hora);
	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
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
