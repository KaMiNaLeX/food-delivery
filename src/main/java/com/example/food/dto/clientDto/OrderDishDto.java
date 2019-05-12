package com.example.food.dto.clientDto;

import java.math.BigInteger;

public class OrderDishDto {
    private String name;
    private String description;
    private BigInteger mass;
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getMass() {
        return mass;
    }

    public void setMass(BigInteger mass) {
        this.mass = mass;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
