package codegym.module4.controllers;


import codegym.module4.entities.Customer;
import codegym.module4.entities.Ticket;
import codegym.module4.services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(TicketController.BASE_URL)
public class TicketController {


    public static final String BASE_URL = "/api/v1/ticket";


    private final TicketService ticketService;


    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @GetMapping(path = "/{id}/{status}")
    public List<Ticket> getPointDetails(@PathVariable Customer id, @PathVariable String status) {
        return ticketService.findByCustomerAndOrderStatus(id,status);
    }


    @PostMapping(value="/new")
    public Ticket newTicket(@RequestBody Ticket ticket)
    {
        return ticketService.Creat(ticket);
    }

    @RequestMapping(value="/new1", method= RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE}, produces = { MediaType.APPLICATION_JSON_VALUE})
    public HttpStatus addTheatre(@RequestBody Ticket ticket ) {
        ticketService.Creat(ticket);
        return HttpStatus.OK;

    }

}
