package br.ucs.poo.cinema.cinema;

import java.util.List;

import br.ucs.poo.cinema.filme.*;
//import br.ucs.poo.cinema.pessoas.Pessoa;

import java.util.ArrayList;
import java.util.Collections;

public class Cinema {
	private String nome;
	private String endereco;
	private List<Sala> salas = new ArrayList<>();
	private List<Horario> horarios = new ArrayList<>();
	private List<Filme> filmes = new ArrayList<>();
	private List<Filme> filmesCartaz = new ArrayList<>();
	//private List<Assento> assentos = new ArrayList<>();
	private List<Ingresso> ingressos = new ArrayList<>();
	//private List<Pessoa> atores = new ArrayList<>();
	//private List<Pessoa> diretores = new ArrayList<>();
	//private List<Genero> generos = new ArrayList<>();
	//private List<Rating> ratings = new ArrayList<>();


	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Cinema() {
		setNome("GNC Caxias");
		setEndereco("Villagio Caxias");
	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/*---- Listas ----------------------------------------- */

	// Sala ---------------------------------
	public int getSalasTam() {
		return this.salas.size();
	}
	
	public void setSala(Sala obj) {
		this.salas.add(obj);
	}

	public Sala getSala(int index) {
		return this.salas.get(index);
	}

	//Update

	public Sala removeSala(int index) {
		return this.salas.remove(index);
	}

	// Horario ------------------------------
	public int getHorariosTam(){
		return this.horarios.size();
	}

	public void setHorario(Horario obj){
		this.horarios.add(obj);
	}

	public Horario getHorario(int index){
		return this.horarios.get(index);
	}
	






	// Create
	public void setFilme(String nome, int ano, int timeMin, String descricao, int rating,String genero) {
		this.filmes.add(new Filme(nome,ano,timeMin,descricao,rating,genero));
		Collections.sort(filmes, new SortFilme());
		//TODO: List<Cinema> genero = c.getGeneros();
		//Generos
		//Escolha o gênero
		//getGenero -> Filme.setGenero(getGenero)
	}

	public void setFilme(List<Filme> filmes){
		this.filmes = filmes;
	}

	public void setFilmeCartaz(String nome, int ano, int timeMin, String descricao, int rating, String genero) {
		if (getFilmeCartazTam() <= 10) {
			this.filmesCartaz.add(new Filme(nome,ano,timeMin,descricao,rating,genero));
			Collections.sort(filmesCartaz, new SortFilme());
		}
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingressos.add(ingresso);
	}

	// Read----------------------------------------------------
	public List<Filme> getFilmes(){
		return filmes;
	}

	//public  boolean 

	public Filme getFilme(int index) {
		return filmes.get(index);
	}

	public Filme getFilmeCartaz(int index) {
		return filmesCartaz.get(index);
	}

	public Ingresso getIngresso(int index) {
		return ingressos.get(index);
	}
	// Updade----------------------------------------------------

	// Delete-----------------------------------------------------------
	

	public Filme removeFilme(int index) {
		return filmes.remove(index);
	}

	public Filme removeFilmeCartaz(int index) {
		return filmesCartaz.remove(index);
	}

	public Ingresso removeIngresso(int index) {
		return ingressos.remove(index);
	}

	// Get Size
	

	public int getFilmeTam() {
		return filmes.size();
	}

	public int getFilmeCartazTam() {
		return filmesCartaz.size();
	}

	public int getIngressoTam() {
		return ingressos.size();
	}

	/*---- Methods ---------------------------------------------------------------------------------- */

}
