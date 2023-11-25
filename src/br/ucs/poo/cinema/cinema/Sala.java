package br.ucs.poo.cinema.cinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sala implements Serializable {
	private int numero;
	private List<Assento> assentos = new ArrayList<>();
	private List<Horario> reservas = new ArrayList<>();

	/*---- Constructor ---------------------------------------------------------------------------------- */
	public Sala(int n, List<Assento> assentos) {
		setNumero(n);
		setAssentos(assentos);
	}

	public Sala(int n, char fileira, int numero){
		setNumero(n);
		setAssentos(fileira, numero);
	}
	/*---- Getters/Setters ------------------------------------------------------------------------------ */

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public List<Assento> getAssentos() {
		return assentos;
	}

	public void setAssentos(List<Assento> assentos) {
		this.assentos = assentos;
	}

	public void setAssentos(char nFileira, int nNumero) {
		for(char i=65; i<=nFileira;i++){
			//65 até 90
			for(int j=1;j<=nNumero;j++){
				assentos.add(new Assento(numero, i, j));
			}
		}
	}

	public String toString(){
		String s = "";
		s = s + "Sala "+ numero + "\n";
		for(Assento a : assentos){
			s+= a.toString() + "\n";
		}

		return s;
	}




	/*---- Methods ---------------------------------------------------------------------------------- */

}
