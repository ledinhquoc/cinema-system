package codegym.module4.PhuQuyPackage.service.impl;

import codegym.module4.PhuQuyPackage.model.TicketPrice;

import java.util.List;
import java.util.Optional;

public interface TicketPriceService {
    List<TicketPrice> findAllTicketPrice();
    Optional<TicketPrice> findById(long ticket_price_id);
    void save(TicketPrice ticket);
    void remove(TicketPrice ticket);
}
