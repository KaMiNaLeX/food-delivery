package com.example.food.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "clients_dishes", schema = "food_delivery", catalog = "")
public class ClientsDishes {
    private Long id;
    private Long menuId;
    private Long clientId;
    private Long orderId;
    private Menu menuByMenuId;
    private Clients clientsByClientId;
    private Orders ordersByOrderId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "menu_id")
    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "client_id")
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Basic
    @Column(name = "order_id")
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
        return Objects.equals(menuId, that.menuId) &&
                Objects.equals(clientId, that.clientId) &&
                Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, clientId, orderId);
    }

    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    public Menu getMenuByMenuId() {
        return menuByMenuId;
    }

    @JsonIgnore
    public void setMenuByMenuId(Menu menuByMenuId) {
        this.menuByMenuId = menuByMenuId;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    public Clients getClientsByClientId() {
        return clientsByClientId;
    }

    @JsonIgnore
    public void setClientsByClientId(Clients clientsByClientId) {
        this.clientsByClientId = clientsByClientId;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    public Orders getOrdersByOrderId() {
        return ordersByOrderId;
    }

    @JsonIgnore
    public void setOrdersByOrderId(Orders ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }
}
