package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] findAll() {
        return repo.findAll();
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;

                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;

    }


    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getDepartureAirport().contains(from) && ticket.getArrivalAirport().contains(to)) {
            return true;
        } else {
            return false;
        }
    }
}
