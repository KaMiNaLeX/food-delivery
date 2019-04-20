package com.example.food.controllers;

import com.example.food.dto.DishesDto;
import com.example.food.services.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dishes")
public class DishesController {
    @Autowired
    private DishesService dishesService;

    @GetMapping("/")
    public List getAllDishes(@RequestParam("page") int page, @RequestParam("size") int size)
            throws NoSuchFieldException, IllegalAccessException {
        return dishesService.getAllDishes(page, size);
    }

    @PostMapping("/create")
    public DishesDto createDish(@RequestBody DishesDto dishesDto) {
        return dishesService.createDish(dishesDto);
    }

    @GetMapping("/{id}")
    public DishesDto getDishesById(@PathVariable("id") Long id) {
        return dishesService.getDishById(id);
    }
}
