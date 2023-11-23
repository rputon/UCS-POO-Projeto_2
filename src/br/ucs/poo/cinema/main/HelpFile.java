package br.ucs.poo.cinema.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.filme.Filme;
import br.ucs.poo.cinema.filme.Genero;
import br.ucs.poo.cinema.filme.Rating;

public class HelpFile {
    public boolean validFile(String file) {
        File myFile = new File(String.format("files\\%s.dat", file));
        try {
            if (myFile.createNewFile()) {
                return false;
            } else {
                return true;
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao validar o arquivo.");
        }
        return true;
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

    public void saveFilme(Cinema cine){
        writeFileFilme("filmes", cine.getFilmes());
    }

    public void saveGenero(Cinema cine){
        writeFileGenero("generos", cine.getGenero());
    }


}
