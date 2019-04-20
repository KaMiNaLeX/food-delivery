package com.example.food.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class CouirersDto implements Serializable {
    private BigInteger id;
    private String surname;
    private String phone;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
