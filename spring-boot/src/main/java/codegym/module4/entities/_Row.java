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
@Table(name = "_rows")
public class _Row {

    public _Row() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference
    private ShowRoom showRoom;

    @OneToMany(mappedBy = "_row")
    @JsonManagedReference
    private List<Seat> seats;

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
     * @return the showRoom
     */
    public ShowRoom getShowRoom() {
        return showRoom;
    }

    /**
     * @param showRoom the showRoom to set
     */
    public void setShowRoom(ShowRoom showRoom) {
        this.showRoom = showRoom;
    }

    /**
     * @return the seats
     */
    public List<Seat> getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

}