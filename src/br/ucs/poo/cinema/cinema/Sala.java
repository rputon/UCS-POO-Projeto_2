package br.ucs.poo.cinema.cinema;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Sala implements Serializable, Comparable<Sala>{
	private Integer numero;
	private Map<String,Assento> assentos = new TreeMap<String, Assento>();
	private int vagos;
	private List<Horario> reservas = new ArrayList<Horario>();

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

	public int assentoTam(){
		List<String> list = new ArrayList<String>(assentos.keySet());
		return list.size();
	}

	public Assento getAssento(int index){
		List<Assento> list = new ArrayList<Assento>(assentos.values());
		return list.get(index);
	}

	public void setAssentos(List<Assento> assentos) {
		for(Assento a :assentos){
			this.assentos.put(String.format("%s%s", a.getFileira(),a.getNumero()), a);
		}
	}

	public void setAssentos(char nFileira, int nNumero) {
		for(char i=65; i<=nFileira;i++){
			for(int j=1;j<=nNumero;j++){
				
				this.assentos.put(String.format("%s%d", i,j), new Assento(numero, i, j));
			}
		}
		List<Assento> str = new ArrayList<Assento>(assentos.values());
		System.out.println(str);
	}

	public String toString(){
		String s = "";
		s = s + "Sala "+ numero;
		//for(Assento a : assentos){
		//	s+= a.toString() + "\n";
		//}

		return s;
	}

	public int cadeirasVagas(){
		this.vagos = assentos.size();
		List<Assento> list = new ArrayList<Assento>(assentos.values());
		for(int i=0;i<list.size();i++){
			if(list.get(i).getReserva()){
				this.vagos -= 1;
			}
		}
		return this.vagos;
	}

	public List<Horario> getHorarios(){
		return this.reservas;
	}

	/*---- Methods ---------------------------------------------------------------------------------- */
	@Override
	public int compareTo(Sala o) {
		Sala other = (Sala) o;
		return this.numero - other.numero;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (!numero.equals(other.numero)) {
			return false;
		}
		return true;
	}

}
