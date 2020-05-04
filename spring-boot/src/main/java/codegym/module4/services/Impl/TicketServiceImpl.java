package codegym.module4.services.Impl;

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
    public Ticket findById(int id)
    {
        return ticketRepo.findById(id).orElse(null);
    }

}