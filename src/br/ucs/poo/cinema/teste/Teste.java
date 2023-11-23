package br.ucs.poo.cinema.teste;

//import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.main.Help;
import br.ucs.poo.cinema.main.HelpFile;
import br.ucs.poo.cinema.main.HelpList;


public class Teste {
    public static void main(String[] args) {
        Help help = new Help();
        HelpList hList = new HelpList();
        HelpFile hFile = new HelpFile();

        Cinema cine = new Cinema();

        if (!hFile.validFile("ratings")) {
			cine.setRatingNome(Arrays.asList("Livre", "10", "12", "14", "16", "18"));
			hFile.writeFileRating("ratings", cine.getRating());
		} else {
			cine.setRatingList(hFile.readFileRating("ratings"));
		}

		if (!hFile.validFile("generos")) {
			cine.setGeneroNome(
					Arrays.asList("Ação", "Aventura", "Comédia", "Comédia dramática", "Comédia romântica", "Dança",
							"Documentário", "Drama", "Espionagem", "Faroeste", "Fantasia", "Fantasia Científica",
							"Ficção Científica", "Filmes de Guerra", "Mistério", "Musical", "Filme Policial", "Romance",
							"Terror", "Thriller"));
			hFile.writeFileGenero("generos", cine.getGenero());
		} else {
			cine.setGeneroList(hFile.readFileGenero("generos"));
		}

        if (hFile.validFile("filmes")) {
			cine.setFilme(hFile.readFileFilme("filmes"));
		}

        Scanner in = new Scanner(System.in);


        hList.addFilme(in, cine);
		//System.out.println(cine.getFilmes());
		//hList.searchFilmeName(cine, cine.getFilme(0));

		//hList.addFilme(in, cine);
		String nome = help.returnString(in, "Digite o nome do filme:");
		hList.removeFilme(cine, nome, in);

    }
}
