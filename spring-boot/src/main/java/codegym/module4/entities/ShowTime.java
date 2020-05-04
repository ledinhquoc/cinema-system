package codegym.module4.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;



@Entity
@Table(name = "showtime")
public class ShowTime {
    public ShowTime() {
        //do nothing
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private int id;
    @Column(name = "hour_start")

    private Time hourStart;
    @Column(name = "hour_end")

    private Time hourEnd;

    @OneToMany(targetEntity = MovieSchedules.class)
    @JsonBackReference
    private List<MovieSchedules> movieSchedules;





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
     * @return the hourStart
     */
    public Time getHourStart() {
        return hourStart;
    }

    /**
     * @param hourStart the hourStart to set
     */
    public void setHourStart(Time hourStart) {
        this.hourStart = hourStart;
    }

    /**
     * @return the hourEnd
     */
    public Time getHourEnd() {
        return hourEnd;
    }

    /**
     * @param hourEnd the hourEnd to set
     */
    public void setHourEnd(Time hourEnd) {
        this.hourEnd = hourEnd;
    }

    /**
     * @return the movieSchedules
     */
    public List<MovieSchedules> getMovieSchedules() {
        return movieSchedules;
    }

    /**
     * @param movieSchedules the movieSchedules to set
     */
    public void setMovieSchedules(List<MovieSchedules> movieSchedules) {
        this.movieSchedules = movieSchedules;
    }
}