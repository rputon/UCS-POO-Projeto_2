package br.ucs.poo.cinema.main;

import java.util.ArrayList;
import java.util.List;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.pessoas.Ator;

public class HelpAtor {
    public List<Ator> searchAtorName(Cinema cine, String nome) {
        List<Ator> retorno = new ArrayList<>();

        for (Ator a : cine.getAtores()) {
            if (a.getNome().indexOf(nome) >= 0) {
                retorno.add(a);
            }
        }
        return retorno;
    }

}
