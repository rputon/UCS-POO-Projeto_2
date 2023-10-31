package br.ucs.poo.cinema.controle;

public class Cinema {
	private String nome;
	private String endereco;
	private Sala numero;
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

	public Sala getNumero() {
		return numero;
	}

	public void setNumero(Sala numero) {
		this.numero = numero;
	}

	public Ingresso getIngresso() {
		return ingresso;
	}

	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}
	
	
	/*---- Methods ---------------------------------------------------------------------------------- */
}
