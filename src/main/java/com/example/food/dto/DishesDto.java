package com.example.food.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigInteger;

public class DishesDto implements Serializable {
    private BigInteger id;
    private String description;
    @NotNull
    private BigInteger mass;
    @Pattern(regexp = "^\\w{2,45}$")
    private String name;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
