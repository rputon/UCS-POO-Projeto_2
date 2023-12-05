package br.ucs.poo.cinema.cinema;

import java.util.List;

import br.ucs.poo.cinema.filme.*;
import br.ucs.poo.cinema.pessoas.Ator;
import br.ucs.poo.cinema.pessoas.Diretor;
import br.ucs.poo.cinema.pessoas.Pessoa;

import java.util.ArrayList;
import java.util.Collections;

public class Cinema {
	private String nome;
	private String endereco;

	private List<Filme> filmes = new ArrayList<Filme>();
	private List<Filme> filmesCartaz = new ArrayList<Filme>();
	private List<Pessoa> pessoas = new ArrayList<Pessoa>();

	private List<Ingresso> ingressos = new ArrayList<Ingresso>();
	private List<Sala> salas = new ArrayList<Sala>();
	// private List<Horario> horarios = new ArrayList<Horario>();

	private List<Genero> generos = new ArrayList<Genero>();
	private List<Rating> ratings = new ArrayList<Rating>();

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

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public void setSala(Sala obj) {
		this.salas.add(obj);
	}

	public void setSala(int sala, char f, int n) {
		this.salas.add(new Sala(sala, f, n));
	}

	public Sala getSala(int index) {
		return this.salas.get(index);
	}

	public void removeSala(int index) {
		this.salas.remove(index);
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

	public void setFilme(String nome, int ano, int timeMin, String descricao, Rating rating, Genero genero,
			List<Ator> atores, Diretor dire) {
		this.filmes.add(new Filme(nome, ano, timeMin, descricao, rating, genero, atores, dire));
		Collections.sort(filmes, new SortFilme());
	}

	public void setFilme(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public void setFilme(Filme filme) {
		this.filmes.add(filme);
	}

	public void setFilmeCartaz(Filme filme, Sala sala, Horario hora) {
		filme.setSala(sala);
		filme.setHora(hora);
		this.filmesCartaz.add(filme);
	}

	public void removeFilme(int index) {
		this.filmes.remove(index);
	}

	// Filme Cartaz --------------------------------------------------
	public void setFilmeCartaz(List<Filme> filmes) {
		for (Filme f : filmes) {
			this.filmesCartaz.add(f);
		}
	}

	public Filme getFilmeCartaz(int index) {
		return filmesCartaz.get(index);
	}

	public List<Filme> getFilmeCartaz() {
		return filmesCartaz;
	}

	public Filme removeFilmeCartaz(int index) {
		return filmesCartaz.remove(index);
	}

	// Ingresso -------------------------------------------------------
	public void setIngresso(Ingresso ingresso) {
		this.ingressos.add(ingresso);
	}

	public Ingresso getIngresso(int index) {
		return ingressos.get(index);
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}

	public Ingresso removeIngresso(int index) {
		return ingressos.remove(index);
	}

	// Atores e Diretores ----------------------------------------------------------
	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoa(String nome, String pais) {
		this.pessoas.add(new Ator(nome, pais));
	}

	public void setAtor(Ator ator) {
		this.pessoas.add(ator);
	}

	public void setDiretor(Diretor dire) {
		this.pessoas.add(dire);
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
