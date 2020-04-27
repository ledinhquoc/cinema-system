package codegym.module4.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import codegym.module4.entities.Ticket;
import codegym.module4.repositories.TicketRepo;
import codegym.module4.services.TicketService;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepo ticketRepo;

    @Override
    public List<Ticket> findAll() {
        return ticketRepo.findAll();
    }

}