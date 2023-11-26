package br.ucs.poo.cinema.main;

import java.util.Collections;
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

    public void addSala(Scanner in, Cinema cine){
        boolean test = false;
        int nSala;
        do{
            nSala = h.returnInt(in, "Digite o número da sala:");
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
                cine.setSala(nSala, fileira, numero);
                test = true;
            } 
        }while(test == false);
        
        Collections.sort(cine.getSalas(), new SortSala());
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
    }

    public void formatAssentos(Cinema cine, Sala sala){
        int lengthX = sala.getAssento(sala.getAssentos().size()-1).getNumero();
        int lengthY = sala.getAssentos().size()/lengthX;

        StringBuilder formatBuilder = new StringBuilder();
        int index = 0;
        for(int y=0;y<lengthY+1;y++){
            for(int x=0;x<lengthX+1;x++){
                if(y==0 && x==0){
                    formatBuilder.append(String.format("%-3s", " "));
                } else if(y == 0 && x!=0){
                    formatBuilder.append(String.format("%-3d", x));
                } else if (y != 0 && x == 0){
                    formatBuilder.append(String.format("%-3s",Character.toString('A'+y-1)));
                } else{
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

        System.out.println(formatBuilder);
    }

    public void selectAssento(String select){

    }
    
}
