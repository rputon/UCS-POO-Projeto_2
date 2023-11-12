package br.ucs.poo.cinema.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ucs.poo.cinema.filme.Filme;

import java.io.IOException;

import java.io.File;
import java.io.FileNotFoundException;
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
        try {
            File myFile = new File(String.format("files\\%s.txt", file));
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

    public static List<Filme> readFile(String file){
        List<Filme> lista = new ArrayList<>(); 
        try {
            File myFile = new File(String.format("files\\%s.txt", file));
			Scanner scanner = new Scanner(myFile);
                    
			while (scanner.hasNextLine()) {
				//lista.add(scanner.nextLine());
			}
			scanner.close();
            
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        return lista;
    }


    public static void addDatatoFile(String file, String dado) {
        try {
            File myFile = new File(String.format("files\\%s.txt",file));
            FileWriter myWriter = new FileWriter(myFile,true);
            myWriter.write(dado+"\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo.");
        }
    }




    /*public static void overWriteFile(String file, String dado, String typeData, int line){
        try{
            File myFile = new File(String.format("files\\%s.txt",file));
            FileWriter myWriter = new FileWriter(myFile,true);
            String myLine = Files.readAllLines(Paths.get(String.format("files\\%s.txt",file))).get(line);
            System.out.println(myLine);
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao reescrever no arquivo.");
        }

    }*/
}
