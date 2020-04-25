//package codegym.module4.QuocVietPackage.Entities;
//
//import org.springframework.format.annotation.DateTimeFormat;
//
//import javax.persistence.*;
//import java.util.Date;
//
//
//
//@Entity
//@Table(name="status_tickes")
//public class ticket {
//
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private int id;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private customer idCustomer;
//
//
//    @Column(name = "name_film")
//    private String nameMovie;
//
//
//
//    @Column(name = "total_money")
//    private int totalMoney;
//
//    @Column(name = "status")
//    private String status;
//
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    @Temporal(value=TemporalType.DATE)
//    @Column(name = "date_of_order")
//    private Date dateOfOrder;
//
//    public ticket(int id, customer idCustomer, String nameMovie, int totalMoney, String status, Date dateOfOrder) {
//        this.id = id;
//        this.idCustomer = idCustomer;
//        this.nameMovie = nameMovie;
//        this.totalMoney = totalMoney;
//        this.status = status;
//        this.dateOfOrder = dateOfOrder;
//    }
//
//    public ticket() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public customer getIdCustomer() {
//        return idCustomer;
//    }
//
//    public void setIdCustomer(customer idCustomer) {
//        this.idCustomer = idCustomer;
//    }
//
//    public String getNameMovie() {
//        return nameMovie;
//    }
//
//    public void setNameMovie(String nameMovie) {
//        this.nameMovie = nameMovie;
//    }
//
//    public int getTotalMoney() {
//        return totalMoney;
//    }
//
//    public void setTotalMoney(int totalMoney) {
//        this.totalMoney = totalMoney;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Date getDateOfOrder() {
//        return dateOfOrder;
//    }
//
//    public void setDateOfOrder(Date dateOfOrder) {
//        this.dateOfOrder = dateOfOrder;
//    }
//}
