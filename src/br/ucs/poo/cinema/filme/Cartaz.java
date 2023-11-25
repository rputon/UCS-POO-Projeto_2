package br.ucs.poo.cinema.filme;

import java.util.Date;

import br.ucs.poo.cinema.cinema.Horario;
import br.ucs.poo.cinema.cinema.Sala;

public class Cartaz extends Filme {
	private Horario hora;
	private Sala sala;
	private Date time;
	// TODO: Se tiver em cartaz, tem tempo para "expirar"

	public Cartaz(String nome, int ano, int timeMin, String descricao, Rating rating, Genero genero, Sala sala,
			Horario hora) {
		super(nome, ano, timeMin, descricao, rating, genero);
		setSala(sala);
		setHora(hora);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getTimeMin() {
		return timeMin;
	}

	public void setTimeMin(int timeMin) {
		this.timeMin = timeMin;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Horario getHora() {
		return hora;
	}

	public void setHora(Horario hora) {
		this.hora = hora;
	}
}
