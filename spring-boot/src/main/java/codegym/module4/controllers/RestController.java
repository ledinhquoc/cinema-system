package codegym.module4.controllers;

import codegym.module4.entities.*;
import codegym.module4.entities.validators.EmployeeValidator;
import codegym.module4.helpers.JsonConverter;
import codegym.module4.jwt.ERole;
import codegym.module4.repositories.EmployeeRepo;
import codegym.module4.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*")
public class RestController
{
    @Autowired
    private EmployeeService employeeService;
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

    @Autowired
    private EmployeeValidator employeeValidator;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JsonConverter jsonConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/tickets", produces = "application/json")
    public ResponseEntity<List<Ticket>> getAllTickets()

    {
        List<Ticket> tickets = ticketService.findAll();

        if (tickets.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping(value = "/tickets/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> getTicketById(
            @PathVariable("id") Integer id)
    {
        Optional<Ticket> ticket = ticketService.findById(id);

        if (!ticket.isPresent())
        {
            return new ResponseEntity<>(ticket.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticket.get(), HttpStatus.OK);
    }

    @GetMapping(path = "movie-schedules", produces = "application/json")
    public List<MovieSchedules> getAllMovieSchedules()
    {
        return movieSchedulesService.findAll();
    }

    @GetMapping(path = "movies", produces = "application/json")
    public ResponseEntity<List<Movie>> getAllMovies()
    {
        return new ResponseEntity<>(movieService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployees()
    {
        return employeeRepo.findAll();
    }


    @GetMapping(path = "users", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers()
    {
        return userService.findAll();

    }

    @GetMapping(path = "customers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAllCustomers()
    {
        return customerService.findAll();
    }

    @GetMapping(path = "points", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Point> getAllPoints()
    {
        return pointService.findAll();
    }

    @GetMapping(path = "promotions", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Promotion> getAllPromotions()
    {
        return promotionService.findAll();
    }

    @GetMapping(path = "roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Role> getAllRoles()
    {
        return roleService.findAll();
    }

    @GetMapping(path = "seats", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Seat> getAllSeats()
    {
        return seatService.findAll();
    }

    @GetMapping(path = "show-rooms", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShowRoom> getAllShowRooms()
    {
        return showRoomService.findAll();
    }

    @GetMapping(path = "show-times", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ShowTime> getAllShowTimes()
    {
        return showTimeService.findAll();
    }

    @GetMapping(path = "ticket-prices", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TicketPrices> getAllTicketPrices()
    {
        return ticketPricesService.findAll();
    }

    @GetMapping(path = "rows", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Row> getAllRows()
    {
        return rowService.findAll();
    }


//    @GetMapping(path = "tickets/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Ticket getTicketById(@PathVariable int id)
//    {
//        return ticketService.findById(id);
//    }

    @GetMapping(path = "show-rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ShowRoom getShowRoomById(@PathVariable int id)
    {
        return this.showRoomService.findById(id);
    }

    @GetMapping(path = "movies/movie-schedules/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getMovieByMovieSchedules(@PathVariable int id)
    {
        StoredProcedureQuery spQuery =
                entityManager.createNamedStoredProcedureQuery("GetMovieByMovieScheduleId");
        spQuery.setParameter("movieScheduleId", id);
        spQuery.execute();

        return new ArrayList<Movie>(spQuery.getResultList());
    }

    @GetMapping(path = "movie-schedules/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieSchedules getMovieSchedulesById(@PathVariable int id)
    {
        return movieSchedulesService.findById(id);
    }

    @GetMapping(path = "customers/ticket/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getCustomerByTicketToan(@PathVariable int id)
    {
        StoredProcedureQuery spQuery =
                entityManager.createNamedStoredProcedureQuery("GetCustomerByTicketId");
        spQuery.setParameter("ticketId", id);
        spQuery.execute();

        return new ArrayList<>(spQuery.getResultList());
    }

    @GetMapping(path = "rows/show-room/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Row> getRowsByShowRoomId(@PathVariable int id)
    {
        String sqlQuery = "select *\n" +
                "from _row\n" +
                "where _row.id in (\n" +
                "    select _row.id\n" +
                "    from _row\n" +
                "             inner join show_room sr on _row.show_room_id = sr.id and sr.id = " + id + "\n" +
                ");\n";
        Query query = entityManager.createNativeQuery(sqlQuery, Row.class);
        return new ArrayList<>(query.getResultList());
    }

    @GetMapping(path = "seats/row/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Seat> getSeatsByRowId(@PathVariable int id)
    {
        String sqlQuery = "    select *\n" +
                "    from seat\n" +
                "    where seat.id in (\n" +
                "        select seat.id\n" +
                "        from seat\n" +
                "                 inner join _row r on seat._row_id = r.id and r.id=" + id + "\n" +
                "    );\n";

        Query query = entityManager.createNativeQuery(sqlQuery, Seat.class);
        return new ArrayList<>(query.getResultList());
    }


    @PostMapping(path = "users/new", produces = MediaType.APPLICATION_JSON_VALUE)
    public User newUser(@RequestBody User user)
    {
        Role roleAdmin = roleService.findById(1);
        List<Role> roles = new ArrayList<>();
        roles.add(roleAdmin);
        user.setRoles(roles);

        return userService.save(user);
    }

    @GetMapping(path = "/roles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Role getRoleById(@PathVariable int id)
    {
        return roleService.findById(id);
    }

    @GetMapping(path = "tickets/empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public Ticket getEmptyTicket()
    {
        return new Ticket();
    }

    @GetMapping(path = "movie-schedules/empty", produces = MediaType.APPLICATION_JSON_VALUE)
    public MovieSchedules getEmptyMovieSchedule()
    {
        return new MovieSchedules();
    }

    @GetMapping(path = "movies/sold-tickets")
    public List statisticMoviesBySoldTickets()
    {
        Query query =
                entityManager
                        .createNativeQuery("call GetSoldTicketQuantitiesByMovie()");

        return query.getResultList();
    }

    @GetMapping(path = "customers/top")
    public List getTopCustomers()
    {
        Query query =
                entityManager.createNativeQuery("call GetTopMembers()");

        return query.getResultList();
    }

    @GetMapping(path = "movie-genres/top-sold")
    public List getMostWatchedMovieGenres()
    {
        Query query =
                entityManager.createNativeQuery("call GetMostWatchGenres");

        return query.getResultList();
    }

    @GetMapping(path = "show-times/top")
    public List getTopShowTimes()
    {
        Query query =
                entityManager.createNativeQuery("call GetTopShowTimes");

        return query.getResultList();
    }

    @GetMapping(path = "incomes/{year}")
    public List getIncomesByYear(@PathVariable String year)
    {
        Query query =
                entityManager
                        .createNativeQuery("call GetIncomeStatisticsByYear(:year)")
                        .setParameter("year", year);
        return query.getResultList();
    }

    @GetMapping(path = "income-years")
    public List getIncomeYears()
    {
        Query query =
                entityManager.createNativeQuery("call GetIncomeYears");
        return query.getResultList();
    }

    @GetMapping(path = "employees/new")
    public Employee getNewEmployee()
    {
        return new Employee();
    }

    @GetMapping(path = "employees/{id}")
    public Employee getEmployeeById(@PathVariable int id)
    {
        return employeeService.findById(id);
    }

    @GetMapping(path = "employees/check/user-name/{user-name}")
    public Boolean checkUniqueUsername(@PathVariable("user-name") String username)
    {
        Query query =
                entityManager
                        .createNativeQuery("call CheckUniqueUsername(:username)")
                        .setParameter("username", username);
        // stored procedure RETURN the numbers of employee have the given username
        return Integer.parseInt(query.getResultList().get(0).toString()) == 0;
    }

    @GetMapping(path = "employees/check/email/{email}")
    public Boolean checkUniqueEmail(@PathVariable("email") String email)
    {
        Query query =
                entityManager
                        .createNativeQuery("call CheckUniqueEmail(:email)")
                        .setParameter("email", email);

        return Integer.parseInt(query.getResultList().get(0).toString()) == 0;
    }

    @PostMapping(path = "employees/new/saved")
    public ResponseEntity<String> saveNewEmployee(@RequestBody Employee employee, BindingResult result)
    {
        employeeValidator.mode = EmployeeValidator.Mode.ADD;
        employeeValidator.validate(employee, result);
        User user=employee.getUsers();

        if (result.hasErrors())
        {
            result.getFieldErrors().forEach(fieldError ->
            {
                jsonConverter.addProperty(fieldError.getField(), fieldError.getCode());
            });
            return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.NOT_ACCEPTABLE);
        }

        Role roleEmp;
        Optional<Role> roleOptional = getAllRoles().stream()
                .filter(role -> role.getName().equals(ERole.ROLE_ADMIN)).findFirst();
        if (roleOptional.isPresent())
        {
            roleEmp = roleOptional.get();
        } else
        {
            Role newRoleEmp = new Role();
            newRoleEmp.setName(ERole.ROLE_ADMIN);
            roleEmp = roleService.save(newRoleEmp);
        }

        user.setRoles(Collections.singletonList(roleEmp));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);

        if (employeeService.save(employee) != null)
        {
            jsonConverter.addProperty("addOke", true);
            return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.CREATED);
        }

        jsonConverter.addProperty("backEndError", true);
        return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(path = "employees/edit/saved", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<String> saveEditedEmployee(@RequestBody Employee employee, BindingResult result)
    {
        employeeValidator.mode = EmployeeValidator.Mode.EDIT;
        employeeValidator.validate(employee, result);
        User user = employee.getUsers();

        if (result.hasErrors())
        {
            int size = result.getFieldErrorCount();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (int i = 0; i < size; i++)
            {
                FieldError fieldError = fieldErrors.get(i);

                jsonConverter.addProperty(fieldError.getField(), fieldError.getCode());
                if (fieldError.getCode().equals("username.notAcceptable"))
                {
                    return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.BAD_REQUEST);
                }
            }
            return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.NOT_ACCEPTABLE);
        }

        if (user.getPassword().length() <= 15)
        {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        Query query =
                entityManager
                        .createNativeQuery("update employee inner join user u on employee.user_id = u.id" +
                                " set full_name=:fullName," +
                                "date_of_birth=:dateOfBirth," +
                                "gender=:gender," +
                                "id_card=:idCard," +
                                "email=:email," +
                                "address=:address," +
                                "phone=:phone," +
                                "u.password=:password where employee.id=:id")
                        .setParameter("fullName", employee.getFullName())
                        .setParameter("dateOfBirth", employee.getDateOfBirth())
                        .setParameter("gender", employee.getGender())
                        .setParameter("idCard", employee.getIdCard())
                        .setParameter("email", employee.getEmail())
                        .setParameter("address", employee.getAddress())
                        .setParameter("phone", employee.getPhone())
                        .setParameter("password", employee.getUsers().getPassword())
                        .setParameter("id", employee.getId());

        if (query.executeUpdate() > 0)
        {
            jsonConverter.addProperty("addOke", true);
            return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.CREATED);
        }

        //Else
        jsonConverter.addProperty("backEndError", true);
        return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(path = "employees/check-unique/id-card/{idCard}")
    public Boolean checkUniqueIdCard(@PathVariable String idCard)
    {
        Query query = entityManager
                .createQuery("select e from Employee e where e.idCard=:idCard")
                .setParameter("idCard", idCard);

        return query.getResultList().size() == 0;
    }
}

