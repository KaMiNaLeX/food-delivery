package com.example.food.controllers;

import com.example.food.dto.MenuDto;
import com.example.food.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;


    @PostMapping("/menu/dishes")
    public List getAllMenuDishesParam(@RequestParam("page") int page, @RequestParam("size") int size)
            throws NoSuchFieldException, IllegalAccessException {
        return menuService.getAllMenuDishesParam(page, size);
    }

    //@GetMapping("/menu/dishes")
    //public List getAllMenuDishes() throws NoSuchFieldException, IllegalAccessException {
    //      return menuService.getAllMenuDishes();
    //}

    @GetMapping("/menu")
    public List<MenuDto> getAllMenu() {
        return menuService.getAllMenu();
    }

    @PostMapping("/menu/create")
    public MenuDto createMenu(@RequestBody MenuDto menuDto) {
        return menuService.createMenu(menuDto);
    }
}
