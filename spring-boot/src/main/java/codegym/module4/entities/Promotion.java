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
@Table(name = "promotion")
public class Promotion {
    public Promotion() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date promotionDate;

    private String promotionImage;

    @OneToMany(mappedBy = "promotion")
    @JsonManagedReference
    private List<Ticket> tickets;

    public Date getPromotionDate()
    {
        return this.promotionDate;
    }

    public void setPromotionDate(Date promotionDate)
    {
        this.promotionDate = promotionDate;
    }

    public String getPromotionImage()
    {
        return this.promotionImage;
    }

    public void setPromotionImage(String promotionImage)
    {
        this.promotionImage = promotionImage;
    }

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