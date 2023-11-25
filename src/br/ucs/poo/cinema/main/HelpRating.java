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
import br.ucs.poo.cinema.filme.Rating;

public class HelpRating {
    Help h = new Help();
    private String erro = "Valor informado é inválido";

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
    public Rating testRating(Scanner in, Cinema cine) {
        List<Rating> ratings = cine.getRating();
        Rating rating = new Rating("");
        String value = "";
        boolean test = false;

        do {
            try {
                value = h.returnString(in, "Digite a classificação: ");

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
    
}
