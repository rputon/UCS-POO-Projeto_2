package br.ucs.poo.cinema.filme;

import java.io.Serializable;
import java.util.List;

import br.ucs.poo.cinema.cinema.Horario;
import br.ucs.poo.cinema.pessoas.Ator;
import br.ucs.poo.cinema.pessoas.Diretor;

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

	private List<Ator> atores;
	private Diretor dire;
	
	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Filme(String nome, int ano, int timeMin, String descricao, Rating rating, Genero genero) {
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
	
	/*---- Listas -------------------------------------------------------------------------------------- */
	public Horario getHora() {
		return hora;
	}
	
	public void setHora(Horario hora) {
		this.hora = hora;
	}

	public String getRating() {
		return rating.getIdade();
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public void setGenero(Genero genero){
		this.genero = genero;
	}
	
	/*---- Methods ---------------------------------------------------------------------------------- */
	public String toString(int index){
		if(index == 1){
			return String.format("%s ‧ %s\n%d ‧ %s ‧ %dmin\n%s",nome, rating, ano, genero, timeMin,descricao);
		}
		else if(index == 2){
			return String.format("%d ‧ %s ‧ %dmin",ano, genero, timeMin);
		}
		else if(index == 3){
			return String.format("1 - %s \n2 - %d \n3 - %d \n4 - %s \n5 - %s \n6 - %s \nDigite 0 para cancelar",nome, ano, timeMin, descricao, rating, genero);
		}
		return String.format("%s\n%d ‧ %s ‧ %dmin",nome, ano, genero.getNome(), timeMin);	}
	
	public String toString(){
		return String.format("%s\n%d ‧ %s ‧ %dmin",nome, ano, genero.getNome(), timeMin);
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

	/*@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
		return result;
	}*/

}
