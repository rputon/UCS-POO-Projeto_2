package br.ucs.poo.cinema.filme;

import java.util.Comparator;

public class SortFilme implements Comparator<Filme> {
    public int compare(Filme one, Filme two) {
        String nome1 = one.getNome();
        String nome2 = two.getNome();
        int nome = nome1.compareTo(nome2);

        if (nome != 0) {
            return nome;
        }

        Integer ano1 = one.getAno();
        Integer ano2 = two.getAno();

        return ano1.compareTo(ano2);
    }
}
