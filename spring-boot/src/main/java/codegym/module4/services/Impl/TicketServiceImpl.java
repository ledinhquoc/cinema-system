package codegym.module4.services.Impl;

import codegym.module4.entities.Customer;
import codegym.module4.entities.Ticket;
import codegym.module4.repositories.TicketRepo;
import codegym.module4.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public List<Ticket> findAll() {
        return ticketRepo.findAll();
    }

    @Override
    public List<Ticket> findByCustomerAndOrderStatus(Customer customer, String status) {
        return ticketRepo.findByCustomerAndOrderStatus(customer,status);
    }

    @Override
    public Ticket Creat(Ticket ticket) {
        return ticketRepo.save(ticket);
    }

}