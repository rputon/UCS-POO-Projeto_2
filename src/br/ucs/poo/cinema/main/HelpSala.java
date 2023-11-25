package br.ucs.poo.cinema.main;

import java.util.List;
import java.util.Scanner;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.cinema.Sala;

public class HelpSala {
    public Sala testSala(Scanner in, Cinema cine) {
        List<Sala> salas = cine.getSalas();
        Sala sala = new Sala("");
        int value = -1;
        Boolean test = false;

        do {
            System.out.println("Escolha o gênero:");

            for (int i = 0; i < generos.size(); i++) {
                System.out.println(String.format("%d - %s", i + 1, generos.get(i).getNome()));
            }
            System.out.println("0 - Criar gênero");
            value = h.returnInt(in, "", 0, generos.size());

            if (value == 0) {
                String nome = h.returnString(in, "Digite o gênero:");
                genero.setNome(nome);
                cine.setGenero(nome);
                hFile.saveGenero(cine);

                test = true;
                return genero;
            } else if (value >= 1 && value - 1 < generos.size()) {
                test = true;
                return generos.get(value - 1);
            } else {
                System.out.println(erro);
            }
        } while (test == false);
        return genero;
    }
}
