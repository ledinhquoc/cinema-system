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
@Table(name = "ticket_prices")
public class TicketPrices {
    public TicketPrices() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ticketType;
    private String showTime;

    @Column(name = "thu246gt")
    private double thu246gt;

    @Column(name = "thu246gv")
    private double thu246gv;

    @Column(name = "thu246gd")
    private double thu246gd;

    @Column(name = "thu3gt")
    private double thu3gt;

    @Column(name = "thu3gv")
    private double thu3gv;

    @Column(name = "thu3gd")
    private double thu3gd;

    @Column(name = "thu67CNgt")
    private double thu67CNgt;

    @Column(name = "thu67CNgv")
    private double thu67CNgv;

    @Column(name = "thu67CNgd")
    private double thu67CNgd;

    @OneToMany(mappedBy = "ticketPrices")
    @JsonManagedReference
    private List<Ticket> tickets;
}