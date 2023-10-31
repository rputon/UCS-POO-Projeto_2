package br.ucs.poo.cinema.teste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        List<Cliente> cliente = new ArrayList<Cliente>();
        List<Cliente> cliente2 = new ArrayList<Cliente>();
        cliente.add(0, new Cliente(1,"Roberta",981621905,20));
        cliente.add(1, new Cliente(3,"Andre",981622345,67));
        cliente.add(2, new Cliente(5,"Carlos",981626405,23));
        cliente.add(3, new Cliente(2,"Paula",981253605,43));
        
        cliente.add(0, new Cliente(7,"Luiz",981650973,83));
        cliente.remove(3);
        for (int i=0;i<cliente.size();i++){
            System.out.println(cliente.get(i));
        }

        cliente2.addAll(0,cliente);
        Collections.sort(cliente2, new Sortbyname());

        

        System.out.println("--------------");

        for (int i=0;i<cliente2.size();i++){
            System.out.println(cliente2.get(i));
        }
    }
}
