package com.example.food.dto.clientDto;

import java.io.Serializable;
import java.math.BigInteger;

public class ShoppingCartDishDto implements Serializable {
    private BigInteger id;
    private String name;

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

}
