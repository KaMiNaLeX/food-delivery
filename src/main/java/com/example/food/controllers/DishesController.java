package com.example.food.controllers;

import com.example.food.dto.adminDto.DishesDto;
import com.example.food.services.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dishes")
public class DishesController {
    @Autowired
    private DishesService dishesService;

    //!!!!!!!!!не работает
    @GetMapping("/")
    public List getAllDishes(@RequestParam("page") int page, @RequestParam("size") int size)
            throws IllegalAccessException {
        return dishesService.getAllDishes(page, size);
    }

    @GetMapping("/menu/")
    public List findAllDishesMenu(@RequestParam("page") int page, @RequestParam("size") int size)
            throws IllegalAccessException {
        return dishesService.findAllDishesMenu(page, size);
    }

    @PostMapping("/create")
    public DishesDto createDish(@RequestBody DishesDto dishesDto) {
        return dishesService.createDish(dishesDto);
    }

    @GetMapping("/{id}")
    public DishesDto getDishesById(@PathVariable("id") Long id) {
        return dishesService.getDishById(id);
    }

    @GetMapping("/category/{category}")
    public List getAllDishesByCategory(@PathVariable("category") String category) {
        return dishesService.getAllDishesByCategory(category);
    }
}
