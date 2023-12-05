package br.ucs.poo.cinema.cinema;

import java.util.Date;

import br.ucs.poo.cinema.filme.Filme;

import java.io.Serializable;

public class Ingresso implements Serializable {
	private int cod;
	private String nome;
	private int celular;

	private double preco;
	private boolean meiaEntrada;

	private Filme filme;

	private Date data;
	private Horario reserva;
	private Assento assento;

	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Ingresso(int cod, Filme filme, Horario hora, Assento assento, String nome, int cel, boolean meia) {
		setFilme(filme);
		setReserva(hora);
		setData(hora.getData());
		setAssento(assento);
		setNome(nome);
		setCelular(cel);
		if (meia) {
			setPreco(5);
		} else {
			setPreco(10);
		}
	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */
	public void setCod(int cod){
		this.cod = cod;
	}

	public int getCod(){
		return cod;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public boolean isMeiaEntrada() {
		return meiaEntrada;
	}

	public void setMeiaEntrada(boolean meiaEntrada) {
		this.meiaEntrada = meiaEntrada;
	}

	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento assento) {
		this.assento = assento;
	}

	public Horario getReserva() {
		return reserva;
	}

	public void setReserva(Horario reserva) {
		this.reserva = reserva;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	/*---- Methods ---------------------------------------------------------------------------------- */
	public String toString(){
		return String.format("%d %s\n%s\n%s | R$ %.2f", cod, filme.getNome(), reserva.toString(),nome,preco);
	}


}
