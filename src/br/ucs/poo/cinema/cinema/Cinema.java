package br.ucs.poo.cinema.cinema;

import java.util.List;

//import br.ucs.poo.cinema.filme.Filme;

import java.util.ArrayList;

public class Cinema {
	private String nome;
	private String endereco;
	private List<Sala> numero = new ArrayList<>();
	//private List<Filme> filmes = new ArrayList<>();
	private Ingresso ingresso;
	
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

	public Sala getNumero(int index) {
		return numero.get(index);
	}

	public void setNumero(Sala index) {
		this.numero.add(index);
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}
	
	
	/*---- Methods ---------------------------------------------------------------------------------- */


}
