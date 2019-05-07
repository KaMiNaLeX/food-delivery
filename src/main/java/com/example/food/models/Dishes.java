package com.example.food.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Dishes {
    private Long id;
    private String description;
    private Long mass;
    private String name;
    private Collection<Menu> menusById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "mass")
    public Long getMass() {
        return mass;
    }

    public void setMass(Long mass) {
        this.mass = mass;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dishes dishes = (Dishes) o;
        return Objects.equals(id, dishes.id) &&
                Objects.equals(description, dishes.description) &&
                Objects.equals(mass, dishes.mass) &&
                Objects.equals(name, dishes.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, mass, name);
    }

    @OneToMany(mappedBy = "dishesByDishId")
    @JsonIgnore
    public Collection<Menu> getMenusById() {
        return menusById;
    }

    @JsonIgnore
    public void setMenusById(Collection<Menu> menusById) {
        this.menusById = menusById;
    }
}
