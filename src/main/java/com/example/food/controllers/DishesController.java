package com.example.food.controllers;

import com.example.food.dto.DishesDto;
import com.example.food.services.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DishesController {
    @Autowired
    private DishesService dishesService;

    @GetMapping("/dishes")
    public List<DishesDto> getAllDishes() {
        return dishesService.getAllDishes();
    }

    @PostMapping("/dishes/create")
    public DishesDto createDish(@RequestBody DishesDto dishesDto) {
        return dishesService.createDish(dishesDto);
    }
    @PostMapping("/dishesById")
    public DishesDto getDishesById(@RequestParam("id") Long id){
        return dishesService.getDishById(id);
    }
}
