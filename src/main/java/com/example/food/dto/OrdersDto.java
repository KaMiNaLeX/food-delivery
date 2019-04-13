package com.example.food.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class OrdersDto implements Serializable {
    private Long id;
    private List<ClientsDto> clientId;
    private List<CouirersDto> couirerId;
    private Long sum;
    private Timestamp timeOrder;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ClientsDto> getClientId() {
        return clientId;
    }

    public void setClientId(List<ClientsDto> clientId) {
        this.clientId = clientId;
    }

    public List<CouirersDto> getCouirerId() {
        return couirerId;
    }

    public void setCouirerId(List<CouirersDto> couirerId) {
        this.couirerId = couirerId;
    }

    public Long getSum() {
        return sum;
    }

    public void setSum(Long sum) {
        this.sum = sum;
    }

    public Timestamp getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Timestamp timeOrder) {
        this.timeOrder = timeOrder;
    }
}
