package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket ticket1 = new Ticket(1, 10000, "LED", "ATH", 90);
    Ticket ticket2 = new Ticket(2, 12500, "DME", "BHK", 155);
    Ticket ticket3 = new Ticket(3, 12700, "KZN", "DXB", 120);
    Ticket ticket4 = new Ticket(4, 5500, "LED", "KZN", 100);
    Ticket ticket5 = new Ticket(5, 4300, "DME", "KGD", 90);
    Ticket ticket6 = new Ticket(6, 7900, "LED", "CFU", 360);
    Ticket ticket7 = new Ticket(7, 6790, "DME", "GOJ", 250);
    Ticket ticket8 = new Ticket(8, 3520, "LED", "ATH", 90);
    Ticket ticket9 = new Ticket(9, 19000, "DME", "SSH", 190);
    Ticket ticket10 = new Ticket(10, 27000, "KZN", "TLV", 530);

    @Test
    public void shouldSearchTicketAndSort() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket8, ticket1};
        Ticket[] actual = manager.searchBy("LED", "ATH");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchNonExistingTicket() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("CFU", "LED");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTicket() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket10};
        Ticket[] actual = manager.searchBy("KZN", "TLV");
        assertArrayEquals(expected, actual);
    }

}