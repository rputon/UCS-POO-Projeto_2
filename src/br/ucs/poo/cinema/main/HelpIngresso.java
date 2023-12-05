package br.ucs.poo.cinema.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.cinema.Horario;
import br.ucs.poo.cinema.cinema.Ingresso;
import br.ucs.poo.cinema.cinema.Sala;
import br.ucs.poo.cinema.filme.Filme;

public class HelpIngresso {
    Help h = new Help();
    HelpCartaz hc = new HelpCartaz();
    HelpSala hs = new HelpSala();

    public void vendaIngresso(Scanner in, Cinema cine) {
        if (cine.getFilmeCartaz().size() > 0) {
            System.out.println("Escolha o filme:");
            for (int index = 0; index < cine.getFilmeCartaz().size(); index++) {
                System.out.println(String.format("%d - %s, %d", index + 1, cine.getFilmeCartaz(index).getNome(),
                        cine.getFilmeCartaz(index).getAno()));
            }
            System.out.println("Digite 0 para cancelar");
            int option = h.returnInt(in, "", 0, cine.getFilmeCartaz().size());

            Filme filme;
            if (option == 0) {
                filme = null;
            } else {
                filme = cine.getFilmeCartaz(option - 1);
            }

            if (filme != null) {
                System.out.println("Escolha um horário:");
                for (int i = 1; i <= filme.getHorarios().size(); i++) {
                    System.out.println(String.format("%d - %s", i, filme.getHorarios(i - 1)));
                }
                int opt = h.returnInt(in, "", 1, filme.getHorarios().size());
                Horario hora = filme.getHorarios(opt - 1);

                Sala sala = cine.getSala(hs.searchSala(cine, hora.getNumero().getNumero()));
                char add = 'S';

                do {
                    System.out.println(hs.formatAssentos(cine, sala));
                    String assento = "";
                    do {
                        assento = h.returnString(in, "Digite o assento desejado:").toUpperCase();
                        if((sala.getAssentos().get(assento) != null) && (sala.getAssentos().get(assento).getReserva())){
                                assento = "";
                                System.out.println("Vaga já ocupada!");
                        }
                        else if(!sala.getAssentosKey().contains(assento)){
                            System.out.println("Esse assento não existe!");
                        }
                    } while (!sala.getAssentosKey().contains(assento));
                    String nome = h.returnString(in, "Digite o seu nome:");
                    int cel = h.returnInt(in, "Digite o seu celular:", 900000000, 999999999);
                    int idade = h.returnInt(in, "Digite a sua idade:");
                    boolean meia = false;
                    if (idade <= 12 || idade >= 60) {
                        meia = true;
                    }
                    filme.addIngresso();
                    Ingresso i = new Ingresso(filme.getIngressos(),filme, hora, sala.getAssento(assento), nome, cel, meia);
                    System.out.println(i);
                    filme.addIngresso();
                    saveIngresso(cine, i);
                    sala.getAssentos().get(assento).setReserva(true);
                    hs.saveSala(cine, sala);
                    add = h.returnChar(in, "Selecionar mais assentos? S - sim, N - não");
                } while (add != 'N');
            }
        } else {
            System.out.println("Nenhum filme em cartaz. Adicione um primeiro.");
        }
    }

    public void saveIngresso(Cinema cine, Ingresso ingresso) {
        cine.setIngresso(ingresso);
        writeIngresso(cine.getIngressos());
    }

    public void writeIngresso(List<Ingresso> list) {
        File myFile = new File("files/ingressos.dat");
        try {
            FileOutputStream myOutput = new FileOutputStream(myFile);
            ObjectOutputStream myObj = new ObjectOutputStream(myOutput);

            myObj.writeObject(list);

            myObj.close();
            myOutput.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo ingressos");
        }
    }

    @SuppressWarnings("unchecked")
    public List<Ingresso> readIngresso() {
        List<Ingresso> list = new ArrayList<Ingresso>();
        File myFile = new File("files/ingressos.dat");

        try {
            FileInputStream myInput = new FileInputStream(myFile);
            ObjectInputStream myObj = new ObjectInputStream(myInput);

            Object obj = myObj.readObject();
            list = (List<Ingresso>) obj;

            myObj.close();
            myInput.close();

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo ingressos");
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Ocorreu um erro de classe ao ler o arquivo ingressos");
        }
        return list;

    }
}
