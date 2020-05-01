package codegym.module4.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "promotion")
public class Promotion {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    public Promotion() {
        //do nothing
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value=TemporalType.DATE)
  @Column(name = "promotion_begin_date")
    private Date promotionBeginDate;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value=TemporalType.DATE)
    @Column(name = "promotion_end_date")
    private Date promotionEndDate;

    @Column(name = "promotion_title")
    private String promotionTitle;

    @Column(name = "promotion_discount")
    private String promotionDiscount;

    @Column(name = "promotion_description")
    private String promotionDescription;


    @Column(name = "promotion_image")
    private String promotionImage;

    @OneToMany(targetEntity = Ticket.class)
    @JsonBackReference
    private List<Ticket> tickets;


    public Date getPromotionBeginDate() {
        return promotionBeginDate;
    }

    public void setPromotionBeginDate(Date promotionBeginDate) {
        this.promotionBeginDate = promotionBeginDate;
    }

    public Date getPromotionEndDate() {
        return promotionEndDate;
    }

    public void setPromotionEndDate(Date promotionEndDate) {
        this.promotionEndDate = promotionEndDate;
    }

    public String getPromotionTitle() {
        return promotionTitle;
    }

    public void setPromotionTitle(String promotionTitle) {
        this.promotionTitle = promotionTitle;
    }

    public String getPromotionDiscount() {
        return promotionDiscount;
    }

    public void setPromotionDiscount(String promotionDiscount) {
        this.promotionDiscount = promotionDiscount;
    }

    public String getPromotionDescription() {
        return promotionDescription;
    }

    public void setPromotionDescription(String promotionDescription) {
        this.promotionDescription = promotionDescription;
    }

    public String getPromotionImage() {
        return promotionImage;
    }

    public void setPromotionImage(String promotionImage) {
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