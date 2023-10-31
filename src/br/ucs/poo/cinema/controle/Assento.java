package br.ucs.poo.cinema.controle;

public class Assento {
	private int fileira;
	private int numero;
	private Sala salaNumber;
	
	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Assento(){
		
	} 
	/*---- Getters/Setters ------------------------------------------------------------------------------ */
	public int getFileira() {
		return fileira;
	}

	public void setFileira(int fileira) {
		this.fileira = fileira;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public Sala getSalaNumber() {
		return salaNumber;
	}
	
	public void setSalaNumber(Sala salaNumber) {
		this.salaNumber = salaNumber;
	}
	
	
	/*---- Methods ---------------------------------------------------------------------------------- */
	
}
