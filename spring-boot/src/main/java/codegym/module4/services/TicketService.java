package codegym.module4.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import codegym.module4.entities.Ticket;

public interface TicketService {
    // @Query(value = "select * from tickets")
    List<Ticket> findAll();

    // Ticket findById(int id);
}