package com.example.food.services;

import com.example.food.dto.ShoppingCartDishDto;
import com.example.food.dto.ShoppingCartDto;

import java.util.List;

public interface ShoppingCartService {

    ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCartDto);

    List getAllShoppingCartDish(int page, int size) throws IllegalAccessException;
}
