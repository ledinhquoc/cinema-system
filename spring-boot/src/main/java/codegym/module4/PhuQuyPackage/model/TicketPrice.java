package codegym.module4.PhuQuyPackage.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ticket_price")
public class TicketPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String ticket_type ;
    private String show_time ;
    private String thu246gt ;
    private String thu246gv ;
    private String thu246gd ;
    private String thu3gt ;
    private String thu3gv ;
    private String thu3gd ;
    private String thu67CNgt ;
    private String thu67CNgv ;
    private String thu67CNgd ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TicketPrice() {
    }


    public String getTicket_type() {
        return ticket_type;
    }

    public void setTicket_type(String ticket_type) {
        this.ticket_type = ticket_type;
    }

    public String getShow_time() {
        return show_time;
    }

    public void setShow_time(String show_time) {
        this.show_time = show_time;
    }

    public String getThu246gt() {
        return thu246gt;
    }

    public void setThu246gt(String thu246gt) {
        this.thu246gt = thu246gt;
    }

    public String getThu246gv() {
        return thu246gv;
    }

    public void setThu246gv(String thu246gv) {
        this.thu246gv = thu246gv;
    }

    public String getThu246gd() {
        return thu246gd;
    }

    public void setThu246gd(String thu246gd) {
        this.thu246gd = thu246gd;
    }

    public String getThu3gt() {
        return thu3gt;
    }

    public void setThu3gt(String thu3gt) {
        this.thu3gt = thu3gt;
    }

    public String getThu3gv() {
        return thu3gv;
    }

    public void setThu3gv(String thu3gv) {
        this.thu3gv = thu3gv;
    }

    public String getThu3gd() {
        return thu3gd;
    }

    public void setThu3gd(String thu3gd) {
        this.thu3gd = thu3gd;
    }

    public String getThu67CNgt() {
        return thu67CNgt;
    }

    public void setThu67CNgt(String thu67CNgt) {
        this.thu67CNgt = thu67CNgt;
    }

    public String getThu67CNgv() {
        return thu67CNgv;
    }

    public void setThu67CNgv(String thu67CNgv) {
        this.thu67CNgv = thu67CNgv;
    }

    public String getThu67CNgd() {
        return thu67CNgd;
    }

    public void setThu67CNgd(String thu67CNgd) {
        this.thu67CNgd = thu67CNgd;
    }
//    @OneToMany(targetEntity = Tickets.class)
//    private List<Tickets> ticketsList;
}
