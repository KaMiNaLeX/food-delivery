package com.example.food.controllers;

import com.example.food.dto.OrdersDto;
import com.example.food.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    public List<OrdersDto> getAllOrders() {
        return ordersService.getAllOrders();
    }
}
