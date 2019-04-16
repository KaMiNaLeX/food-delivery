package com.example.food.services;

import com.example.food.dto.DishesDto;

import java.util.List;

public interface DishesService {
    List<DishesDto> getAllDishes();

    DishesDto createDish(DishesDto dishesDto);
}
