package br.ucs.poo.cinema.teste;

import java.util.Arrays;
import java.util.Scanner;

import br.ucs.poo.cinema.cinema.*;
import br.ucs.poo.cinema.main.*;

public class Teste {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
		Help h = new Help();
		HelpAtor ha = new HelpAtor();
		HelpCartaz hc = new HelpCartaz();
		HelpFilme hf = new HelpFilme();
		HelpGenero hg = new HelpGenero();
		HelpHorario hh = new HelpHorario();
		HelpIngresso hi = new HelpIngresso();
		HelpRating hr = new HelpRating();
		HelpSala hs = new HelpSala();

		Cinema cine = new Cinema();

        if (!h.validFile("ratings")) {
			cine.setRatingNome(Arrays.asList("Livre", "10", "12", "14", "16", "18"));
			hr.writeFileRating("ratings", cine.getRating());
		} else {
			cine.setRatingList(hr.readFileRating("ratings"));
		}

		if (!h.validFile("generos")) {
			cine.setGeneroNome(
					Arrays.asList("Ação", "Aventura", "Comédia", "Comédia dramática", "Comédia romântica", "Dança",
							"Documentário", "Drama", "Espionagem", "Faroeste", "Fantasia", "Fantasia Científica",
							"Ficção Científica", "Filmes de Guerra", "Mistério", "Musical", "Filme Policial", "Romance",
							"Terror", "Thriller"));
			hg.writeFileGenero("generos", cine.getGenero());
		} else {
			cine.setGeneroList(hg.readFileGenero("generos"));
		}

        if (h.validFile("filmes")) {
			cine.setFilme(hf.readFilme());
		}
		
		//hf.addFilme(in, cine);
		hc.addCartaz(in, cine);

        
    }
}
