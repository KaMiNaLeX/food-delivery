package com.example.food.controllers;

import com.example.food.dto.DishesDto;
import com.example.food.models.Dishes;
import com.example.food.services.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
    public DishesDto createDish(@RequestBody @Valid DishesDto dishesDto, BindingResult brDishesDto){
   //     System.out.println("lexa pidor");
     //   return null;
    }
}
