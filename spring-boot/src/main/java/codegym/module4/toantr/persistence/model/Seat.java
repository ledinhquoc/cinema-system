package codegym.module4.toantr.persistence.model;

import java.util.List;

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
     * @return the seatNumber
     */
    public int getSeatNumber() {
        return seatNumber;
    }

    /**
     * @param seatNumber the seatNumber to set
     */
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    /**
     * @return the isBooked
     */
    public boolean isBooked() {
        return isBooked;
    }

    /**
     * @param isBooked the isBooked to set
     */
    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    /**
     * @return the isSelecting
     */
    public boolean isSelecting() {
        return isSelecting;
    }

    /**
     * @param isSelecting the isSelecting to set
     */
    public void setSelecting(boolean isSelecting) {
        this.isSelecting = isSelecting;
    }

    /**
     * @return the isVip
     */
    public boolean isVip() {
        return isVip;
    }

    /**
     * @param isVip the isVip to set
     */
    public void setVip(boolean isVip) {
        this.isVip = isVip;
    }

    /**
     * @return the _row
     */
    public _Row get_row() {
        return _row;
    }

    /**
     * @param _row the _row to set
     */
    public void set_row(_Row _row) {
        this._row = _row;
    }

    /**
     * @return the tickets
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * @param tickets the tickets to set
     */
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}