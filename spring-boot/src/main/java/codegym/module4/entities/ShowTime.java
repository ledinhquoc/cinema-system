package codegym.module4.toantr.persistence.model;

import java.util.Date;
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
}