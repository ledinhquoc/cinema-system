package codegym.module4.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User
{
    public User()
    {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String password;
    private int status;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonManagedReference
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Customer> customers;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Employee> employees;

    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the roles
     */
    public List<Role> getRoles()
    {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<Role> roles)
    {
        this.roles = roles;
    }

    public List<Customer> getCustomers()
    {
        return this.customers;
    }

    public void setCustomers(List<Customer> customers)
    {
        this.customers = customers;
    }

    public List<Employee> getEmployees()
    {
        return this.employees;
    }

    public void setEmployees(List<Employee> employees)
    {
        this.employees = employees;
    }

    public int getStatus()
    {
        return this.status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }
}