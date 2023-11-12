package br.ucs.poo.cinema.filme;

import br.ucs.poo.cinema.cinema.Horario;

public class Filme {
	private String nome;
	private int ano;
	private int timeMin;
	private String descricao;
	private Rating rating;
	private Horario hora;
	
	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Filme(String nome, int ano, int timeMin, String descricao, int rating) {
		setNome(nome);
		setAno(ano);
		setTimeMin(timeMin);
		setDescricao(descricao);
		setRating(rating);
	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */
	public String getNome() {
		return nome;
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
	
	public Horario getHora() {
		return hora;
	}
	
	public void setHora(Horario hora) {
		this.hora = hora;
	}

	public int getRating() {
		return rating.getIdade();
	}

	public void setRating(int rating) {
		this.rating = new Rating();
		this.rating.setIdade(rating);
	}
	
	/*---- Methods ---------------------------------------------------------------------------------- */
	public String toString(){
		return String.format("Filme: %s ");
	}

}
