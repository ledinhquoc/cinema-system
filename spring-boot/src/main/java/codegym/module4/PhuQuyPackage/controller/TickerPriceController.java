package codegym.module4.PhuQuyPackage.controller;

import codegym.module4.PhuQuyPackage.model.TicketPrice;
import codegym.module4.PhuQuyPackage.service.impl.TicketPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TickerPriceController {
    private TicketPriceService ticketPriceService;

    @Autowired
    public TickerPriceController(TicketPriceService ticketPriceService) {
        this.ticketPriceService = ticketPriceService;
    }

    @RequestMapping(value = "/ticketPrice", method = RequestMethod.GET)
    public ResponseEntity<List<TicketPrice>> findAllTicketPrice() {
        List<TicketPrice> ticketPrices = ticketPriceService.findAllTicketPrice();
        if (ticketPrices.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPrices, HttpStatus.OK);
    }

    @RequestMapping(value = "/ticketPrice/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketPrice> getProductById(
            @PathVariable("id") Integer id) {
        Optional<TicketPrice> ticketPrice = ticketPriceService.findById(id);
        if (!ticketPrice.isPresent()) {
            return new ResponseEntity<>(ticketPrice.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPrice.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/ticketPrice", method = RequestMethod.POST)
    public ResponseEntity<TicketPrice> createTicketPrice(
            @RequestBody TicketPrice ticket,
            UriComponentsBuilder builder) {
        ticketPriceService.save(ticket);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/products/{id}")
                .buildAndExpand(ticket.getId()).toUri());
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/ticketPrice/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TicketPrice> updateProduct(
            @PathVariable("id") Integer id,
            @RequestBody TicketPrice ticket) {
        Optional<TicketPrice> currentTicketPrice = ticketPriceService
                .findById(id);

        if (!currentTicketPrice.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        currentTicketPrice.get().setId(ticket.getId());
        currentTicketPrice.get().setTicket_type(ticket.getTicket_type());
        currentTicketPrice.get().setShow_time(ticket.getShow_time());
        currentTicketPrice.get().setThu246gt(ticket.getThu246gt());
        currentTicketPrice.get().setThu246gv(ticket.getThu246gv());
        currentTicketPrice.get().setThu246gd(ticket.getThu246gd());
        currentTicketPrice.get().setThu3gt(ticket.getThu3gt());
        currentTicketPrice.get().setThu3gv(ticket.getThu3gv());
        currentTicketPrice.get().setThu3gd(ticket.getThu3gd());
        currentTicketPrice.get().setThu67CNgt(ticket.getThu67CNgt());
        currentTicketPrice.get().setThu67CNgv(ticket.getThu67CNgv());
        currentTicketPrice.get().setThu67CNgd(ticket.getThu67CNgd());
        ticketPriceService.save(currentTicketPrice.get());
        return new ResponseEntity<>(currentTicketPrice.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/ticketPrice/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<TicketPrice> deleteTicketPrice(
            @PathVariable("id") Integer id) {
        Optional<TicketPrice> ticketPrice = ticketPriceService.findById(id);
        if (!ticketPrice.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ticketPriceService.remove(ticketPrice.get());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
