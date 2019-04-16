package com.example.food.services.impl;

import com.example.food.dto.DishesDto;
import com.example.food.models.Dishes;
import com.example.food.repositories.DishRepository;
import com.example.food.services.DishesService;
import com.example.food.services.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishesServiceImpl implements DishesService, ModelMapperService {
    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<DishesDto> getAllDishes() {
        List<DishesDto> dishesDtoList = new ArrayList<>();
        map(dishRepository.findAll(), dishesDtoList);
        return dishesDtoList;
    }

    @Override
    public DishesDto createDish(DishesDto dishesDto) {
        Dishes dishes = new Dishes();
        map(dishesDto, dishes);
        map((dishRepository.save(dishes)), dishesDto);
        return dishesDto;
    }
}
