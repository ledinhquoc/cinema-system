package codegym.module4.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="point")
public class Point {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;



    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value=TemporalType.DATE)
    @Column(name = "dateCreate")
    private Date dateCreate;

    @Column(name = "nameMovie")
    private String nameMovie;

    @Column(name = "pointValue")
    private String pointValue;


    @Column(name = "pointStatus")
    private String pointStatus;



    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Point() {
    }

    public Point(long id, Customer idCustomer, Date dateCreate, String nameMovie, String pointValue, String pointStatus) {
        this.id = id;
        this.dateCreate = dateCreate;
        this.nameMovie = nameMovie;
        this.pointValue = pointValue;
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
        return dateCreate;
    }

    public void setDateCreat(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getPointValue() {
        return pointValue;
    }

    public void setPointValue(String pointValue) {
        this.pointValue = pointValue;
    }

    public String getPointStatus() {
        return pointStatus;
    }

    public void setPointStatus(String pointStatus) {
        this.pointStatus = pointStatus;
    }
}
