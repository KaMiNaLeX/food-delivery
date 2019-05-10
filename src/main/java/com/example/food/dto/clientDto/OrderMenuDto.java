package com.example.food.dto.clientDto;

import java.math.BigInteger;
import java.sql.Timestamp;

public class OrderMenuDto {
    private BigInteger id;
    private String login;
    private String phone;
    private String address;
    private BigInteger sum;
    private Timestamp timeOrder;

    public Timestamp getTimeOrder() {
        return timeOrder;
    }

    public void setTimeOrder(Timestamp timeOrder) {
        this.timeOrder = timeOrder;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigInteger getSum() {
        return sum;
    }

    public void setSum(BigInteger sum) {
        this.sum = sum;
    }
}
