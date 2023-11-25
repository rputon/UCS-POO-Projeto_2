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
import br.ucs.poo.cinema.filme.Genero;

public class HelpGenero {
    Help h = new Help();
    private String erro = "Valor informado é inválido";

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

    public void saveGenero(Cinema cine) {
        writeFileGenero("generos", cine.getGenero());
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
            value = h.returnInt(in, "", 0, generos.size());

            if (value == 0) {
                String nome = h.returnString(in, "Digite o gênero:");
                genero.setNome(nome);
                cine.setGenero(nome);
                saveGenero(cine);

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
}
