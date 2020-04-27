package codegym.module4.services.impl;

import codegym.module4.entities.Customer;
import codegym.module4.entities.Ticket;

import codegym.module4.repositories.TicketRepository;
import codegym.module4.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Override
    public List<Ticket> findByCustomerAndOrderStatus(Customer customer,String status) {
        return ticketRepository.findByCustomerAndOrderStatus(customer,status);
    }
}
