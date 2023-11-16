package br.ucs.poo.cinema.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ucs.poo.cinema.filme.Filme;
import br.ucs.poo.cinema.filme.Genero;
import br.ucs.poo.cinema.filme.Rating;
import br.ucs.poo.cinema.cinema.Cinema;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Help {
    private String erro = "Valor informado é inválido";

    // ! ---- User
    // -------------------------------------------------------------------------
    public String testUser(Scanner in, String print, List<String> users) {
        String user = "";

        do {
            user = returnString(in, print);
            if (!users.contains(user)) {
                System.out.println("Usuário não encontrado.\n");
            }
        } while (!users.contains(user));

        return user;
    }

    public Rating testRating(Scanner in, Cinema cine) {
        List<Rating> ratings = cine.getRating();
        Rating rating = new Rating("");
        String value = "";
        boolean test = false;

        do {
            try {
                value = returnString(in, "Digite a classificação: ");

                for (Rating r : ratings) {
                    if (r.getIdade().indexOf(value) >= 0) {
                        test = true;
                        return r;
                    }
                }
                System.out.println("Esta classificação não existe.");
                System.out.println("Escolha uma das seguintes opções:");
                System.out.println(cine.getRating());
            } catch (Exception e) {
                System.out.println(erro);
            }
        } while (test == false);
        return rating;
    }

    public Genero testGenero(Scanner in, Cinema cine) {
        List<Genero> generos = cine.getGenero();
        Genero genero = new Genero("");
        int value = -1;
        Boolean test = false;

        do {
            System.out.println("Escolha o gênero:");

            for (int i = 0; i < generos.size(); i++) {
                System.out.println(String.format("%d - %s", i + 1, generos.get(i).getNome()));
            }
            System.out.println("0 - Criar gênero");
            value = returnInt(in, "");

            if (value == 0) {
                String nome = returnString(in, "Digite o gênero:");
                genero.setNome(nome);
                cine.setGenero(nome);
                writeFileGenero("generos", cine.getGenero());
                test = true;
                return genero;
            } else if (value >= 1 && value - 1 < generos.size()) {
                test = true;
                return generos.get(value - 1);
            } else {
                System.out.println(erro);
            }
        } while (test == false);
        return genero;
    }

    // ! ---- Files
    // -----------------------------------------------------------------------
    public boolean validFile(String file) {
        File myFile = new File(String.format("files\\%s.dat", file));
        try {
            if (myFile.createNewFile()) {
                // System.out.println(String.format("Arquivo de %s criado: %s", file,
                // myFile.getPath()));
                return false;
            } else {
                // System.out.println("Consultando dados...");
                return true;
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao validar o arquivo.");
        }
        return true;
    }

    // ! ---- Rating ----
    public void writeFileRating(String file, List<Rating> lista) {
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

    @SuppressWarnings("unchecked")
    public List<Rating> readFileRating(String file) {
        List<Rating> lista = new ArrayList<>();
        File myFile = new File(String.format("files\\%s.dat", file));

        try {
            FileInputStream myInput = new FileInputStream(myFile);
            ObjectInputStream myObj = new ObjectInputStream(myInput);

            Object obj = myObj.readObject();
            lista = (List<Rating>) obj;

            myObj.close();
            myInput.close();

        } catch (IOException e) {
            System.out.println(String.format("Ocorreu um erro ao ler o arquivo. %s", file));
        } catch (ClassNotFoundException e) {
            System.out.println(String.format("Ocorreu um erro de classe ao ler o arquivo. %s", file));
        }
        return lista;
    }

    // ! ---- Genero ----
    public void writeFileGenero(String file, List<Genero> lista) {
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

    @SuppressWarnings("unchecked")
    public List<Genero> readFileGenero(String file) {
        List<Genero> lista = new ArrayList<>();
        File myFile = new File(String.format("files\\%s.dat", file));

        try {
            FileInputStream myInput = new FileInputStream(myFile);
            ObjectInputStream myObj = new ObjectInputStream(myInput);

            Object obj = myObj.readObject();
            lista = (List<Genero>) obj;

            myObj.close();
            myInput.close();

        } catch (IOException e) {
            System.out.println(String.format("Ocorreu um erro ao ler o arquivo. %s", file));
        } catch (ClassNotFoundException e) {
            System.out.println(String.format("Ocorreu um erro de classe ao ler o arquivo. %s", file));
        }
        return lista;
    }

    // ! ---- Filme ----
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

    public String tableFilme(Cinema cine) {
        //List<String> listName = new ArrayList<>();

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

                //System.out.println("3 " +result.toString());

            } else if ((cine.getFilmes().size() - i) == 2) {
                i += 1;
                result.append(String.format(format1, cine.getFilme(i - 1).getNome()))
                        .append(String.format(format2, cine.getFilme(i).getNome()))
                        .append("\n")
                        .append(String.format(format1, cine.getFilme(i - 1).toString(2)))
                        .append(String.format(format2, cine.getFilme(i).toString(2)))
                        .append("\n").append("\n");

                //System.out.println("2 " +result.toString());

            } else if ((cine.getFilmes().size() - i) == 1) {
                result.append(String.format(format1, cine.getFilme(i).getNome()))
                        .append("\n")
                        .append(String.format(format1, cine.getFilme(i).toString(2)))
                        .append("\n").append("\n");
                //System.out.println("1 " + result.toString());
            }
        }

        // for(Filme f : cine.getFilmes()){
        // StringBuilder formatBuilderNome = new StringBuilder();
        // formatBuilderNome.append("%-").append(lengthNome + 2).append("s");
        // String formatNome = formatBuilderNome.toString();

        // StringBuilder resultNome = new StringBuilder();
        // resultNome.append(String.format(formatNome, f.getNome()));//.append("");
        // listName.add(resultNome.toString());
        // }

        // int lengthDesc = cine.getFilme(0).toString(2).length();

        // StringBuilder formatBuilderDesc = new StringBuilder();
        // formatBuilderDesc.append("%-").append(lengthDesc + 2).append("s");
        // String formatDesc = formatBuilderDesc.toString();

        // StringBuilder resultDesc = new StringBuilder();
        // resultDesc.append(String.format(formatDesc,
        // cine.getFilme(0).toString(2))).append("\n");

        return result.toString();
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

    // ! ---- Filmes
    // ----------------------------------------------------------------------------------
    // */
    public List<Filme> searchFilmeName(List<Filme> filmes, String nome) {

        List<Filme> retorno = new ArrayList<>();

        for (Filme f : filmes) {
            if (f.getNome().indexOf(nome) >= 0) {
                retorno.add(f);
            }
        }

        // retorno.isEmpty();

        return retorno;
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // ! ---- Integer
    // ----------------------------------------------------------------------------------
    // */
    public int returnInt(Scanner in, String print) {
        int value = 0;
        boolean test = false;

        do {
            try {
                System.out.println(print);
                value = in.nextInt();
                in.nextLine();

                test = true;
                break;
            } catch (Exception e) {
                System.out.println(erro);
                in.next();
            }
        } while (test == false);
        return value;
    }

    public int returnInt(Scanner in, String print, int rangeMin, int rangeMax) {
        int value = 0;
        boolean test = false;

        do {
            try {
                System.out.println(print);
                value = in.nextInt();
                in.nextLine();

                if (value >= rangeMin && value <= rangeMax) {
                    test = true;
                    break;
                }
            } catch (Exception e) {
                System.out.println(erro);
                in.next();
            }
        } while (test == false);
        return value;
    }

    // ! ---- Double
    // ----------------------------------------------------------------------------------
    // */
    public double returnDouble(Scanner in, String print) {
        double value = 0;
        boolean test = false;

        do {
            try {
                System.out.println(print);
                value = in.nextDouble();

                test = true;
                break;
            } catch (Exception e) {
                System.out.println(erro);
                in.next();
            }

        } while (test == false);
        return value;
    }

    // ! ---- String
    // ----------------------------------------------------------------------------------
    public String returnString(Scanner in, String print) {
        String value = "";
        boolean test = false;

        do {
            System.out.println(print);
            value = in.nextLine();

            // FIXME: ^V está passando
            if (!value.matches(".*[!@#$%^&´~*\\[\\]+=<>?/{}|].*")) {
                test = true;
                break;
            } else {
                System.out.println(erro);
            }
        } while (test == false);
        return value;
    }

    // ! ---- Char
    // ----------------------------------------------------------------------------------
    // */
    public char returnChar(Scanner in, String print) {
        char value = ' ';
        boolean test = false;

        do {
            System.out.println(print);
            value = Character.toUpperCase(in.next().charAt(0));
            in.nextLine();
            if (value == 'S' || value == 'N') {
                test = true;
                break;
            } else {
                System.out.println(erro);
            }
        } while (test == false);
        return value;
    }
}