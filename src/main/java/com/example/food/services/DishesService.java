package com.example.food.services;

import com.example.food.dto.DishesDto;

import java.util.List;

public interface DishesService {
    List getAllDishes(int page, int size) throws NoSuchFieldException, IllegalAccessException;

    DishesDto createDish(DishesDto dishesDto);

    DishesDto getDishById(Long id);

}
