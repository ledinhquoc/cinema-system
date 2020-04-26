package codegym.module4.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "_rows")
public class _Row {

    public _Row() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "show_room_id")
    private ShowRoom showRoom;

    @OneToMany(targetEntity = Seat.class)
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