package com.example.food.services;

import com.example.food.dto.OrderMenuDto;
import com.example.food.dto.OrdersDto;

import java.util.List;

public interface OrdersService {
    List<OrdersDto> getAllOrders();

    OrdersDto createOrders(OrdersDto ordersDto);

    OrdersDto getOrderById(Long id);

    List getAllOrdersParam(String login);
}
