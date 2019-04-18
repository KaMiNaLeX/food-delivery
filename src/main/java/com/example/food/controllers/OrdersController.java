package com.example.food.controllers;

import com.example.food.dto.OrderMenuDto;
import com.example.food.dto.OrdersDto;
import com.example.food.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/orders/create")
    public OrdersDto createOrder(@RequestBody OrdersDto ordersDto) {
        return ordersService.createOrders(ordersDto);
    }

    @GetMapping("/orders")
    public List<OrdersDto> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @PostMapping("/ordersById")
    public OrdersDto getOrderById(@RequestParam("id") Long id) {
        return ordersService.getOrderById(id);
    }

    @PostMapping("/ordersByLogin")
    public List<OrderMenuDto> getAllOrdersParam(@RequestParam("page") int page, @RequestParam("size") int size)
            throws NoSuchFieldException, IllegalAccessException {
        return ordersService.getAllOrdersParam(page, size);
    }
}
