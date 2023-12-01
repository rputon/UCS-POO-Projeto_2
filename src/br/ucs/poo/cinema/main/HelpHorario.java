package br.ucs.poo.cinema.main;

import java.util.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.cinema.Horario;
import br.ucs.poo.cinema.filme.Filme;

public class HelpHorario {
    Help h = new Help();

    @Deprecated
    public Date testData(Scanner in, Cinema cine) {
        Date ld = h.returnDate(in, "Digite a data da sessão:");
        return ld;
    }

    public LocalTime testHorario(Scanner in, Cinema cine, Filme filme) {
        boolean test = false;
        LocalTime lt;
        do {
            lt = h.returnTime(in, "Digite a hora da sessão:", filme.getTimeMin());
            
            if (filme.getHorarios() == null || filme.getHorarios().isEmpty()) {
                test = true;
                return lt;
            } else {
                for (Horario hora : filme.getHorarios()) {
                    if (lt.isAfter(hora.getHora()) && lt.plusMinutes(filme.getTimeMin())
                            .isBefore(hora.getHora().plusMinutes(filme.getTimeMin()))) {
                        System.out.println("Valor inválido");
                    } else {
                        test = true;
                        return lt;
                    }
                }
            }
        } while (test == false);

        return lt;
    }

    public Horario addHorario(Scanner in, Cinema cine, int timeMin, List<Horario> horas) {
        Horario hora = new Horario(null, null);

        // (testData(in, cine), testHorario(in, cine, timeMin));
        return hora;
    }

}
