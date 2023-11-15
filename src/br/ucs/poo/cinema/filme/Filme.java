package br.ucs.poo.cinema.filme;

import java.io.Serializable;

import br.ucs.poo.cinema.cinema.Horario;

public class Filme implements Serializable{
	private int cod;
	private String nome;
	private int ano;
	private int timeMin;
	private String descricao;
	private Rating rating;
	private Horario hora;
	private Genero genero;
	//TODO: Se tiver em cartaz, tem tempo para "expirar"
	
	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Filme(String nome, int ano, int timeMin, String descricao, int rating, String genero) {
		setNome(nome);
		setAno(ano);
		setTimeMin(timeMin);
		setDescricao(descricao);
		setRating(rating);
		setGenero(genero);
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

	public void setGenero(String genero){
		this.genero = new Genero();
		this.genero.setNome(genero);
	}
	
	/*---- Methods ---------------------------------------------------------------------------------- */
	public String toString(){
		return String.format("%s\n%d | %s | %d min\n%s",nome, ano, genero.getNome(), timeMin,descricao);
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if (obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		if(!nome.equals(other.nome)){
			return false;
		}
		return true;
	}

	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
		return result;
	}

}
