package codegym.module4.toantr.persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "movies")
public class Movie {
    public Movie() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieName;
    private String movieType;
    private Date dateStart;
    private Date dateEnd;
    private String movieStudio;
    private String directors;
    private String actor;
    private int duration;
    private String content;
    private String srcImg;
    private String srcVideo;

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private List<MovieSchedules> movieSchedules;

}