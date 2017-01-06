package model;

import javax.persistence.*;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="PERSON")
public class Person {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    @OneToOne(optional = false, mappedBy = "person")
    //@OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    //@PrimaryKeyJoinColumn
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee empl) {
        this.employee = empl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString(){
        return "id="+id+", name="+name+", country="+country;
    }
}
