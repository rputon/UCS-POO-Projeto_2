package br.ucs.poo.cinema.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.filme.Filme;
import br.ucs.poo.cinema.main.Help;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class acessaArquivo {

    public static List<Filme> readFileFilme(String file){
        List<Filme> lista = new ArrayList<>(); 
        File myFile = new File(String.format("files/%s.dat", file));
        
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
        File myFile = new File(String.format("files/%s.dat",file));
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

    public static void validFile(String file) {
        try {
            File myFile = new File(String.format("files/%s.dat", file));
            if (myFile.createNewFile()) {
                System.out.println(String.format("Arquivo de %s criado: %s", file, myFile.getPath()));
            } else {
                System.out.println("Consultando dados...");
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao validar o arquivo.");
        }
    }

    /*public static List<Cliente> readFile(String file) {
        List<Cliente> lista = new ArrayList<>();
        try {
            File myFile = new File(String.format("files\\%s.csv", file));
            Scanner scanner = new Scanner(myFile);

            while (scanner.hasNextLine()) {
                int id = -1, telefone = -1, idade = -1;
                String nome = "";

                //String temp = scanner.nextLine();

                //id = Integer.parseInt(scanner.nextLine());
                //nome = scanner.nextLine();
                //telefone = Integer.parseInt(scanner.nextLine());
                //idade = Integer.parseInt(scanner.nextLine());



                lista.add(new Cliente(id, nome, telefone, idade));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo.");
        }
        return lista;
    }*/

    /*public static void addDatatoFile(String file, String dado) {
        try {
            File myFile = new File(String.format("files\\%s.csv", file));
            FileWriter myWriter = new FileWriter(myFile, true);
            myWriter.write(dado + "\n");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo.");
        }
    }*/

    // public static void overWriteFile(String file, String dado, String typeData,
    // int line) {
    // try {
    // File myFile = new File(String.format("files\\%s.txt", file));
    // FileWriter myWriter = new FileWriter(myFile, true);
    // String myLine = Files.readAllLines(Paths.get(String.format("files\\%s.txt",
    // file))).get(line);
    // System.out.println(myLine);
    // myWriter.write(dado, line, dado.length());
    // myWriter.close();
    // } catch (IOException e) {
    // System.out.println("Ocorreu um erro ao reescrever no arquivo.");
    // }
    // }

    /*public static void overWriteFile(String file, List<Cliente> cliente) {
        try {
            FileOutputStream writeFile = new FileOutputStream(new File(String.format("files\\%s.csv", file)));
            BufferedWriter writeObject = new BufferedWriter(
                    new OutputStreamWriter(writeFile, Charset.forName("UTF-8")));
            for (int i = 0; i < cliente.size(); i++) {
                writeObject.write(cliente.get(i).toString(0));
            }
            writeObject.close();
            writeFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) {
        Help h = new Help();

        Cinema cine = new Cinema();

        validFile("filmes");
        int hash = cine.getFilmes().hashCode();
        List<Filme> myList = new ArrayList<Filme>(readFileFilme("filme"));
        if(myList.size()>0){
            cine.setFilme(myList);
        }

        Scanner in = new Scanner(System.in);
        String nome, descricao, genero;
        
        int ano, timeMin, rating;

        nome = h.returnString(in, "Digite o nome do filme:");
        ano = h.returnInt(in, "Digite o ano de publica��o do filme:");
        timeMin = h.returnInt(in, "Digite a dura��o do filme, em minutos: ");
        descricao = h.returnString(in, "Digite a descri��o do filme:");
        rating = h.returnInt(in, "Digite a classifica��o indicativa do filme:");
        genero = h.returnString(in, "Digite o g�nero do filme:");
        
        cine.setFilme(nome, ano, timeMin, descricao, rating, genero);

        writeFileFilme("filmes", cine.getFilmes());
        if(cine.getFilmes().hashCode() != hash){
            
            myList = readFileFilme("filmes");
            System.out.println(myList);
        }
        
    }
}
