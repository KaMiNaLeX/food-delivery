package com.example.food.services;

import com.example.food.dto.MenuDto;

import java.util.List;

public interface MenuService {
    List<MenuDto> getAllMenu();

    MenuDto createMenu(MenuDto menuDto);

    List getAllMenuDishesParam(int page, int size) throws IllegalAccessException;
}
