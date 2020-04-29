package codegym.module4.entities;

import javax.persistence.*;



@Entity
@Table(name = "ticket")
public class Ticket {
    public Ticket() {
        //do nothing
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "booked_ticket_code")
    private String bookedTicketCode;



    @Column(name = "order_status")
    private String orderStatus;



    @Column(name = "price")
    private int price;

    @ManyToOne

    @JoinColumn(name = "seat_id")
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "ticket_price_id")
    private TicketPrices ticketPrices;

    @ManyToOne

    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    @ManyToOne

    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "movie_schedule_id")
    private MovieSchedules movieSchedules;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the bookedTicketCode
     */
    public String getBookedTicketCode() {
        return bookedTicketCode;
    }

    /**
     * @param bookedTicketCode the bookedTicketCode to set
     */
    public void setBookedTicketCode(String bookedTicketCode) {
        this.bookedTicketCode = bookedTicketCode;
    }

    /**
     * @return the orderStatus
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the seat
     */
    public Seat getSeat() {
        return seat;
    }

    /**
     * @param seat the seat to set
     */
    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    /**
     * @return the ticketPrices
     */
    public TicketPrices getTicketPrices() {
        return ticketPrices;
    }

    /**
     * @param ticketPrices the ticketPrices to set
     */
    public void setTicketPrices(TicketPrices ticketPrices) {
        this.ticketPrices = ticketPrices;
    }

    /**
     * @return the promotion
     */
    public Promotion getPromotion() {
        return promotion;
    }

    /**
     * @param promotion the promotion to set
     */
    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * @param employee the employee to set
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * @return the movieSchedules
     */
    public MovieSchedules getMovieSchedules() {
        return movieSchedules;
    }

    /**
     * @param movieSchedules the movieSchedules to set
     */
    public void setMovieSchedules(MovieSchedules movieSchedules) {
        this.movieSchedules = movieSchedules;
    }
}