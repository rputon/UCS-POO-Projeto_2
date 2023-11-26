package br.ucs.poo.cinema.main;

import java.util.List;
import java.util.Scanner;

import br.ucs.poo.cinema.cinema.Cinema;

public class HelpPessoa {
    Help h = new Help();

    public String testRating(Scanner in, Cinema cine) {
        List<String> paises = cine.getPais();
        boolean test = false;

        do {
            System.out.println("Escolha o pais:");
            for (int i = 0; i < paises.size(); i++) {
                System.out.println(String.format("%d - %s", i + 1, paises.get(i)));
            }
            System.out.println("0 - Adicionar país");
            int option = h.returnInt(in, "", 0, paises.size());

            if (option == 0) {
                String pais = h.returnString(in, "Digite o nome do país:");
                cine.setPais(pais);
                test = true;
                return pais;
            } else if (option >= 1 && option - 1 < paises.size()) {
                test = true;
                return paises.get(option - 1);
            } else {
                System.out.println("Valor informado é inválido");
            }
        } while (test == false);

        return paises.get(0);
    }
}
