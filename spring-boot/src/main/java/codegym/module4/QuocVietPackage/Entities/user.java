package codegym.module4.QuocVietPackage.Entities;

import javax.persistence.*;




@Entity
@Table(name="users")
public class user {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    int id;



    @Column(name = "password")
    String password;

    @Column(name = "name")
    String name_user;



    public user(int idUser, String password, String name_user) {
        this.id = idUser;
        this.password = password;
        this.name_user = name_user;
    }

    public user() {
    }

    public int getIdUser() {
        return id;
    }

    public void setIdUser(int idUser) {
        this.id = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name_user) {
        this.name_user = name_user;
    }
}
