package codegym.module4.services;

import codegym.module4.entities.Customer;
import codegym.module4.entities.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> findAll();
    List<Ticket>findByCustomerAndOrderStatus(Customer customer, String status);
}