package codegym.module4.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "show_rooms")
public class ShowRoom {
    public ShowRoom() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "show_room_id")
    private int id;

    @Column(name = "name")
    private String name;


    @Column(name = "screen")
    private String screen;

    @OneToMany(targetEntity = _Row.class)
    private List<_Row> _rows;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the screen
     */
    public String getScreen() {
        return screen;
    }

    /**
     * @param screen the screen to set
     */
    public void setScreen(String screen) {
        this.screen = screen;
    }

    /**
     * @return the _rows
     */
    public List<_Row> get_rows() {
        return _rows;
    }

    /**
     * @param _rows the _rows to set
     */
    public void set_rows(List<_Row> _rows) {
        this._rows = _rows;
    }

}