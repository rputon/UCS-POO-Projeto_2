package br.ucs.poo.cinema.main;

import java.util.Scanner;
import br.ucs.poo.cinema.cinema.Cinema;

public class HelpIngresso {
    Help h = new Help();
    HelpCartaz hc = new HelpCartaz();
    

    public void vendaIngresso(Scanner in, Cinema cine) {
        String nome = h.returnString(in, "Digite o nome do filme:");

        if (hList.searchFilmeName(cine, nome).size() == 1) {
            // filme selecionado
        } else {
            int ano = h.returnInt(in, "Digite o ano do filme:");
            for (Filme f : hList.searchFilmeName(cine, nome)) {
                if (f.getAno() == ano) {
                    // filme selecionado
                }
            }
            // filme não existe
            // tentar novamente
            // criar filme
        }

        // Qual filme deseja ver?
        // ? tipo 3d/legendado/dublado
        // Qual horário?
        // Mostra sala, qual assento? 1 ou mais
        // mostra preço
        // nome
        // celular
        // meia entrada - estudante, -12, +60

    }
}
