package codegym.module4.services;

import codegym.module4.entities.TicketPrice;

import java.util.List;
import java.util.Optional;

public interface TicketPriceService {
    List<TicketPrice> findAllTicketPrice();
    Optional<TicketPrice> findById(Integer id);
    void save(TicketPrice ticketPrice);
    void remove(TicketPrice ticketPrice);
}
