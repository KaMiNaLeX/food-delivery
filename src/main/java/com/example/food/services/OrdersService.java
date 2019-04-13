package com.example.food.services;

import com.example.food.dto.OrdersDto;

import java.util.List;

public interface OrdersService {
    List<OrdersDto> getAllOrders();
}
