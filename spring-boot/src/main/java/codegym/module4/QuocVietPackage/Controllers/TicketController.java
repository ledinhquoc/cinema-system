package codegym.module4.QuocVietPackage.Controllers;


import codegym.module4.QuocVietPackage.Entities.point;
import codegym.module4.QuocVietPackage.Entities.ticket;
import codegym.module4.QuocVietPackage.Entities.user;
import codegym.module4.QuocVietPackage.Services.pointService;
import codegym.module4.QuocVietPackage.Services.ticketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(TicketController.BASE_URL)
public class TicketController {


    public static final String BASE_URL = "/api/v1/tickes";
    private final ticketService ticketService;

    public TicketController(ticketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/{id}/{status}")
    public List<ticket> getTicket(@PathVariable user id, @PathVariable String status) {

        return ticketService.StatusTicket(id,status);
    }


}
