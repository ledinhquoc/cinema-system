package codegym.module4.services;

import codegym.module4.entities.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAll();
    Ticket findById(int id);
}