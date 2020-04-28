package codegym.module4.PhuQuyPackage.service.impl;

import codegym.module4.PhuQuyPackage.model.TicketPrice;
import codegym.module4.PhuQuyPackage.repository.TicketPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TicketPriceServiceImpl implements TicketPriceService {
    private TicketPriceRepository ticketPriceRepository;
    @Autowired
    public TicketPriceServiceImpl(TicketPriceRepository ticketPriceRepository)  {
        this.ticketPriceRepository = ticketPriceRepository;
    }
    @Override
    public List<TicketPrice> findAllTicketPrice() {
        return (List<TicketPrice>) ticketPriceRepository.findAll();
    }

    @Override
    public Optional<TicketPrice> findById(long ticket_price_id) {
        return ticketPriceRepository.findById(ticket_price_id);
    }

    @Override
    public void save(TicketPrice ticket) {
        ticketPriceRepository.save(ticket);
    }

    @Override
    public void remove(TicketPrice ticket) {
        ticketPriceRepository.delete(ticket);
    }
}
