package com.example.food.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Clients implements Serializable {
    private Long id;
    private String surname;
    private String phone;
    private String address;
    private String login;
    private String password;
    private Collection<ClientsDishes> clientsDishesById;
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

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clients clients = (Clients) o;
        return Objects.equals(id, clients.id) &&
                Objects.equals(surname, clients.surname) &&
                Objects.equals(phone, clients.phone) &&
                Objects.equals(address, clients.address) &&
                Objects.equals(login, clients.login) &&
                Objects.equals(password, clients.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, phone, address, login, password);
    }

    @OneToMany(mappedBy = "clientsByClientId")
    @JsonIgnore
    public Collection<ClientsDishes> getClientsDishesById() {
        return clientsDishesById;
    }

    @JsonIgnore
    public void setClientsDishesById(Collection<ClientsDishes> clientsDishesById) {
        this.clientsDishesById = clientsDishesById;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "clientsByClientId")
    public Collection<Orders> getOrdersById() {
        return ordersById;
    }

    @JsonIgnore
    public void setOrdersById(Collection<Orders> ordersById) {
        this.ordersById = ordersById;
    }
}
