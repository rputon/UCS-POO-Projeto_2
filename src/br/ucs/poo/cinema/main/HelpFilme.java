package br.ucs.poo.cinema.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.filme.Filme;
import br.ucs.poo.cinema.filme.Genero;
import br.ucs.poo.cinema.filme.Rating;
import br.ucs.poo.cinema.pessoas.Ator;
import br.ucs.poo.cinema.pessoas.Diretor;

public class HelpFilme {
    Help h = new Help();
    HelpRating hr = new HelpRating();
    HelpGenero hg = new HelpGenero();
    HelpPessoa hp = new HelpPessoa();

    public int searchFilme(Scanner in, Cinema cine, String nome) {
        Map<Integer,Filme> filmes = new TreeMap<Integer,Filme>();
        int retorno = -1;
        for (int index = 0; index < cine.getFilmes().size(); index++) {
            if (cine.getFilme(index).getNome().equals(nome)) {
                filmes.put(index,cine.getFilme(index));
            }
        }
        if (filmes.isEmpty()) {
            return -1;
        } else {
            int ano = h.returnInt(in, "Digite o ano do filme:", 1890, 2030);
            List<Integer> key = new ArrayList<Integer>(filmes.keySet());
            for (int index = 0; index < filmes.size(); index++) {
                if (filmes.get(index).getAno() == ano) {
                    retorno = key.get(index);
                }
            }
            if (retorno != -1) {
                return retorno;
            } else {
                return -1;
            }
        }
    }

    public void addFilme(Scanner in, Cinema cine) {
        String nome = h.returnString(in, "Digite o nome do filme:");
        int search = searchFilme(in, cine, nome);
        // Filme filme = cine.getFilme(search);

        if (search != -1) {
            System.out.println("Esse filme já está cadastrado.");
        } else {
            int ano = h.returnInt(in, "Digite o ano do filme:", 1890, 2030);
            int timeMin = h.returnInt(in, "Digite a duração do filme(min):", 0, 5220);
            String desc = h.returnString(in, "Digite a descrição do filme:");
            Rating rating = hr.testRating(in, cine);
            Genero genero = hg.testGenero(in, cine);

            boolean test = false;
            Filme filme = new Filme(nome, ano, timeMin, desc, rating, genero);
            do {
                System.out.println(String.format(
                                        "1 - %s \n2 - %d \n3min - %d \n4 - %s \n5 - %s \n6 - %s \nDigite 0 para cancelar", nome,
                                        ano, timeMin, desc, rating, genero));
                char sn = h.returnChar(in, "Estas informações estão corretas? S - sim, N - não \n");
                

                if (sn == 'S') {
                    int option = h.returnInt(in,
                            "1 - Salvar e sair \n2 - Adicionar mais dados \nDigite 0 para cancelar", 0,
                            2);
                    if (option == 1) {
                        saveFilme(cine, filme);
                    } else if (option == 2) {
                        String direNome = h.returnString(in, "Digite o nome do diretor:");
                        String paisDire = hp.testRating(in, cine);

                        cine.setDiretor(nome, paisDire);
                        Diretor dire = new Diretor(direNome, paisDire);

                        List<Ator> atores = new ArrayList<Ator>();
                        String opt2 = "-1";
                        do {
                            String ator = h.returnString(in, "Digite o nome do ator. Digite 0 para finalizar");
                            String paisAtor = h.returnString(in, "Digite o país de origem do ator:");
                            cine.setAtor(ator, paisAtor);
                            atores.add(new Ator(ator, paisAtor));
                        } while (!opt2.equals("0"));
                        filme = new Filme(nome, ano, timeMin, desc, rating, genero, atores, dire);
                        saveFilme(cine, filme);
                    } else {
                        break;
                    }
                    test = true;
                    break;
                } else {
                    filme = editFilme(cine, in, filme);
                }
            } while (test == false);
        }
    }

    public void saveFilme(Cinema cine, Filme filme) {
        cine.setFilme(filme);
        writeFilme(cine.getFilmes());
    }

    public void writeFilme(List<Filme> list) {
        File myFile = new File("files/filmes.dat");
        try {
            FileOutputStream myOutput = new FileOutputStream(myFile);
            ObjectOutputStream myObj = new ObjectOutputStream(myOutput);

            myObj.writeObject(list);

            myObj.close();
            myOutput.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo filmes");
        }
    }

    @SuppressWarnings("unchecked")
    public List<Filme> readFilme() {
        List<Filme> list = new ArrayList<Filme>();
        File myFile = new File("files/filmes.dat");

        try {
            FileInputStream myInput = new FileInputStream(myFile);
            ObjectInputStream myObj = new ObjectInputStream(myInput);

            Object obj = myObj.readObject();
            list = (List<Filme>) obj;

            myObj.close();
            myInput.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo filmes");
        } catch (ClassNotFoundException e) {
            System.out.println("Ocorreu um erro de classe ao ler o arquivo filmes");
        }
        return list;
    }

    public Filme editFilme(Cinema cine, Scanner in, Filme filme) {
        boolean test = false;

        do {
            System.out.println("Escolha o que deseja alterar: ");
            System.out.println(String.format(
                    "1 - %s \n2 - %d \n3 - %d \n4 - %s \n5 - %s \n6 - %s \nDigite 0 para cancelar", filme.getNome(),
                    filme.getAno(), filme.getTimeMin(), filme.getDescricao(), filme.getRating(), filme.getGenero()));
            int option = h.returnInt(in, "", 0, 6);
            switch (option) {
                case 0:
                    test = true;
                    break;

                case 1:
                    filme.setNome(h.returnString(in, "Digite o nome do filme:"));
                    break;

                case 2:
                    filme.setAno(h.returnInt(in, "Digite o ano do filme: ", 1890, 2030));
                    break;

                case 3:
                    filme.setTimeMin(h.returnInt(in, "Digite a duração do filme: ", 0, 5220));
                    break;

                case 4:
                    filme.setDescricao(h.returnString(in, "Digite a descrição do filme:"));
                    break;

                case 5:
                    filme.setRating(hr.testRating(in, cine));
                    break;

                case 6:
                    filme.setGenero(hg.testGenero(in, cine));

                    break;
                default:
                    System.out.println("Opção escolhida é inválida");
                    break;
            }
        } while (test == false);
        return filme;
    }

    public void removeFilme(Scanner in, Cinema cine) {
        int search = searchFilme(in, cine, h.returnString(in, "Digite o nome do filme: "));

        char sn = h.returnChar(in, "Tem certeza que deseja remover o filme: \n" + cine.getFilme(search));
        if (sn == 'S') {
            cine.removeFilme(search);
        }
    }

    public String formatFilme(Cinema cine) {
        int[] lengthNome = { 0, 0, 0 };
        int[] lengthDesc = { 0, 0, 0 };
        for (int i = 0; i <= cine.getFilmes().size(); i++) {
            if ((cine.getFilmes().size() - i) >= 3) {
                i += 2;
                if (cine.getFilme(i - 2).getNome().length() > lengthNome[0]) {
                    lengthNome[0] = cine.getFilme(i - 2).getNome().length() + 10;
                }
                if (cine.getFilme(i - 1).getNome().length() > lengthNome[1]) {
                    lengthNome[1] = cine.getFilme(i - 1).getNome().length() + 10;
                }
                if (cine.getFilme(i).getNome().length() > lengthNome[2]) {
                    lengthNome[2] = cine.getFilme(i).getNome().length() + 10;
                }

                if (cine.getFilme(i - 2).toString(2).length() > lengthDesc[0]) {
                    lengthDesc[0] = cine.getFilme(i - 2).toString(2).length() + 10;
                }
                if (cine.getFilme(i - 1).toString(2).length() > lengthDesc[1]) {
                    lengthDesc[1] = cine.getFilme(i - 1).toString(2).length() + 10;
                }
                if (cine.getFilme(i).toString(2).length() > lengthDesc[2]) {
                    lengthDesc[2] = cine.getFilme(i).toString(2).length() + 10;
                }
            } else if ((cine.getFilmes().size() - i) == 2) {
                i += 1;
                if (cine.getFilme(i - 1).getNome().length() > lengthNome[1]) {
                    lengthNome[1] = cine.getFilme(i - 1).getNome().length() + 10;
                }
                if (cine.getFilme(i).getNome().length() > lengthNome[0]) {
                    lengthNome[0] = cine.getFilme(i).getNome().length() + 10;
                }

                if (cine.getFilme(i - 1).toString(2).length() > lengthDesc[1]) {
                    lengthDesc[1] = cine.getFilme(i - 1).toString(2).length() + 10;
                }
                if (cine.getFilme(i).toString(2).length() > lengthDesc[2]) {
                    lengthDesc[2] = cine.getFilme(i).toString(2).length() + 10;
                }

            } else if ((cine.getFilmes().size() - i) == 1) {
                if (cine.getFilme(i).getNome().length() > lengthNome[0]) {
                    lengthNome[0] = cine.getFilme(i).getNome().length() + 10;
                }

                if (cine.getFilme(i).toString(2).length() > lengthDesc[2]) {
                    lengthDesc[2] = cine.getFilme(i).toString(2).length() + 10;
                }
            }
        }

        int[] finalLenght = new int[3];
        for (int i = 0; i < 3; i++) {
            if (lengthDesc[i] > lengthNome[i]) {
                finalLenght[i] = lengthDesc[i];
            } else if (lengthDesc[i] < lengthNome[i]) {
                finalLenght[i] = lengthNome[i];
            } else {
                finalLenght[i] = lengthDesc[i];
            }
        }

        StringBuilder formatBuilder1 = new StringBuilder();
        StringBuilder formatBuilder2 = new StringBuilder();
        StringBuilder formatBuilder3 = new StringBuilder();

        formatBuilder1.append("%-").append(finalLenght[0]).append("s");
        String format1 = formatBuilder1.toString();
        formatBuilder2.append("%-").append(finalLenght[1]).append("s");
        String format2 = formatBuilder2.toString();
        formatBuilder3.append("%-").append(finalLenght[2]).append("s");
        String format3 = formatBuilder3.toString();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= cine.getFilmes().size(); i++) {
            if ((cine.getFilmes().size() - i) >= 3) {
                i += 2;
                result.append(String.format(format1, cine.getFilme(i - 2).getNome()))
                        .append(String.format(format2, cine.getFilme(i - 1).getNome()))
                        .append(String.format(format3, cine.getFilme(i).getNome()))
                        .append("\n")
                        .append(String.format(format1, cine.getFilme(i - 2).toString(2)))
                        .append(String.format(format2, cine.getFilme(i - 1).toString(2)))
                        .append(String.format(format3, cine.getFilme(i).toString(2)))
                        .append("\n").append("\n");

            } else if ((cine.getFilmes().size() - i) == 2) {
                i += 1;
                result.append(String.format(format1, cine.getFilme(i - 1).getNome()))
                        .append(String.format(format2, cine.getFilme(i).getNome()))
                        .append("\n")
                        .append(String.format(format1, cine.getFilme(i - 1).toString(2)))
                        .append(String.format(format2, cine.getFilme(i).toString(2)))
                        .append("\n").append("\n");

            } else if ((cine.getFilmes().size() - i) == 1) {
                result.append(String.format(format1, cine.getFilme(i).getNome()))
                        .append("\n")
                        .append(String.format(format1, cine.getFilme(i).toString(2)))
                        .append("\n").append("\n");
            }
        }
        return result.toString();
    }
}
