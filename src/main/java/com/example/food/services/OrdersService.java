package com.example.food.services;

import com.example.food.dto.OrdersDto;

import java.util.List;

public interface OrdersService {
    List getAllOrders(int page, int size) throws NoSuchFieldException, IllegalAccessException;

    OrdersDto createOrders(OrdersDto ordersDto);

    OrdersDto getOrderById(Long id);

    List getAllOrdersParam(String login);
}
