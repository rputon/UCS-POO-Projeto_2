package br.ucs.poo.cinema.cinema;

import java.util.List;

import br.ucs.poo.cinema.filme.*;
import br.ucs.poo.cinema.pessoas.Ator;
import br.ucs.poo.cinema.pessoas.Diretor;

import java.util.ArrayList;
import java.util.Collections;

public class Cinema {
	private String nome;
	private String endereco;

	private List<Filme> filmes = new ArrayList<>();
	private List<Filme> filmesCartaz = new ArrayList<>();
	private List<Ator> atores = new ArrayList<>();
	private List<Diretor> diretores = new ArrayList<>();

	private List<Ingresso> ingressos = new ArrayList<>();
	private List<Sala> salas = new ArrayList<>();
	private List<Horario> horarios = new ArrayList<>();

	private List<Genero> generos = new ArrayList<>();
	private List<Rating> ratings = new ArrayList<>();

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

	/*---- Listas -------------------------------------------------------------------------------------- */

	// Sala ----------------------------------------------------------
	public List<Sala> getSalas() {
		return this.salas;
	}

	public void setSala(Sala obj) {
		this.salas.add(obj);
	}

	public Sala getSala(int index) {
		return this.salas.get(index);
	}

	public void removeSala(int index) {
		this.salas.remove(index);
	}

	// Horario --------------------------------------------------------
	public void setHorario(Horario obj) {
		this.horarios.add(obj);
	}

	public Horario getHorario(int index) {
		return this.horarios.get(index);
	}

	public void removeHorario(int index) {
		this.horarios.remove(index);
	}

	// Filme ----------------------------------------------------------
	public List<Filme> getFilmes() {
		return filmes;
	}

	public Filme getFilme(int index) {
		return this.filmes.get(index);
	}

	public void setFilme(String nome, int ano, int timeMin, String descricao, Rating rating, Genero genero) {
		this.filmes.add(new Filme(nome, ano, timeMin, descricao, rating, genero));
		Collections.sort(filmes, new SortFilme());
	}

	public void setFilme(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public void setFilme(Filme filme) {
		this.filmes.add(filme);
	}

	public void setFilme(Filme filme, Sala sala, Horario hora) {
		this.filmes.add(filme);
	}

	public void removeFilme(int index) {
		this.filmes.remove(index);
	}

	// Filme Cartaz --------------------------------------------------
	public Filme getFilmeCartaz(int index) {
		return filmesCartaz.get(index);
	}

	public List<Filme> getFilmeCartaz() {
		return filmesCartaz;
	}

	public void setFilmeCartaz(String nome, int ano, int timeMin, String descricao, Rating rating, Genero genero) {
		if (filmes.size() <= 10) {
			this.filmesCartaz.add(new Filme(nome, ano, timeMin, descricao, rating, genero));
			Collections.sort(filmesCartaz, new SortFilme());
		}
	}

	public void setFilmeCartaz(Filme f) {
		this.filmesCartaz.add(f);
	}

	public Filme removeFilmeCartaz(int index) {
		return filmesCartaz.remove(index);
	}

	// Assentos ------------------------------------------------------

	// Ingresso -------------------------------------------------------
	public void setIngresso(Ingresso ingresso) {
		this.ingressos.add(ingresso);
	}

	public Ingresso getIngresso(int index) {
		return ingressos.get(index);
	}

	public Ingresso removeIngresso(int index) {
		return ingressos.remove(index);
	}

	// Atores ----------------------------------------------------------
	public List<Ator> getAtores() {
		return this.atores;
	}

	// Diretores -----------------------------------------------------
	public List<Diretor> getDiretores() {
		return this.diretores;
	}

	// Generos -------------------------------------------------------
	public List<Genero> getGenero() {
		return this.generos;
	}

	public void setGeneroNome(List<String> genero) {
		for (String i : genero) {
			this.generos.add(new Genero(i));
		}
	}

	public void setGeneroList(List<Genero> genero) {
		for (Genero i : genero) {
			this.generos.add(new Genero(i.getNome()));
		}
	}

	public void setGenero(String genero) {
		this.generos.add(new Genero(genero));
	}

	public void removeGenero(int index) {
		this.generos.remove(index);
	}

	// Rating ---------------------------------------------------------
	public List<Rating> getRating() {
		return this.ratings;
	}

	public void setRatingNome(List<String> rating) {
		for (String i : rating) {
			this.ratings.add(new Rating(i));
		}
	}

	public void setRatingList(List<Rating> rating) {
		for (Rating i : rating) {
			this.ratings.add(new Rating(i.getIdade()));
		}
	}

	/*---- Methods ---------------------------------------------------------------------------------- */

}
