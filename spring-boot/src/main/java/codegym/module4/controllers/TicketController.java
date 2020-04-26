package codegym.module4.controllers;


import codegym.module4.entities.Customer;

import codegym.module4.entities.Ticket;

import codegym.module4.services.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(TicketController.BASE_URL)
public class TicketController {

    public static final String BASE_URL = "/api/v1/ticket";
    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}/{status}")
    public List<Ticket> getPointDetails(@PathVariable Customer id,@PathVariable String status) {

        return ticketService.findByCustomerAndOrderStatus(id,status);
    }

}
