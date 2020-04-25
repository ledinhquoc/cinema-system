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
@Table(name = "seats")
public class Seat {
    public Seat() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int seatNumber;
    private boolean isBooked;
    private boolean isSelecting;
    private boolean isVip;

    @ManyToOne
    @JsonBackReference
    private _Row _row;

    @OneToMany(mappedBy = "seat")
    @JsonManagedReference
    private List<Ticket> tickets;
}