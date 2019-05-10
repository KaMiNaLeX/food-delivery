package com.example.food.controllers;

import com.example.food.dto.adminDto.OrdersDto;
import com.example.food.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/create")
    public OrdersDto createOrder(@RequestBody OrdersDto ordersDto) {
        return ordersService.createOrders(ordersDto);
    }

    ///Вывод блюд надо сделать
    @GetMapping("/")
    public List getAllOrders(@RequestParam("page") int page, @RequestParam("size") int size)
            throws  IllegalAccessException {
        return ordersService.getAllOrders(page, size);
    }

    @GetMapping("/{id}")
    public OrdersDto getOrderById(@PathVariable("id") Long id) {
        return ordersService.getOrderById(id);
    }

    @GetMapping("/login/{login}")
    public List getAllOrdersParam(@PathVariable("login") String login) {
        return ordersService.getAllOrdersParam(login);
    }
}
