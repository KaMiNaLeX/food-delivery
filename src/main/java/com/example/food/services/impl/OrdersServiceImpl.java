package com.example.food.services.impl;

import com.example.food.dto.OrdersDto;
import com.example.food.repositories.OrderRepository;
import com.example.food.services.ModelMapperService;
import com.example.food.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService, ModelMapperService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrdersDto> getAllOrders() {
        List<OrdersDto> ordersDtoList = new ArrayList<>();
        map(orderRepository.findAll(), ordersDtoList);
        return ordersDtoList;
    }
}
