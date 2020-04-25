package codegym.module4.QuocVietPackage.Entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="points")
public class point {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "point_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private customer idCustomer;


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


    public point() {
    }

    public point(long id, customer idCustomer, Date dateCreat, String nameMovie, String point, String pointStatus) {
        this.id = id;
        this.dateCreat = dateCreat;
        this.nameMovie = nameMovie;
        this.point = point;
        this.idCustomer = idCustomer;
       this.pointStatus=pointStatus;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(customer idCustomer) {
        this.idCustomer = idCustomer;
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
