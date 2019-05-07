package com.example.food.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Menu {
    private Long id;
    private String category;
    private Long cost;
    private Long dishId;
    private Collection<ClientsDishes> clientsDishesById;
    private Dishes dishesByDishId;
    private Collection<ShoppingCart> shoppingCartsById;

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
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "cost")
    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "dish_id")
    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id) &&
                Objects.equals(category, menu.category) &&
                Objects.equals(cost, menu.cost) &&
                Objects.equals(dishId, menu.dishId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, cost, dishId);
    }

    @OneToMany(mappedBy = "menuByMenuId")
    @JsonIgnore
    public Collection<ClientsDishes> getClientsDishesById() {
        return clientsDishesById;
    }

    @JsonIgnore
    public void setClientsDishesById(Collection<ClientsDishes> clientsDishesById) {
        this.clientsDishesById = clientsDishesById;
    }

    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    public Dishes getDishesByDishId() {
        return dishesByDishId;
    }

    @JsonIgnore
    public void setDishesByDishId(Dishes dishesByDishId) {
        this.dishesByDishId = dishesByDishId;
    }

    @OneToMany(mappedBy = "menuByMenuId")
    @JsonIgnore
    public Collection<ShoppingCart> getShoppingCartsById() {
        return shoppingCartsById;
    }

    @JsonIgnore
    public void setShoppingCartsById(Collection<ShoppingCart> shoppingCartsById) {
        this.shoppingCartsById = shoppingCartsById;
    }
}
