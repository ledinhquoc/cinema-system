package codegym.module4.toantr.persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "tickets")
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
    @JsonBackReference
    private TicketPrices ticketPrices;

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
    private MovieSchedules movieSchedules;
}