package br.ucs.poo.cinema.main;

//import java.util.List;
import java.util.Scanner;
import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.filme.Filme;

public class HelpIngresso {
    Help h = new Help();
    HelpCartaz hc = new HelpCartaz();
    
    public void vendaIngresso(Scanner in, Cinema cine) {
        System.out.println("Escolha o filme:");
        for(int index = 0; index<cine.getFilmeCartaz().size();index++){
            System.out.println(String.format("%d - %s, %d", index+1, cine.getFilmeCartaz(index).getNome(), cine.getFilmeCartaz(index).getAno()));
        }
        System.out.println("Digite 0 para cancelar");
        int option = h.returnInt(in, "", 0, cine.getFilmeCartaz().size());

        Filme filme;
        if(option==0){
            filme = null;
        }
        else{
            filme = cine.getFilmeCartaz(option-1);
        }

        if(filme != null){
            System.out.println();
        }
            // filme não existe
            // tentar novamente
            // criar filme
        

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
