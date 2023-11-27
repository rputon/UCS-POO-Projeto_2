package br.ucs.poo.cinema.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.filme.Filme;

public class HelpCartaz {
    Help h = new Help();
    HelpFilme hf = new HelpFilme();
    HelpSala hs = new HelpSala();

    public int searchCartaz(Cinema cine, Scanner in, String nome) {
        Map<Integer, Filme> filmes = new TreeMap<Integer, Filme>();
        int retorno = -1;
        for (int index = 0; index < cine.getFilmeCartaz().size(); index++) {
            if (cine.getFilmeCartaz(index).getNome().equals(nome)) {
                filmes.put(index, cine.getFilmeCartaz(index));
                retorno = index;
            }
        }
        if (filmes.isEmpty()) {
            return -1;
        } else if (filmes.size() == 1) {
            return retorno;
        } else {
            System.out.println("Escolha o filme:");
            for (int index = 0; index < filmes.size(); index++) {
                System.out.println(String.format("%d - %s, %d", index + 1, filmes.get(index).getNome(),
                        filmes.get(index).getAno()));
            }
            int option = h.returnInt(in, "", 1, filmes.size());

            List<Integer> keys = new ArrayList<Integer>(filmes.keySet());
            return keys.get(option);
        }
    }

    public void addCartaz(Scanner in, Cinema cine) {
        String nome = h.returnString(in, "Digite o nome do filme:");
        int search = searchCartaz(cine, in, nome);

        if (search == -1) {
            int sFilme = hf.searchFilme(in, cine, nome);
            if(sFilme != -1){
                int sala = h.returnInt(in, "Digite a sala em que o filme será exibido:");
                System.out.println(cine.getSala(sala).getHorarios());
            }
        } else {
            System.out.println("Esse filme já está em exibição:");

            int option = h.returnInt(in, "", 0, 3);
        }

        // System.out.println(cine.getS);
        // Em quais salas ele será aprensentado?
        // lista de salas
        // Sala x -> lista de filmes exibidos na sala x/horarios
        // Confirmar sala
        // Qual horário sera exibido?
        // Este horário (minutos do filme) irá conflitar com o filme y
        // escolha outra sala
        // Confirmar informações
        // salvar na lista + arquivo
    }

}