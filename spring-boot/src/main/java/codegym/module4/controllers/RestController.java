package codegym.module4.controllers;

import codegym.module4.entities.*;
import codegym.module4.repositories.*;
import codegym.module4.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*")
public class RestController
{
    @Autowired
    private TicketService ticketService;

    @Autowired
    private MovieSchedulesService movieSchedulesService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PointService pointService;

    @Autowired
    private PromotionService promotionService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private ShowRoomService showRoomService;

    @Autowired
    private ShowTimeService showTimeService;

    @Autowired
    private TicketPricesService ticketPricesService;

    @Autowired
    private RowService rowService;

    @GetMapping(path = "tickets", produces = "application/json")
    public List<Ticket> getAllTickets()
    {
        return ticketService.findAll();
    }

    @GetMapping(path = "movie-schedules", produces = "application/json")
    public List<MovieSchedules> getAllMovieSchedules()
    {
        return movieSchedulesService.findAll();
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
        return userService.findAll();
    }

    @GetMapping(path = "customers",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAllCustomers(){
        return customerService.findAll();
    }

    @GetMapping(path = "points",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Point> getAllPoints(){
        return pointService.findAll();
    }

    @GetMapping(path = "promotions",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Promotion> getAllPromotions(){
        return promotionService.findAll();
    }

    @GetMapping(path = "roles",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Role> getAllRoles(){
        return roleService.findAll();
    }

    @GetMapping(path = "seats",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Seat> getAllSeats(){
        return seatService.findAll();
    }

    @GetMapping(path = "show-rooms",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShowRoom> getAllShowRooms(){
        return showRoomService.findAll();
    }

    @GetMapping(path = "show-times",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShowTime> getAllShowTimes(){
        return showTimeService.findAll();
    }

    @GetMapping(path = "ticket-prices",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TicketPrices> getAllTicketPrices(){
        return ticketPricesService.findAll();
    }

    @GetMapping(path="rows",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Row> getAllRows(){
        return rowService.findAll();
    }

}