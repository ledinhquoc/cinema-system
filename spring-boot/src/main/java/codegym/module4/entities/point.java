package codegym.module4.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "points")
public class Point {
    public Point() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date dateCreate;
    private String nameMovie;
    private String pointValue;
    private String pointStatus;

    @ManyToOne
    @JsonBackReference
    private Customer customer;

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
     * @return the dateCreate
     */
    public Date getDateCreate() {
        return dateCreate;
    }

    /**
     * @param dateCreate the dateCreate to set
     */
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /**
     * @return the nameMovie
     */
    public String getNameMovie() {
        return nameMovie;
    }

    /**
     * @param nameMovie the nameMovie to set
     */
    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    /**
     * @return the pointValue
     */
    public String getPointValue() {
        return pointValue;
    }

    /**
     * @param pointValue the pointValue to set
     */
    public void setPointValue(String pointValue) {
        this.pointValue = pointValue;
    }

    /**
     * @return the pointStatus
     */
    public String getPointStatus() {
        return pointStatus;
    }

    /**
     * @param pointStatus the pointStatus to set
     */
    public void setPointStatus(String pointStatus) {
        this.pointStatus = pointStatus;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}