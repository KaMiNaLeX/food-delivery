package com.example.food.dto;

import java.io.Serializable;
import java.math.BigInteger;

public class ShoppingCartDishDto implements Serializable {
    private BigInteger id;
    private String name;
    private BigInteger count;
    private BigInteger sum;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }

    public BigInteger getSum() {
        return sum;
    }

    public void setSum(BigInteger sum) {
        this.sum = sum;
    }
}
