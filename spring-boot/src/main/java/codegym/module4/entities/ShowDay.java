package codegym.module4.entities;

import javax.persistence.*;

@Entity
@Table(name = "show_day")
public class ShowDay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;


}
