package br.ucs.poo.cinema.filme;

import br.ucs.poo.cinema.cinema.Horario;

public class Filme {
	private String nome;
	private String ano;
	private int timeMin;
	private String descricao;
	private Horario hora;
	private int classificacao;
	
	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Filme() {
		
	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getAno() {
		return ano;
	}
	
	public void setAno(String ano) {
		this.ano = ano;
	}
	
	public int getTimeMin() {
		return timeMin;
	}
	
	public void setTimeMin(int timeMin) {
		this.timeMin = timeMin;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Horario getHora() {
		return hora;
	}
	
	public void setHora(Horario hora) {
		this.hora = hora;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}
	
	
	
	/*---- Methods ---------------------------------------------------------------------------------- */
}
