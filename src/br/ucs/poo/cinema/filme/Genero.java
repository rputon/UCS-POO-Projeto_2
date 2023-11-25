package br.ucs.poo.cinema.filme;

import java.io.Serializable;

public class Genero implements Serializable {
	private String nome;

	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Genero(String genero) {
		setNome(genero);
	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*---- Methods ---------------------------------------------------------------------------------- */
	public String toString() {
		return this.nome;
	}
}
