package codegym.module4.services;

import codegym.module4.entities.Customer;
import codegym.module4.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {
    List<Ticket> findAll();
<<<<<<< HEAD
    Optional<Ticket> findById(Integer id);
=======
    List<Ticket>findByCustomerAndOrderStatus(Customer customer, String status);
    Ticket Creat(Ticket ticket);
>>>>>>> 2a8d2bade39a72fe52976d9932427f70cf148e12
}