package codegym.module4.controllers;

import codegym.module4.entities.*;
import codegym.module4.entities.validators.EmployeeValidator;
import codegym.module4.helpers.JsonConverter;
import codegym.module4.repositories.EmployeeRepo;
import codegym.module4.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "*")
<<<<<<< HEAD
public class RestController{
=======
public class RestController {
    @Autowired
    private EmployeeService employeeService;
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
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

    @GetMapping(value = "/tickets", produces = "application/json")
<<<<<<< HEAD
    public ResponseEntity< List< Ticket > > getAllTickets(){
        List< Ticket > tickets = ticketService.findAll();
=======
    public ResponseEntity<List<Ticket>> getAllTickets() {
        List<Ticket> tickets = ticketService.findAll();
    {
        List<Ticket> tickets = ticketService.findAll();

        if (tickets.isEmpty())
        {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping(value = "/tickets/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public ResponseEntity< Ticket > getTicketById(
            @PathVariable("id") Integer id){
        Optional< Ticket > ticket = ticketService.findById(id);

        if(!ticket.isPresent()){
=======
    public ResponseEntity<Ticket> getTicketById(

            @PathVariable("id") Integer id) {

        Optional<Ticket> ticket = ticketService.findById(id);

        if (!ticket.isPresent())
        {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
            return new ResponseEntity<>(ticket.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticket.get(), HttpStatus.OK);
    }

    @GetMapping(path = "movie-schedules", produces = "application/json")
<<<<<<< HEAD
    public List< MovieSchedules > getAllMovieSchedules(){
=======
    public List<MovieSchedules> getAllMovieSchedules() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return movieSchedulesService.findAll();
    }

    @GetMapping(path = "movies", produces = "application/json")
<<<<<<< HEAD
    public ResponseEntity< List< Movie > > getAllMovies(){
=======
    public ResponseEntity<List<Movie>> getAllMovies() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return new ResponseEntity<>(movieService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "employees", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< Employee > getAllEmployees(){
=======
    public List<Employee> getAllEmployees() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return employeeRepo.findAll();
    }


    @GetMapping(path = "users", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< User > getAllUsers(){
=======
    public List<User> getAllUsers() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return userService.findAll();

    }

    @GetMapping(path = "customers", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< Customer > getAllCustomers(){
=======
    public List<Customer> getAllCustomers() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return customerService.findAll();
    }

    @GetMapping(path = "points", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< Point > getAllPoints(){
=======
    public List<Point> getAllPoints() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return pointService.findAll();
    }

    @GetMapping(path = "promotions", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< Promotion > getAllPromotions(){
=======
    public List<Promotion> getAllPromotions() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return promotionService.findAll();
    }

    @GetMapping(path = "roles", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< Role > getAllRoles(){
=======
    public List<Role> getAllRoles() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return roleService.findAll();
    }

    @GetMapping(path = "seats", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< Seat > getAllSeats(){
=======
    public List<Seat> getAllSeats() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return seatService.findAll();
    }

    @GetMapping(path = "show-rooms", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< ShowRoom > getAllShowRooms(){
=======
    public List<ShowRoom> getAllShowRooms() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return showRoomService.findAll();
    }

    @GetMapping(path = "show-times", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< ShowTime > getAllShowTimes(){
=======
    public List<ShowTime> getAllShowTimes() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return showTimeService.findAll();
    }

    @GetMapping(path = "ticket-prices", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< TicketPrices > getAllTicketPrices(){
=======
    public List<TicketPrices> getAllTicketPrices() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return ticketPricesService.findAll();
    }

    @GetMapping(path = "rows", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< Row > getAllRows(){
=======
    public List<Row> getAllRows() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return rowService.findAll();
    }


//    @GetMapping(path = "tickets/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Ticket getTicketById(@PathVariable int id)
//    {
//        return ticketService.findById(id);
//    }

    @GetMapping(path = "show-rooms/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public ShowRoom getShowRoomById(@PathVariable int id){
=======
    public ShowRoom getShowRoomById(@PathVariable int id) {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return this.showRoomService.findById(id);
    }

    @GetMapping(path = "movies/movie-schedules/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< Movie > getMovieByMovieSchedules(@PathVariable int id){
=======
    public List<Movie> getMovieByMovieSchedules(@PathVariable int id) {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        StoredProcedureQuery spQuery =
                entityManager.createNamedStoredProcedureQuery("GetMovieByMovieScheduleId");
        spQuery.setParameter("movieScheduleId", id);
        spQuery.execute();

        return new ArrayList< Movie >(spQuery.getResultList());
    }

    @GetMapping(path = "movie-schedules/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public MovieSchedules getMovieSchedulesById(@PathVariable int id){
=======
    public MovieSchedules getMovieSchedulesById(@PathVariable int id) {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return movieSchedulesService.findById(id);
    }

    @GetMapping(path = "customers/ticket/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< Customer > getCustomerByTicketToan(@PathVariable int id){
=======
    public List<Customer> getCustomerByTicketToan(@PathVariable int id) {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        StoredProcedureQuery spQuery =
                entityManager.createNamedStoredProcedureQuery("GetCustomerByTicketId");
        spQuery.setParameter("ticketId", id);
        spQuery.execute();

        return new ArrayList<>(spQuery.getResultList());
    }

    @GetMapping(path = "rows/show-room/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public List< Row > getRowsByShowRoomId(@PathVariable int id){
=======
    public List<Row> getRowsByShowRoomId(@PathVariable int id) {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
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
<<<<<<< HEAD
    public List< Seat > getSeatsByRowId(@PathVariable int id){
=======
    public List<Seat> getSeatsByRowId(@PathVariable int id) {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
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
<<<<<<< HEAD
    public User newUser(@RequestBody User user){
=======
    public User newUser(@RequestBody User user) {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        Role roleAdmin = roleService.findById(1);
        List< Role > roles = new ArrayList<>();
        roles.add(roleAdmin);
        user.setRoles(roles);

        return userService.save(user);
    }

    @GetMapping("roles")
<<<<<<< HEAD
    public List< Role > getAllRole(){
=======
    public List<Role> getAllRole() {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return roleService.findAll();
    }


    @GetMapping(path = "/roles/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public Role getRoleById(@PathVariable int id){
=======
    public Role getRoleById(@PathVariable int id) {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return roleService.findById(id);
    }

    @GetMapping(path = "tickets/empty", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public Ticket getEmptyTicket(){
=======

    public Ticket getEmptyTicket() {

>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        return new Ticket();
    }

    @GetMapping(path = "movie-schedules/empty", produces = MediaType.APPLICATION_JSON_VALUE)
<<<<<<< HEAD
    public MovieSchedules getEmptyMovieSchedule(){
        return new MovieSchedules();
    }

    @GetMapping(path = "rowsByShowRoom/{id}")
    public List< Row > getRowByShowRoom(@PathVariable ShowRoom id){
=======
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
        return Integer.parseInt(query.getResultList().get(0).toString()) >= 1;
    }

    @GetMapping(path = "employees/check/email/{email}")
    public Boolean checkUniqueEmail(@PathVariable("email") String email)
    {
        Query query =
                entityManager
                        .createNativeQuery("call CheckUniqueEmail(:email)")
                        .setParameter("email", email);

        return Integer.parseInt(query.getResultList().get(0).toString()) >= 1;
    }

    @PostMapping(path = "employees/new/saved")
    public ResponseEntity<String> saveNewEmployee(@RequestBody Employee employee,BindingResult result)
    {
        JsonConverter jsonConverter=new JsonConverter();
        employeeValidator.validate(employee, result);

        if (result.hasErrors())
        {
            result.getFieldErrors().forEach(fieldError -> {
                jsonConverter.addProperty(fieldError.getField(),fieldError.getCode());
            });
            return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.NOT_ACCEPTABLE);
        }

        userService.save(employee.getUsers());
        if (employeeService.save(employee) != null)
        {
            jsonConverter.addProperty("addOke",true);
            return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.CREATED);
        }

        jsonConverter.addProperty("backEndError",true);
        return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.NOT_MODIFIED);
    }

    @PutMapping(path = "employees/edit/saved", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public ResponseEntity<String> saveEditedEmployee(@RequestBody Employee employee, BindingResult result)
    {
        JsonConverter jsonConverter=new JsonConverter();
        employeeValidator.validate(employee, result);

        if (result.hasErrors())
        {
            result.getFieldErrors().forEach(fieldError -> {
                jsonConverter.addProperty(fieldError.getField(),fieldError.getCode());
            });
            return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.NOT_ACCEPTABLE);
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
            jsonConverter.addProperty("addOke",true);
            return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.CREATED);
        }

        //Else
        jsonConverter.addProperty("backEndError",true);
        return new ResponseEntity<>(jsonConverter.getJsonObject(), HttpStatus.NOT_MODIFIED);
      @GetMapping(path = "rowsByShowRoom/{id}")
    public List<Row> getRowByShowRoom(@PathVariable ShowRoom id){
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173


        return rowService.findByShowRoom(id);
    }

    @PostMapping(path = "show-rooms")
    public ShowRoom CreatShowroom(@RequestBody ShowRoom showRoom) {
        return showRoomService.creat(showRoom);
    }

    @PutMapping(path = "seats/{id}")
<<<<<<< HEAD
    public Seat UpdateSeat(@PathVariable int id, @RequestBody Seat seat){
=======
    public Seat UpdateSeat(@PathVariable int id, @RequestBody Seat seat) {
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
        Seat seatUpdate = seatService.findById(id);
        seatUpdate.setVip(seat.isVip());
        return seatService.updateSeat(seatUpdate);
    }

    @PostMapping(path = "seats")
    public Seat CreatSeats(@RequestBody Seat seat) {
        return seatService.updateSeat(seat);
    }
    @GetMapping(value = "/promotions/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Promotion> getMovieById(
            @PathVariable("id") Integer promotion_id) {
        Optional<Promotion> promotion = promotionService.findById(promotion_id);

        if (!promotion.isPresent()) {
            return new ResponseEntity<>(promotion.get(),
                    HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(promotion.get(), HttpStatus.OK) ;

    }

    @PostMapping(path = "promotion/new")
    public Promotion CreatSeats(@RequestBody Promotion promotion) {
        return promotionService.save(promotion);

    }

<<<<<<< HEAD
    @PutMapping(path = "promotions/{id}")
    public Promotion editPromotion(@RequestBody Promotion promotion,
                                   @PathVariable int id){
        Promotion promotionUpdate = promotionService.findById(id).orElse(null);
        promotionUpdate.setPromotionTitle(promotion.getPromotionTitle());
        promotionUpdate.setPromotionImage(promotion.getPromotionImage());
        promotionUpdate.setPromotionDiscount(promotion.getPromotionDiscount());
        promotionUpdate.setPromotionDescription(promotion.getPromotionDescription());
        promotionUpdate.setPromotionBeginDate(promotion.getPromotionBeginDate());
        promotionUpdate.setPromotionEndDate(promotion.getPromotionEndDate());
        return promotionService.save(promotionUpdate);
    }
=======
    //hh

    @RequestMapping(value = "customers",
            method = RequestMethod.POST)
    public ResponseEntity<Customer> createProduct(
            @RequestBody Customer customer,
            UriComponentsBuilder builder) {
        customerService.save(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/products/{id}")
                .buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping("customers/{id}")
    public Customer editCustomer(@PathVariable int id, @RequestBody Customer customeredit) {
        Customer customerUpdate = customerService.findCustomerById(id);
        customerUpdate.setFullName(customeredit.getFullName());
        customerUpdate.setBirthday(customeredit.getBirthday());
        customerUpdate.setGender(customeredit.getGender());
        customerUpdate.setIdCard(customeredit.getIdCard());
        customerUpdate.setEmail(customeredit.getEmail());
        customerUpdate.setPhone(customeredit.getPhone());
        customerUpdate.setAddress(customeredit.getAddress());
        return customerService.saveCustomer(customerUpdate);
    }

    @DeleteMapping("customers/{id}")
    @Transactional
    public void deleteCustomer(@PathVariable int id) {
//        Customer customerToDelete = customerService.findCustomerById(id);
//        customerService.deleteCustomer(id);
        System.out.printf( "\n" +"Deleted id :" + id );
//        customerService.deleteCustomerById(id);
        Query query =
                entityManager
                        .createNativeQuery("delete from customer where customer.id=:id", Customer.class)
                        .setParameter("id", id);
        query.executeUpdate();
//        query.getResultList();
    }
//    @RequestMapping(value = "/customers/{id}",
//            method = RequestMethod.DELETE)
//    public ResponseEntity<Customer> deleteProduct(
//            @PathVariable("id") Integer id) {
//        Optional<Customer> customer = Optional.ofNullable(customerService.findById(id));
//        if (!customer.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        customerService.deleteCustomer(customer.get());
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

    //hh
>>>>>>> e5a9a6e0f9fee7f6ad4f3daf814ea95ce72ce173
}



