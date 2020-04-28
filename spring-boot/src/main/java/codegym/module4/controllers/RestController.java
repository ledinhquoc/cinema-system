package codegym.module4.controllers;

import codegym.module4.entities.*;
import codegym.module4.repositories.*;
import codegym.module4.repositories.ShowTimeRepo;
import codegym.module4.services.MovieScheduleService;
import codegym.module4.services.MovieService;
import codegym.module4.services.TicketPriceService;
import codegym.module4.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*")
public class RestController
{
    @Autowired
    private TicketService ticketService;

    @Autowired
    private MovieScheduleService movieScheduleService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private PointRepo pointRepo;

    @Autowired
    private PromotionRepo promotionRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private SeatRepo seatRepo;

    @Autowired
    private ShowRoomRepo showRoomRepo;

    @Autowired
    private ShowTimeRepo showTimeRepo;

    @Autowired
    private TicketPriceService ticketPriceService;
    @GetMapping(path = "tickets", produces = "application/json")
    public List<Ticket> getAllTickets()
    {
        return ticketService.findAll();
    }

    @GetMapping(path = "movie-schedules", produces = "application/json")
    public List<MovieSchedule> getAllMovieSchedules()
    {
        return movieScheduleService.findAll();
    }

    @GetMapping(path = "movies", produces = "application/json")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<>(movieService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "employees",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    @GetMapping(path = "users",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    @GetMapping(path = "customers",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAllCustomers(){
        return customerRepo.findAll();
    }

    @GetMapping(path = "points",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Point> getAllPoints(){
        return pointRepo.findAll();
    }

    @GetMapping(path = "promotions",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Promotion> getAllPromotions(){
        return promotionRepo.findAll();
    }

    @GetMapping(path = "roles",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Role> getAllRoles(){
        return roleRepo.findAll();
    }

    @GetMapping(path = "seats",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Seat> getAllSeats(){
        return seatRepo.findAll();
    }

    @GetMapping(path = "show-rooms",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShowRoom> getAllShowRooms(){
        return showRoomRepo.findAll();
    }

    @GetMapping(path = "show-times",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShowTime> getAllShowTimes(){
        return showTimeRepo.findAll();
    }

    @GetMapping(path = "ticket-prices",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TicketPrice> getAllTicketPrices(){
        return ticketPriceService.findAllTicketPrice();
    }
}
