package codegym.module4.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "movie_schedule")
public class MovieSchedule {
    public MovieSchedule() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date openingDay;

    @ManyToOne
    @JsonBackReference
    private ShowTime showTime;

    @ManyToOne
    @JsonBackReference
    private Movie movie;

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
     * @return the openingDay
     */
    public Date getOpeningDay() {
        return openingDay;
    }

    /**
     * @param openingDay the openingDay to set
     */
    public void setOpeningDay(Date openingDay) {
        this.openingDay = openingDay;
    }

    /**
     * @return the showTime
     */
    public ShowTime getShowTime() {
        return showTime;
    }

    /**
     * @param showTime the showTime to set
     */
    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    /**
     * @return the movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * @param movie the movie to set
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}