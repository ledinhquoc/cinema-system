package codegym.module4.toantr.persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "movie_schedules")
public class MovieSchedules {
    public MovieSchedules() {
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
}