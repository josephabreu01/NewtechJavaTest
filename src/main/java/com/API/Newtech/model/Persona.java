package com.API.Newtech.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persona" , schema = "public")
public class Persona {
    @Id
    @GeneratedValue
    @Column(nullable = false)
   private Long id;
    private String name;
    private String lastName;
    private String phone;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Direcctions> directions = new java.util.ArrayList<>();

    public List<Direcctions> getDirections() {
        return directions;
    }

    public void setDirections(List<Direcctions> directions) {
        this.directions = directions;
    }

    public Persona(Long id, String name, String lastName, String phone, List<Direcctions> directions) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.directions = directions;
    }

    public Persona() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
