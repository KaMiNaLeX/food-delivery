package com.example.food.controllers;

import com.example.food.dto.ShoppingCartDto;
import com.example.food.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/create")
    public ShoppingCartDto createShoppingCart(@RequestBody ShoppingCartDto shoppingCartDto) {
        return shoppingCartService.createShoppingCart(shoppingCartDto);
    }

    @GetMapping("/dishes")
    public List getAllShoppingCartDishes(@RequestParam("page") int page, @RequestParam("size") int size)
            throws IllegalAccessException {
        return shoppingCartService.getAllShoppingCartDish(page, size);
    }
}
