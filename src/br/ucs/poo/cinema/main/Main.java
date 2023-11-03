package br.ucs.poo.cinema.main;
import br.ucs.poo.cinema.controle.Cinema;

import java.util.List;

public class Main {
	public static void main(String[] args){
		Help.validFile("filme");
		Help.addDatatoFile("filme", "Encontro Marcado");
		Help.addDatatoFile("filme", "Avengers");
		//Help.overWriteFile("filme", "TESTE", "String", 1);
		List<String> filmes = Help.readFile("filme");
		Cinema.setFilme(filmes);

		
	}
}
