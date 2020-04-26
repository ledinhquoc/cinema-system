package codegym.module4.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="users")
public class User {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    int id;



    @Column(name = "password")
    String password;

    @Column(name = "name")
    String name;



    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;


    public User(int idUser, String password, String name_user) {
        this.id = idUser;
        this.password = password;
        this.name = name_user;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int idUser) {
        this.id = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name_user) {
        this.name = name;
    }
}
