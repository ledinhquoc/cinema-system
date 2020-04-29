package codegym.module4.promotions.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Promotions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long promotion_id;

    private String promotion_title;
    private String promotion_description;
    private String promotion_image;
    private Date promotion_begin_date;
    private Date promotion_end_date;
    private int promotion_discuont;

    public Promotions() {
    }

    public Promotions(String promotion_title, String promotion_description, String promotion_image, Date promotion_begin_date, Date promotion_end_date, int promotion_discuont) {
        this.promotion_title = promotion_title;
        this.promotion_description = promotion_description;
        this.promotion_image = promotion_image;
        this.promotion_begin_date = promotion_begin_date;
        this.promotion_end_date = promotion_end_date;
        this.promotion_discuont = promotion_discuont;
    }

    public Long getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(Long promotion_id) {
        this.promotion_id = promotion_id;
    }

    public String getPromotion_title() {
        return promotion_title;
    }

    public void setPromotion_title(String promotion_title) {
        this.promotion_title = promotion_title;
    }

    public String getPromotion_description() {
        return promotion_description;
    }

    public void setPromotion_description(String promotion_description) {
        this.promotion_description = promotion_description;
    }

    public String getPromotion_image() {
        return promotion_image;
    }

    public void setPromotion_image(String promotion_image) {
        this.promotion_image = promotion_image;
    }

    public Date getPromotion_begin_date() {
        return promotion_begin_date;
    }

    public void setPromotion_begin_date(Date promotion_begin_date) {
        this.promotion_begin_date = promotion_begin_date;
    }

    public Date getPromotion_end_date() {
        return promotion_end_date;
    }

    public void setPromotion_end_date(Date promotion_end_date) {
        this.promotion_end_date = promotion_end_date;
    }

    public int getPromotion_discuont() {
        return promotion_discuont;
    }

    public void setPromotion_discuont(int promotion_discuont) {
        this.promotion_discuont = promotion_discuont;
    }
}
