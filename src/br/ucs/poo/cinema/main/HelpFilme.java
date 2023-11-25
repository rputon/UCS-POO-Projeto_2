package br.ucs.poo.cinema.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.filme.Filme;
import br.ucs.poo.cinema.filme.Genero;
import br.ucs.poo.cinema.filme.Rating;

public class HelpFilme {
    Help h = new Help();
    HelpRating hr = new HelpRating();
    HelpGenero hg = new HelpGenero();
    private String erro = "Valor informado é inválido";

    @SuppressWarnings("unchecked")
    public List<Filme> readFileFilme(String file) {
        List<Filme> lista = new ArrayList<>();
        File myFile = new File(String.format("files\\%s.dat", file));

        try {
            FileInputStream myInput = new FileInputStream(myFile);
            ObjectInputStream myObj = new ObjectInputStream(myInput);

            Object obj = myObj.readObject();
            lista = (List<Filme>) obj;

            myObj.close();
            myInput.close();

        } catch (IOException e) {
            System.out.println(String.format("Ocorreu um erro ao ler o arquivo. %s", file));
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(String.format("Ocorreu um erro de classe ao ler o arquivo. %s", file));
        }
        return lista;
    }

    public void writeFileFilme(String file, List<Filme> lista) {
        File myFile = new File(String.format("files\\%s.dat", file));
        try {
            FileOutputStream myOutput = new FileOutputStream(myFile);
            ObjectOutputStream myObj = new ObjectOutputStream(myOutput);

            myObj.writeObject(lista);

            myObj.close();
            myOutput.close();
        } catch (IOException e) {
            System.out.println(String.format("Ocorreu um erro ao escrever no arquivo. %s", file));
        }
    }

    public void saveFilme(Cinema cine) {
        writeFileFilme("filmes", cine.getFilmes());
    }

    public String tableFilme(Cinema cine) {

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

    public Map<Integer, Filme> searchFilmeName(Cinema cine, String nome) {
        Map<Integer, Filme> retorno = new TreeMap<>();

        for (int i = 0; i < cine.getFilmes().size(); i++) {
            if (cine.getFilme(i).getNome().equals(nome)) {
                retorno.put(i, cine.getFilme(i));
            }
        }
        return retorno;
    }

    public List<Filme> testFilmebyYear(Cinema cine, String nome, int ano) {
        List<Filme> retorno = new ArrayList<>();
        Map<Integer, Filme> map = searchFilmeName(cine, nome);
        Collection<Filme> name = map.values();
        if (name.size() >= 0) {
            for (Filme f : name) {
                if (f.getAno() == ano) {
                    retorno.add(f);
                }
            }
        }
        return retorno;
    }

    public void addFilme(Scanner in, Cinema cine) {
        String nome, descricao;
        int ano, timeMin;

        nome = h.returnString(in, "Digite o nome do filme:");
        ano = h.returnInt(in, "Digite o ano de publicação do filme:", 1890, 2030);

        List<Filme> test = testFilmebyYear(cine, nome, ano);
        if (test.size() > 0) {
            System.out.println("Este filme já está cadastrado:");
            for (Filme f : test) {
                System.out.println(f.toString(1));
            }
            int opt = h.returnInt(in, "1 - Criar outro \n2 - Editar \nDigite 0 para cancelar", 0, 2);
            switch (opt) {
                case 0:
                    h.clearScreen();
                    break;
                case 1:
                    break;
                case 2:
                    editFilme(in, cine);
                    break;
                default:
                    System.out.println(erro);
                    break;
            }
        } else {
            timeMin = h.returnInt(in, "Digite a duração do filme, em minutos: ", 0, 5220);
            descricao = h.returnString(in, "Digite a descrição do filme:");
            Rating rating = hr.testRating(in, cine);
            Genero genero = hg.testGenero(in, cine);

            Filme temp = new Filme(nome, ano, timeMin, descricao, rating, genero);
            confirmaFilme(temp, in, cine);
        }
    }

    public Filme editFilmeConfig(Scanner in, Filme f, Cinema cine) {
        boolean test = false;

        do {
            int edt = h.returnInt(in, "Escolha o que deseja alterar:\n" + f.toString(3), 0, 6);
            char sn = 'N';
            String nome, desc;
            int ano, timeMin;
            Rating rating;
            Genero genero;
            switch (edt) {
                case 0:
                    test = true;
                    break;
                case 1:
                    do {
                        nome = h.returnString(in, "Digite o nome do filme:");
                        sn = h.returnChar(in, "\n" + nome + "\nDeseja manter esse nome? S - sim, N - não");
                    } while (sn == 'N');
                    f.setNome(nome);
                    break;
                case 2:
                    do {
                        ano = h.returnInt(in, "Digite o ano de publicação do filme:", 1890, 2030);
                        sn = h.returnChar(in, "\n" + ano + "\nDeseja manter esse ano? S - sim, N - não");
                    } while (sn == 'N');
                    f.setAno(ano);
                    break;
                case 3:
                    do {
                        timeMin = h.returnInt(in, "Digite a duração do filme:", 0, 5220);
                        sn = h.returnChar(in, "\n" + timeMin + "\nDeseja manter essa duração? S - sim, N - não");
                    } while (sn == 'N');
                    f.setTimeMin(timeMin);
                    break;
                case 4:
                    do {
                        desc = h.returnString(in, "Digite a descrição do filme:");
                        sn = h.returnChar(in, "\n" + desc + "\nDeseja manter essa descrição? S - sim, N - não");
                    } while (sn == 'N');
                    f.setDescricao(desc);
                    break;
                case 5:
                    do {
                        rating = hr.testRating(in, cine);
                        sn = h.returnChar(in, "\n" + rating + "\nDeseja manter essa classificação? S - sim, N - não");
                    } while (sn == 'N');
                    f.setRating(rating);
                    break;
                case 6:
                    do {
                        genero = hg.testGenero(in, cine);
                        sn = h.returnChar(in, "\n" + genero + "\nDeseja manter esse gênero? S - sim, N - não");
                    } while (sn == 'N');
                    f.setGenero(genero);
                    break;
                default:
                    System.out.println("Opção não existe");
                    break;
            }
        } while (test == false);
        return f;
    }

    public Filme editFilme(Scanner in, Cinema cine) {
        boolean test = false;
        int opt = -1;
        Filme f = new Filme("", 0, 0, "", new Rating("10"), new Genero("1"));

        do {
            String nome = h.returnString(in, "Digite o nome do filme:");
            Map<Integer, Filme> map = searchFilmeName(cine, nome);

            if (map.size() > 1) {
                for (Map.Entry<Integer, Filme> l : map.entrySet()) {
                    System.out.println(
                            String.format("%d - %s, %s", l.getKey(), l.getValue().getNome(), l.getValue().getAno()));
                }
                opt = h.returnInt(in, "Qual filme deseja editar?", 0, map.size());
                editFilmeConfig(in, cine.getFilme(opt), cine);
                return cine.getFilme(opt);

            } else if (map.size() == 1) {
                for (Map.Entry<Integer, Filme> l : map.entrySet()) {
                    opt = l.getKey();
                }
                return cine.getFilme(opt);
            } else {
                System.out.println("Filme não encontrado.");
                opt = h.returnInt(in, "1 - Editar outro filme\nDigite 0 para cancelar", 0, 1);
                if (opt == 0) {
                    test = true;
                    break;
                }
            }
        } while (test == false);
        return f;
    }

    public void removeFilme(Cinema cine, Scanner in) {
        boolean test = false;

        do {
            String nome = h.returnString(in, "Digite o nome do filme:");
            Map<Integer, Filme> map = searchFilmeName(cine, nome);

            if (map.size() > 1) {
                for (Map.Entry<Integer, Filme> l : map.entrySet()) {
                    System.out.println(
                            String.format("%d - %s, %s", l.getKey(), l.getValue().getNome(), l.getValue().getAno()));
                }
                int opt = h.returnInt(in, "Qual filme deseja remover?", 0, map.size());
                cine.removeFilme(opt);
                test = true;
            } else if (map.size() == 1) {
                for (Map.Entry<Integer, Filme> l : map.entrySet()) {
                    cine.removeFilme(l.getKey());
                }
                test = true;
            } else {
                System.out.println("Filme não encontrado.");
                int opt = h.returnInt(in, "1 - Remover outro filme\nDigite 0 para cancelar", 0, 1);
                if (opt == 0) {
                    test = true;
                }
            }
        } while (test == false);
        saveFilme(cine);
    }

    public int confirmaFilme(Filme f, Scanner in, Cinema cine) {
        int opt = 0;
        do {
            System.out.println(f.toString(1));
            opt = h.returnInt(in, "1 - Continuar \n2 - Editar \n3 - Salvar e sair", 1, 3);

            if (opt == 1) {
                return opt;
                /*
                 * String n = "";
                 * do {
                 * n = h.returnString(in, "Digite o nome dos atores: \nDigite 0 para cancelar");
                 * if (!n.equals("0")) {
                 * // TODO: ADD Atores
                 * }
                 * //TODO: ADD diretores
                 * } while (!n.equals("0"));
                 */
            } else if (opt == 2) {
                f = editFilmeConfig(in, f, cine);
            } else if (opt == 3) {
                cine.setFilme(f);
                saveFilme(cine);
            }
        } while (opt != 3);
        System.out.println("Filme cadastrado");
        return opt;
    }
}
