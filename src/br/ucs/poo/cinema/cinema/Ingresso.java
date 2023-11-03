package br.ucs.poo.cinema.controle;
import java.util.Date;

public class Ingresso {
	private String nome;
	private Date data;
	private int celular;
	private double preco;
	private boolean meiaEntrada;
	private Assento assento;
	private Horario reserva;
	private Filme filme;
	
	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Ingresso() {
		
	}

	/*---- Getters/Setters ------------------------------------------------------------------------------ */
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
	
	
	
	
	
}
