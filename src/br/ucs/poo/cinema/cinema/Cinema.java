package br.ucs.poo.cinema.cinema;

import java.util.List;

import br.ucs.poo.cinema.filme.Filme;

import java.util.ArrayList;

public class Cinema {
	private String nome;
	private String endereco;
	private List<Sala> salas = new ArrayList<>();
	private List<Filme> filmes = new ArrayList<>();
	private List<Filme> filmesCartaz = new ArrayList<>();
	private List<Ingresso> ingressos = new ArrayList<>();

	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Cinema() {

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
	// Create
	public void setSala(Sala index) {
		this.salas.add(index);
	}

	public void setFilme(String nome, int ano, int timeMin, String descricao, int rating) {
		this.filmes.add(new Filme(nome,ano,timeMin,descricao,rating));
	}

	public void setNumeroCartaz(Filme index) {
		if (getFilmeCartazList() <= 10) {
			this.filmesCartaz.add(index);
		}
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingressos.add(ingresso);
	}

	// Read
	public Sala getSala(int index) {
		return salas.get(index);
	}

	public Filme getFilme(int index) {
		return filmes.get(index);
	}

	public Filme getFilmeCartaz(int index) {
		return filmesCartaz.get(index);
	}

	public Ingresso getIngresso(int index) {
		return ingressos.get(index);
	}
	// Updade

	// Delete
	public Sala removeSala(int index) {
		return salas.remove(index);
	}

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
	public int getSalasList() {
		return salas.size();
	}

	public int getFilmeList() {
		return filmes.size();
	}

	public int getFilmeCartazList() {
		return filmesCartaz.size();
	}

	public int getIngressoList() {
		return ingressos.size();
	}

	/*---- Methods ---------------------------------------------------------------------------------- */

}
