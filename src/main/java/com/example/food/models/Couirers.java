package com.example.food.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Couirers {
    private Long id;
    private String surname;
    private String phone;
    private Collection<Orders> ordersById;

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
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Couirers couirers = (Couirers) o;
        return Objects.equals(id, couirers.id) &&
                Objects.equals(surname, couirers.surname) &&
                Objects.equals(phone, couirers.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, phone);
    }

    @OneToMany(mappedBy = "couirersByCouirerId")
    @JsonIgnore
    public Collection<Orders> getOrdersById() {
        return ordersById;
    }

    @JsonIgnore
    public void setOrdersById(Collection<Orders> ordersById) {
        this.ordersById = ordersById;
    }
}
