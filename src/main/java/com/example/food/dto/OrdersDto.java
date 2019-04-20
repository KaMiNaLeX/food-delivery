package com.example.food.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class OrdersDto implements Serializable {
    private BigInteger id;
    private BigInteger clientId;
    private BigInteger couirerId;
    private BigInteger sum;
    //private Timestamp timeOrder;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getClientId() {
        return clientId;
    }

    public void setClientId(BigInteger clientId) {
        this.clientId = clientId;
    }

    public BigInteger getCouirerId() {
        return couirerId;
    }

    public void setCouirerId(BigInteger couirerId) {
        this.couirerId = couirerId;
    }

    public BigInteger getSum() {
        return sum;
    }

    public void setSum(BigInteger sum) {
        this.sum = sum;
    }

   /* public Timestamp getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Timestamp timeOrder) {
        this.timeOrder = timeOrder;
    }*/
}
