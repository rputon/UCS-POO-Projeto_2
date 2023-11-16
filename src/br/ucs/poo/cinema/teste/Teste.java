package br.ucs.poo.cinema.teste;

import java.util.Scanner;

import br.ucs.poo.cinema.main.Help;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//mport java.util.Comparator;
//import java.util.List;

public class Teste {
    public static void main(String[] args) {
        
        //List<Cliente> cliente = new ArrayList<Cliente>();
        //List<Cliente> cliente2 = new ArrayList<Cliente>();

        //String [] vetor = {"Phil", "Mary", "Betty", "Bob", "Tom", "Casey", "Claire"};
        //List<String> nomes = Arrays.asList(vetor);

        //cliente.add(0, new Cliente(1,"Roberta",981621905,20));
        //cliente.add(1, new Cliente(3,"Andre",981622345,67));
        //cliente.add(2, new Cliente(5,"Carlos",981626405,23));
        //cliente.add(3, new Cliente(2,"Paula",981253605,43));
        
        //cliente.add(0, new Cliente(7,"Luiz",981650973,83));
        //cliente.remove(3);
        //for (int i=0;i<cliente.size();i++){
        //    System.out.println(cliente.get(i));
        //}

        //cliente2.addAll(0,cliente);
        //Collections.sort(cliente2, new Sortbyname());

        

        //System.out.println("--------------");

        //for (int i=0;i<cliente2.size();i++){
        //    System.out.println(cliente2.get(i));
        //}

        /*System.out.println("-----------Random number ------------");
        for (int i=0;i<5;i++){

            int id = (int) Math.floor(Math.random() * (99 - 1 + 1) + 1);
            int telefone = (int) Math.floor(Math.random() *(999999999-900000000 +1)+ 900000000);
            int idade = (int) Math.floor(Math.random() * (100 - 16 +1)+16);
            Collections.shuffle(nomes);

            cliente.add(i, new Cliente(id,nomes.get(0),telefone,idade));
        }

        for (int i=0;i<cliente.size();i++){
            System.out.println(cliente.get(i));
        }

        System.out.println("----------- Reverse ------------");

        Collections.sort(cliente, Collections.reverseOrder(new Sortbyname()));

        for (int i=0;i<cliente.size();i++){
            System.out.println(cliente.get(i));
        }*/
          

        Help help = new Help();

        String teste = "";
        Scanner in = new Scanner(System.in);
        do{
            teste = help.returnString(in, "Teste: ");
        }while (teste != "0");

    }
}
