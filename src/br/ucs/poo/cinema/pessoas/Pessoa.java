package br.ucs.poo.cinema.pessoas;

import java.io.Serializable;

public class Pessoa implements Serializable{
	protected String nome;
	protected String paisOrigem;
	protected Pessoa casado;

	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Pessoa(String nome, String paisOrigem) {
		setNome(nome);
		setPaisOrigem(paisOrigem);
	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPaisOrigem(){
		return paisOrigem;
	}

	public void setPaisOrigem(String pais){
		this.paisOrigem = pais;
	}

	/*---- Methods ---------------------------------------------------------------------------------- */

	public String toString(){
		return nome;
	}
}
