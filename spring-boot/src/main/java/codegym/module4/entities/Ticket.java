package codegym.module4.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ticket")
public class Ticket {
    public Ticket() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String bookedTicketCode;
    private String orderStatus;
    private int price;

    @ManyToOne
    @JsonBackReference
    private Seat seat;

    @ManyToOne
    @JsonManagedReference
    private TicketPrice ticketPrice;

    @ManyToOne
    @JsonBackReference
    private Promotion promotion;

    @ManyToOne
    @JsonBackReference
    private Customer customer;

    @ManyToOne
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @JsonBackReference
    private MovieSchedule movieSchedule;

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
    public TicketPrice getTicketPrices() {
        return ticketPrice;
    }

    /**
     * @param ticketPrices the ticketPrices to set
     */
    public void setTicketPrices(TicketPrice ticketPrices) {
        this.ticketPrice = ticketPrices;
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
    public MovieSchedule getMovieSchedules() {
        return movieSchedule;
    }

    /**
     * @param movieSchedules the movieSchedules to set
     */
    public void setMovieSchedules(MovieSchedule movieSchedules) {
        this.movieSchedule = movieSchedules;
    }
}