package br.ucs.poo.cinema.main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import br.ucs.poo.cinema.cinema.Cinema;

public class HelpHorario {
    Help h = new Help();

    public void testData(Scanner in, Cinema cine){
        LocalDate ld = h.returnDate(in, "Digite a data da sessão:");
        System.out.println(ld);
    }

    public void testHorario(Scanner in, Cinema cine, int timeMin){
        LocalTime lt = h.returnTime(in, "Digite a hora da sessão:", timeMin);
        System.out.println(lt);
    }
}
