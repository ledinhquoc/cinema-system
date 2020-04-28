package codegym.module4.services.Impl;

import codegym.module4.entities.TicketPrice;
import codegym.module4.repositories.TicketPriceRepo;
import codegym.module4.services.TicketPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketPriceServiceImpl implements TicketPriceService {
    @Autowired
    TicketPriceRepo ticketPriceRepo;
    @Override
    public List<TicketPrice> findAllTicketPrice() {
        return (List<TicketPrice>) ticketPriceRepo.findAll();
    }

    @Override
    public Optional<TicketPrice> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(TicketPrice ticketPrice) {

    }

    @Override
    public void remove(TicketPrice ticketPrice) {

    }
}
