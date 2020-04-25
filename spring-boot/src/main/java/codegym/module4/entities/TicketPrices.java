package codegym.module4.entities;

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
@Table(name = "ticket_prices")
public class TicketPrices {
    public TicketPrices() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ticketType;
    private String showTime;

    @Column(name = "thu246gt")
    private double thu246gt;

    @Column(name = "thu246gv")
    private double thu246gv;

    @Column(name = "thu246gd")
    private double thu246gd;

    @Column(name = "thu3gt")
    private double thu3gt;

    @Column(name = "thu3gv")
    private double thu3gv;

    @Column(name = "thu3gd")
    private double thu3gd;

    @Column(name = "thu67CNgt")
    private double thu67CNgt;

    @Column(name = "thu67CNgv")
    private double thu67CNgv;

    @Column(name = "thu67CNgd")
    private double thu67CNgd;

    @OneToMany(mappedBy = "ticketPrices")
    @JsonManagedReference
    private List<Ticket> tickets;

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
     * @return the ticketType
     */
    public String getTicketType() {
        return ticketType;
    }

    /**
     * @param ticketType the ticketType to set
     */
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    /**
     * @return the showTime
     */
    public String getShowTime() {
        return showTime;
    }

    /**
     * @param showTime the showTime to set
     */
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    /**
     * @return the thu246gt
     */
    public double getThu246gt() {
        return thu246gt;
    }

    /**
     * @param thu246gt the thu246gt to set
     */
    public void setThu246gt(double thu246gt) {
        this.thu246gt = thu246gt;
    }

    /**
     * @return the thu246gv
     */
    public double getThu246gv() {
        return thu246gv;
    }

    /**
     * @param thu246gv the thu246gv to set
     */
    public void setThu246gv(double thu246gv) {
        this.thu246gv = thu246gv;
    }

    /**
     * @return the thu246gd
     */
    public double getThu246gd() {
        return thu246gd;
    }

    /**
     * @param thu246gd the thu246gd to set
     */
    public void setThu246gd(double thu246gd) {
        this.thu246gd = thu246gd;
    }

    /**
     * @return the thu3gt
     */
    public double getThu3gt() {
        return thu3gt;
    }

    /**
     * @param thu3gt the thu3gt to set
     */
    public void setThu3gt(double thu3gt) {
        this.thu3gt = thu3gt;
    }

    /**
     * @return the thu3gv
     */
    public double getThu3gv() {
        return thu3gv;
    }

    /**
     * @param thu3gv the thu3gv to set
     */
    public void setThu3gv(double thu3gv) {
        this.thu3gv = thu3gv;
    }

    /**
     * @return the thu3gd
     */
    public double getThu3gd() {
        return thu3gd;
    }

    /**
     * @param thu3gd the thu3gd to set
     */
    public void setThu3gd(double thu3gd) {
        this.thu3gd = thu3gd;
    }

    /**
     * @return the thu67CNgt
     */
    public double getThu67CNgt() {
        return thu67CNgt;
    }

    /**
     * @param thu67cNgt the thu67CNgt to set
     */
    public void setThu67CNgt(double thu67cNgt) {
        thu67CNgt = thu67cNgt;
    }

    /**
     * @return the thu67CNgv
     */
    public double getThu67CNgv() {
        return thu67CNgv;
    }

    /**
     * @param thu67cNgv the thu67CNgv to set
     */
    public void setThu67CNgv(double thu67cNgv) {
        thu67CNgv = thu67cNgv;
    }

    /**
     * @return the thu67CNgd
     */
    public double getThu67CNgd() {
        return thu67CNgd;
    }

    /**
     * @param thu67cNgd the thu67CNgd to set
     */
    public void setThu67CNgd(double thu67cNgd) {
        thu67CNgd = thu67cNgd;
    }

    /**
     * @return the tickets
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * @param tickets the tickets to set
     */
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}