package br.ucs.poo.cinema.teste;

import java.util.Comparator;

class Sortbyname implements Comparator<Cliente>{
	public int compare (Cliente one, Cliente two) {
		return one.getNome().compareTo(two.getNome());
	}
}
