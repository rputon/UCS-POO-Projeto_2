package br.ucs.poo.cinema.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class acessaArquivo{

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

    public static List<Cliente> readFile(String file){
        List<Cliente> lista = new ArrayList<>(); 
        try {
            File myFile = new File(String.format("files\\%s.txt", file));
			Scanner scanner = new Scanner(myFile);
                    
			while (scanner.hasNextLine()) {
                int id = -1, telefone = -1, idade = -1;
                String nome = "";

                id = Integer.parseInt(scanner.nextLine());
                nome = scanner.nextLine();
                telefone = Integer.parseInt(scanner.nextLine());
                idade = Integer.parseInt(scanner.nextLine());

				lista.add(new Cliente(id, nome, telefone, idade));
			}
			scanner.close(); 
		} catch (FileNotFoundException e) {
			System.out.println("Ocorreu um erro ao ler o arquivo.");
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

    public static void overWriteFile(String file, String dado, String typeData, int line){
        try{
            File myFile = new File(String.format("files\\%s.txt",file));
            FileWriter myWriter = new FileWriter(myFile,true);
            String myLine = Files.readAllLines(Paths.get(String.format("files\\%s.txt",file))).get(line);
            System.out.println(myLine);
            myWriter.write(dado, line, dado.length());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao reescrever no arquivo.");
        }
    }

    public static void teste(String file, List<Cliente> cliente){
        try {
            File myFile = new File(String.format("files\\%s.txt",file));
            FileOutputStream writeFile = new FileOutputStream(myFile);
            BufferedWriter writeObject = new BufferedWriter(new OutputStreamWriter(writeFile, Charset.forName("UTF-8") ) );
            for (int i=0; i < cliente.size();i++){
                writeObject.write(cliente.get(i).toString());
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        validFile("cliente");
        List<Cliente> myList = new ArrayList<Cliente>(readFile("cliente"));
        System.out.println(myList);
        myList.set(0, new Cliente(2,"Paulo",981061825,30));
        teste("cliente", myList);
        myList = readFile("cliente");
        System.out.println(myList);
    }
}