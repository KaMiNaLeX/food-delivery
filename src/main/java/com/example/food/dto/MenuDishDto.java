package com.example.food.dto;

import java.math.BigInteger;

public class MenuDishDto {
    private String name;
    private String description;
    private BigInteger mass;
    private String category;
    private BigInteger cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
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
}
