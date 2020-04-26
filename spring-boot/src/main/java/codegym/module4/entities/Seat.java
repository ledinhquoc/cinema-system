package codegym.module4.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "seats")
public class Seat {
    public Seat() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private int id;
    @Column(name = "seat_number")
    private int seatNumber;
    @Column(name = "is_booked")
    private boolean isBooked;
    @Column(name = "is_selecting")
    private boolean isSelecting;
    @Column(name = "is_vip")
    private boolean isVip;

    @ManyToOne
    @JoinColumn(name = "row_id")
    private _Row _row;

    @OneToMany(targetEntity = Ticket.class)
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