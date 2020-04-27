package codegym.module4.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "movie")
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
    private List<MovieSchedule> movieSchedules;

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
     * @return the movieName
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * @param movieName the movieName to set
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * @return the movieType
     */
    public String getMovieType() {
        return movieType;
    }

    /**
     * @param movieType the movieType to set
     */
    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    /**
     * @return the dateStart
     */
    public Date getDateStart() {
        return dateStart;
    }

    /**
     * @param dateStart the dateStart to set
     */
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * @return the dateEnd
     */
    public Date getDateEnd() {
        return dateEnd;
    }

    /**
     * @param dateEnd the dateEnd to set
     */
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * @return the movieStudio
     */
    public String getMovieStudio() {
        return movieStudio;
    }

    /**
     * @param movieStudio the movieStudio to set
     */
    public void setMovieStudio(String movieStudio) {
        this.movieStudio = movieStudio;
    }

    /**
     * @return the directors
     */
    public String getDirectors() {
        return directors;
    }

    /**
     * @param directors the directors to set
     */
    public void setDirectors(String directors) {
        this.directors = directors;
    }

    /**
     * @return the actor
     */
    public String getActor() {
        return actor;
    }

    /**
     * @param actor the actor to set
     */
    public void setActor(String actor) {
        this.actor = actor;
    }

    /**
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the srcImg
     */
    public String getSrcImg() {
        return srcImg;
    }

    /**
     * @param srcImg the srcImg to set
     */
    public void setSrcImg(String srcImg) {
        this.srcImg = srcImg;
    }

    /**
     * @return the srcVideo
     */
    public String getSrcVideo() {
        return srcVideo;
    }

    /**
     * @param srcVideo the srcVideo to set
     */
    public void setSrcVideo(String srcVideo) {
        this.srcVideo = srcVideo;
    }

    public List<MovieSchedule> getMovieSchedules()
    {
        return this.movieSchedules;
    }

    public void setMovieSchedules(List<MovieSchedule> movieSchedules)
    {
        this.movieSchedules = movieSchedules;
    }
}