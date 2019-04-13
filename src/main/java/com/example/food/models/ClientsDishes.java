package com.example.food.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "clients_dishes", schema = "food_delivery", catalog = "")
public class ClientsDishes implements Serializable {
    private Long dishId;
    private Long clientId;
    private Long orderId;
    private Clients clientsByClientId;
    private Orders ordersByOrderId;

    @Id
    @Column(name = "dish_id", insertable = false, updatable = false)
    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    @Basic
    @Column(name = "client_id", insertable = false, updatable = false)
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "order_id", insertable = false, updatable = false)
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientsDishes that = (ClientsDishes) o;
        return Objects.equals(dishId, that.dishId) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishId, clientId, orderId);
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @JsonIgnore
    public Clients getClientsByClientId() {
        return clientsByClientId;
    }

    @JsonIgnore
    public void setClientsByClientId(Clients clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @JsonIgnore
    public Orders getOrdersByOrderId() {
        return ordersByOrderId;
    }

    @JsonIgnore
    public void setOrdersByOrderId(Orders ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }
}
