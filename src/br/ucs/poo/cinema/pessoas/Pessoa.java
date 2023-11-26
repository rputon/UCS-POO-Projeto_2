package br.ucs.poo.cinema.pessoas;

public class Pessoa {
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

}
