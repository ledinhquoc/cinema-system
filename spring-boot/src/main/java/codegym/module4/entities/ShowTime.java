package codegym.module4.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "showtimes")
public class ShowTime {
    public ShowTime() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date hourStart;
    private Date hourEnd;

    @OneToMany(mappedBy = "showTime")
    @JsonManagedReference
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
    public Date getHourStart() {
        return hourStart;
    }

    /**
     * @param hourStart the hourStart to set
     */
    public void setHourStart(Date hourStart) {
        this.hourStart = hourStart;
    }

    /**
     * @return the hourEnd
     */
    public Date getHourEnd() {
        return hourEnd;
    }

    /**
     * @param hourEnd the hourEnd to set
     */
    public void setHourEnd(Date hourEnd) {
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