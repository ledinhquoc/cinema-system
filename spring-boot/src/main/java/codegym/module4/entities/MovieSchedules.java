package codegym.module4.entities;

import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "movie_schedules")
public class MovieSchedules {
    public MovieSchedules() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_schedule_id")

    private int id;

    @Column(name = "opening_day")

    private Date openingDay;

    @ManyToOne

    @JoinColumn(name = "showtime_id")
    private ShowTime showTime;

    @ManyToOne

    @JoinColumn(name = "movie_id")
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