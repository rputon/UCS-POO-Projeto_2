package br.ucs.poo.cinema.cinema;

import java.util.Comparator;

public class SortSala implements Comparator<Sala>{
    public int compare(Sala one, Sala two) {
        Integer n1 = one.getNumero();
        Integer n2 = two.getNumero();
        
        return n1.compareTo(n2);
    }
}
