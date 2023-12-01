package br.ucs.poo.cinema.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.cinema.Sala;
import br.ucs.poo.cinema.cinema.SortSala;

public class HelpSala {
    private String erro = "Valor informado é inválido.";
    Help h = new Help();

    public char returnFileira(Scanner in, String print){
        char fileira = 'A';
        boolean test = false;

        do {
            try {
                System.out.println("Digite o valor da última fileira:");
                fileira = Character.toUpperCase(in.next().charAt(0));
                in.nextLine();

                if ((fileira >= 'A' || fileira <= 'Z') && !(Character.toString(fileira)).matches(".*\\d.*") && !(Character.toString(fileira)).matches(".*[-!@#$%^&´~*()\\[\\]+=<>?/{}|].*")) {
                    test = true;
                    break;
                } 
                else{
                    System.out.println(erro + " Digite uma letra válida");
                }
            } catch (Exception e) {
                System.out.println(erro + " Digite uma letra válida");
                in.next();
            }
        } while (test == false);
        return fileira;
    }

    public int searchSala(Cinema cine, Integer nSala){
        int retorno = -1;

        for(int index=0;index<cine.getSalas().size();index++){
            if(cine.getSalas().size() > 0 && cine.getSala(index).getNumero() == nSala){
                return index;
            }
        }
        return retorno;
    }

    public Sala addSala(Scanner in, Cinema cine){
        boolean test = false;
        int nSala;
        Sala sala = null;

        do{
            nSala = h.returnInt(in, "Digite o número da sala:",1,50);
            int index = searchSala(cine, nSala);
            if(index != -1){
                char sn = h.returnChar(in, "Esta sala já existe, deseja editar ela? S - sim, N - não");
                if(sn == 'S'){
                    editSala(in, cine, index);
                    test = true;
                    break;
                } else{
                    System.out.println("Não é possível adicionar uma sala com o mesmo número.");
                }
            } else{
                char fileira = returnFileira(in, "Digite o valor da última fileira:");
                int numero = h.returnInt(in, "Digite o valor da última coluna:");
                sala = new Sala(nSala, fileira, numero);
                saveFilme(cine, sala);
                test = true;
                return sala;
            } 
        }while(test == false);
        
        Collections.sort(cine.getSalas(), new SortSala());
        saveFilme(cine, sala);
        return cine.getSala(nSala);
    }

    public void editSala(Scanner in, Cinema cine, int index){
        Sala sala = new Sala(0, 'A', 0);
        int nSala;

        boolean test = false;

        if(index == -1){
            do{
                nSala = h.returnInt(in,"Digite o número da sala:");
                index = searchSala(cine, nSala);
                if(index > -1){
                    sala = cine.getSala(index);
                    test = true;
                    break;
                }else{
                    System.out.println("Sala não encontrada");
                }
            } while(test == false);
        } else {
            sala = cine.getSala(index);
        }

        test = false;

        do{
            System.out.println(sala);
            int option = h.returnInt(in, "1 - Alterar número da sala \n2 - Alterar quantidade de assentos \nDigite 0 para cancelar", 0, 2);
            System.out.println(option);
            switch (option) {
                case 0:
                    test = true;
                    break;
                case 1:
                    int n = h.returnInt(in, "Digite o número da sala:");
                    sala.setNumero(n);
                    break;
                case 2:
                    char fileira = returnFileira(in, "Digite o valor da última fileira:");
                    int numero = h.returnInt(in, "Digite o valor da última coluna:");
                    sala.setAssentos(fileira, numero);
                    break;
                default:
                    System.out.println(erro);
                    break;
            }
        }while (test == false);

        Collections.sort(cine.getSalas(), new SortSala());
        saveFilme(cine, sala);
    }

    public void removeSala(Scanner in, Cinema cine, int index){
        int nSala;

        boolean test = false;

        if(index == -1){
            do{
                nSala = h.returnInt(in,"Digite o número da sala:");
                index = searchSala(cine, nSala);
                if(index > -1){
                    test = true;
                    break;
                }else{
                    System.out.println("Sala não encontrada");
                }
            } while(test == false);
        }

        char sn = h.returnChar(in, "Tem certeza que deseja excluir a " + cine.getSala(index) + "?");
        if(sn == 'S'){
            cine.removeSala(index);
            System.out.println("Sala apagada");
        }
        saveFilme(cine, cine.getSala(index));
    }

    public String formatAssentos(Cinema cine, Sala sala){
        int size = sala.assentoTam();
        int lengthY = sala.getAssento(size-1).getFileira();
        int lengthX = size/(lengthY-64);
        
        System.out.println(size);
        StringBuilder formatBuilder = new StringBuilder();
        int index = 0;
        for(int y=0;y<lengthY-63;y++){
            for(int x=0;x<lengthX+1;x++){
                if(y==0 && x==0){
                    formatBuilder.append(String.format("%-3s", " "));
                } else if(y == 0 && x!=0){
                    formatBuilder.append(String.format("%-3d", x));
                } else if (y != 0 && x == 0){
                    formatBuilder.append(String.format("%-3s",Character.toString('A'+y-1)));
                } else if(index<sala.assentoTam()){
                    if(sala.getAssento(index).getReserva()){
                        formatBuilder.append(String.format("%-3s","X" ));
                    } else{
                        formatBuilder.append(String.format("%-3s","O"));
                    }
                    index += 1;
                }
            }
            formatBuilder.append("\n");
        }


        StringBuilder s = new StringBuilder();

        if(lengthX%2 == 0){
            s.append("%").append(4+((lengthX/2)*3)).append("s");
        }
        else{
            s.append("%").append(4+((lengthX/2)*3)+2).append("s");
        }
        String str = s.toString();
        formatBuilder.append(String.format(str, "TELA"));

        return formatBuilder.toString();
    }

    public void selectAssento(String select){
        //TODO: selecionar assento p compra do ingresso
    }
    
    public void saveFilme(Cinema cine, Sala sala) {
        cine.setSala(sala);
        writeSala(cine.getSalas());
    }

    public void writeSala(List<Sala> list) {
        File myFile = new File("files/salas.dat");
        try {
            FileOutputStream myOutput = new FileOutputStream(myFile);
            ObjectOutputStream myObj = new ObjectOutputStream(myOutput);

            myObj.writeObject(list);

            myObj.close();
            myOutput.close();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo salas");
        }
    }

    @SuppressWarnings("unchecked")
    public List<Sala> readSala() {
        List<Sala> list = new ArrayList<Sala>();
        File myFile = new File("files/salas.dat");

        try {
            FileInputStream myInput = new FileInputStream(myFile);
            ObjectInputStream myObj = new ObjectInputStream(myInput);

            Object obj = myObj.readObject();
            list = (List<Sala>) obj;

            myObj.close();
            myInput.close();

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo salas");
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println("Ocorreu um erro de classe ao ler o arquivo salas");
        }
        return list;
    }


}
