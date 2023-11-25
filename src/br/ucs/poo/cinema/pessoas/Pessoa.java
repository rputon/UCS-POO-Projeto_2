package br.ucs.poo.cinema.pessoas;

public class Pessoa {
	protected String nome;
	protected int idade;
	protected String casado;

	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Pessoa() {

	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	/*---- Methods ---------------------------------------------------------------------------------- */

}
