package br.ucs.poo.cinema.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ucs.poo.cinema.filme.Filme;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class Help {
    private static String erro = "Valor informado é inválido";

    public static void clearScreen(){
        System.out.print("\033[H\033[2J");
		System.out.flush();
    }

    /*---- Integer ---------------------------------------------------------------------------------- */
    public static int returnInt(Scanner in, String print) {
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

    public static int returnInt(Scanner in, String print, int rangeMin, int rangeMax) {
        int value = 0;
        boolean test = false;

        do {
            try {
                System.out.println(print);
                value = in.nextInt();
                in.nextLine();

                if(value >=rangeMin && value <=rangeMax){
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

    /*---- Double ---------------------------------------------------------------------------------- */
    public static double returnDouble(Scanner in, String print) {
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

    /*---- String ---------------------------------------------------------------------------------- */
    public static String returnString(Scanner in, String print) {
        String value = "";
        boolean test = false;

        do {
            System.out.println(print);
            value = in.nextLine();

            if (!value.matches(".*[-!@#$%^&´~*\\[\\]+=<>?/{}|].*")) {
                test = true;
                break;
            } else {
                System.out.println(erro);
            }
        } while (test == false);
        return value;
    }

    /*---- Char ---------------------------------------------------------------------------------- */
    public static char returnChar(Scanner in, String print) {
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

    /*---- Files ---------------------------------------------------------------------------------- */

    public static void validFile(String file) {
        File myFile = new File(String.format("files\\%s.dat", file));
        try {
            if (myFile.createNewFile()) {
                System.out.println(String.format("Arquivo de %s criado: %s", file, myFile.getPath()));
            }
            else {
                System.out.println("Consultando dados...");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao validar o arquivo.");
        }
    }

    public static List<Filme> readFileFilme(String file){
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
			System.out.println("Ocorreu um erro ao ler o arquivo.");
		} catch (ClassNotFoundException e){
            System.out.println("Ocorreu um erro de classe ao ler o arquivo.");
        }
        return lista;
    }


    public static void writeFileFilme(String file, List<Filme> lista) {
        File myFile = new File(String.format("files\\%s.dat",file));
        try {
            FileOutputStream myOutput = new FileOutputStream(myFile);
            ObjectOutputStream myObj = new ObjectOutputStream(myOutput);
            
            myObj.writeObject(lista);

            myObj.close();
            myOutput.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo.");
        }
    }
}
