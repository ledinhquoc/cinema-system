package codegym.module4.services;

import codegym.module4.entities.Customer;
import codegym.module4.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> findAll();

    Ticket findById(int id);


    Optional<Ticket> findById(Integer id);

    List<Ticket>findByCustomerAndOrderStatus(Customer customer, String status);
    Ticket Creat(Ticket ticket);

}