package codegym.module4.controllers;

import java.util.List;

import codegym.module4.entities.MovieSchedule;
import codegym.module4.services.MovieScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import codegym.module4.entities.Ticket;
import codegym.module4.services.TicketService;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*")
public class RestController {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private MovieScheduleService movieScheduleService;

    @GetMapping(path = "tickets", produces = "application/json")
    public List<Ticket> getAllTickets() {
        return ticketService.findAll();
    }

    @GetMapping(path = "movie-schedules",produces = "application/json")
    public List<MovieSchedule> getAllMovieSchedules(){
        return movieScheduleService.findAll();
    }
}