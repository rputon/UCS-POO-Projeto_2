package br.ucs.poo.cinema.main;

import java.util.Date;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import br.ucs.poo.cinema.cinema.Cinema;
import br.ucs.poo.cinema.cinema.Horario;
import br.ucs.poo.cinema.cinema.Sala;

public class HelpHorario {
    Help h = new Help();

    @Deprecated
    public Date testData(Scanner in, Cinema cine) {
        Date ld = h.returnDate(in, "Digite a data da sessão(dd/mm/yyyy):");
        return ld;
    }

    public LocalTime testHorario(Scanner in, Cinema cine, int timeMin, List<Horario> horas) {
        boolean test = false;
        LocalTime lt;
        do {
            lt = h.returnTime(in, "Digite a hora da sessão:(hh:mm)", timeMin);

            if (horas == null || horas.isEmpty()) {
                test = true;
                return lt;
            } else {
                for (Horario hora : horas) {
                    if (lt.isAfter(hora.getHora()) && lt.plusMinutes(timeMin)
                            .isBefore(hora.getHora().plusMinutes(timeMin))) {
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

    public Horario addHorario(Scanner in, Cinema cine, int timeMin, List<Horario> horas, Sala sala) {
        Date data = testData(in, cine);
        LocalTime time = testHorario(in, cine, timeMin, horas);
        Horario hora = new Horario(data, time, sala);
        return hora;
    }

}
