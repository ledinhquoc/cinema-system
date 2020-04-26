package codegym.module4.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="points")
public class Point {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;



    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value=TemporalType.DATE)
    @Column(name = "dateCreat")
    private Date dateCreat;

    @Column(name = "nameMovie")
    private String nameMovie;

    @Column(name = "pointValue")
    private String point;


    @Column(name = "pointStatus")
    private String pointStatus;



    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Point() {
    }

    public Point(long id, Customer idCustomer, Date dateCreat, String nameMovie, String point, String pointStatus) {
        this.id = id;
        this.dateCreat = dateCreat;
        this.nameMovie = nameMovie;
        this.point = point;
        this.customer = idCustomer;
       this.pointStatus=pointStatus;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getIdCustomer() {
        return customer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.customer = idCustomer;
    }

    public Date getDateCreat() {
        return dateCreat;
    }

    public void setDateCreat(Date dateCreat) {
        this.dateCreat = dateCreat;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getPointStatus() {
        return pointStatus;
    }

    public void setPointStatus(String pointStatus) {
        this.pointStatus = pointStatus;
    }
}
