package br.ucs.poo.cinema.main;

import java.util.List;
import java.util.Scanner;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.cinema.Sala;

public class HelpSala {
    private String erro = "Valor informado é inválido";


    public Sala testSala(Scanner in, Cinema cine) {
        Sala sala = new Sala(0,'0',0);
        int value = -1;
        Boolean test = false;

        do {
            System.out.println("Escolha a sala:");

            
        } while (test == false);
        return sala;
    }

    public void addSala(Scanner in, Cinema cine, int sala){
        char fileira = 0;
        int numero = 0;
        boolean test = false;

        do {
            try {
                System.out.println("Digite o valor da última fileira:");
                fileira = Character.toUpperCase(in.next().charAt(0));
                in.nextLine();

                if (fileira >= 65 || fileira <= 90) {
                    test = true;
                    break;
                } 
            } catch (Exception e) {
                System.out.println(erro + " Digite uma letra válida");
                in.next();
            }
        } while (test == false);

        test = false;
        do{
            try {
                System.out.println("Digite o valor da última coluna:");
                numero = in.nextInt();
                in.nextLine();

                test = true;
                break;
            } catch (Exception e) {
                System.out.println(erro);
                in.next();
            }
        }while(test == false);

        cine.setSala(sala, fileira, numero);
    }
}
