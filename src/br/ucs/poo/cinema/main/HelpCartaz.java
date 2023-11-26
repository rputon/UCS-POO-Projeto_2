package br.ucs.poo.cinema.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.cinema.Horario;
import br.ucs.poo.cinema.cinema.Sala;
import br.ucs.poo.cinema.filme.Cartaz;
import br.ucs.poo.cinema.filme.Filme;
import br.ucs.poo.cinema.filme.Genero;
import br.ucs.poo.cinema.filme.Rating;

public class HelpCartaz {
    Help h = new Help();
    HelpFilme hf = new HelpFilme();
    HelpRating hr = new HelpRating();
    HelpGenero hg = new HelpGenero();
    HelpSala hs = new HelpSala();
    HelpHorario hh = new HelpHorario();
    private String erro = "Valor informado é inválido";

    public void addFilmeCartaz(Scanner in, Boolean fExiste, Cinema cine) {
        boolean test = false;
        do {
            String nome = h.returnString(in, "Digite o nome do filme:");
            Map<Integer, Filme> map = hf.searchFilmeName(cine, nome);

            if (map.size() > 1) {
                for (Map.Entry<Integer, Filme> l : map.entrySet()) {
                    System.out.println(
                            String.format("%d - %s, %s", l.getKey(), l.getValue().getNome(), l.getValue().getAno()));
                }
                int opt = h.returnInt(in, "Qual filme deseja adicionar ao cartaz?", 0, map.size());
                cine.setFilmeCartaz(cine.getFilme(opt));
                test = true;
            } else if (map.size() == 1) {
                for (Map.Entry<Integer, Filme> l : map.entrySet()) {
                    cine.setFilmeCartaz(cine.getFilme(l.getKey()));
                }
                test = true;
            } else {
                int ano = h.returnInt(in, "Digite o ano de publicação do filme:", 1890, 2030);
                int timeMin = h.returnInt(in, "Digite a duração do filme:", 0, 5220);
                String descricao = h.returnString(in, "Digite a descrição do filme:");
                Rating rating = hr.testRating(in, cine);
                Genero genero = hg.testGenero(in, cine);

                // TODO:Confirma dados do filme

                LocalDate dInicio = h.returnDate(in, "Digite o dia de estreia do filme:");
                LocalDate dFim = h.returnDate(in, "Digite o dia que este filme irá sair de cartaz:");

                Sala sala = hs.testSala(in, cine);
                Horario hora = hh.testHorario(in, cine);

                Filme f = new Cartaz(nome, ano, timeMin, descricao, rating, genero, sala, hora);
                cine.setFilme(f, sala, hora);
            }
        } while (test == false);
    }

    public void addFilmeCartaz(Scanner in, Cinema cine) {
        String nome = h.returnString(in, "Digite o nome do filme:");

        hf.searchFilmeName(cine, nome);

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

    public Cartaz searchFilme(Scanner in, Cinema cine){
        String nome = h.returnString(in, "Digite o nome do filme:");

        List<Cartaz> filmes = new ArrayList<Cartaz>();

        for(int index=0; index<cine.getFilmeCartaz().size();index++){
            if(cine.getFilmeCartaz(index).getNome().equals(nome)){
                filmes.add(cine.getFilmeCartaz(index));
            }
        }
        if(filmes.size()== 1){
            return filmes.get(0);
        }
        else{
            System.out.println("Escolha o filme:");
            for(int index = 0; index<filmes.size();index++){
                System.out.println(String.format("%d - %s, %d", index+1, filmes.get(index).getNome(), filmes.get(index).getAno()));
            }
            System.out.println("Digite 0 para cancelar");
            int option = h.returnInt(in, "", 0, filmes.size());

            if(option==0){
                return null;
            }
            else{
                return filmes.get(option-1);
            }
        }
    }
    // TODO:search filme
}
