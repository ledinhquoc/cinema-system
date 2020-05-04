package codegym.module4.services;

import codegym.module4.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> findAll();
    Optional<Ticket> findById(Integer id);
}