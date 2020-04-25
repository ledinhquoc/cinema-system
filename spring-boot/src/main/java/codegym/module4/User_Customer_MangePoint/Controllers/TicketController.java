//package codegym.module4.QuocVietPackage.Controllers;
//
//
//import codegym.module4.QuocVietPackage.Entities.ticket;
//import codegym.module4.QuocVietPackage.Entities.customer;
//import codegym.module4.QuocVietPackage.Services.ticketService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping(TicketController.BASE_URL)
//public class TicketController {
//
//
//    public static final String BASE_URL = "/api/v1/tickes";
//    private final ticketService ticketService;
//
//    public TicketController(ticketService ticketService) {
//        this.ticketService = ticketService;
//    }
//
//    @GetMapping("/{id}/{status}")
//    public List<ticket> getTicket(@PathVariable customer id, @PathVariable String status) {
//
//        return ticketService.StatusTicket(id,status);
//    }
//
//
//}
