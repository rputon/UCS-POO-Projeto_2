package br.ucs.poo.cinema.cinema;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Horario implements Serializable {
	private Date data;
	private LocalTime hora;
	private Sala numero;

	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Horario(Date data, LocalTime hora, Sala numero) {
		setData(data);
		setHora(hora);
		setNumero(numero);
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
	public String toString() {
		String pattern = "dd/MM/yyyy";
		DateFormat df = new SimpleDateFormat(pattern);
		String formated = df.format(data);
		return String.format("%s %s", formated, hora.toString());
	}
}
