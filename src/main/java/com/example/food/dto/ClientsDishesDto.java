package com.example.food.dto;

import java.io.Serializable;
import java.util.List;

public class ClientsDishesDto implements Serializable {
    private List<MenuDto> menuId;
    private List<ClientsDto> clientId;
    private List<OrdersDto> orderId;

    public List<MenuDto> getMenuId() {
        return menuId;
    }

    public void setMenuId(List<MenuDto> menuId) {
        this.menuId = menuId;
    }

    public List<ClientsDto> getClientId() {
        return clientId;
    }

    public void setClientId(List<ClientsDto> clientId) {
        this.clientId = clientId;
    }

    public List<OrdersDto> getOrderId() {
        return orderId;
    }

    public void setOrderId(List<OrdersDto> orderId) {
        this.orderId = orderId;
    }
}
