package com.example.food.services.impl;

import com.example.food.dto.OrderMenuDto;
import com.example.food.dto.OrdersDto;
import com.example.food.models.Orders;
import com.example.food.repositories.OrderRepository;
import com.example.food.services.ModelMapperService;
import com.example.food.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public OrdersDto createOrders(OrdersDto ordersDto) {
        Orders orders = new Orders();
        map(ordersDto, orders);
        map(orderRepository.save(orders), ordersDto);
        return ordersDto;
    }

    @Override
    public OrdersDto getOrderById(Long id) {
        Optional<Orders> optionalOrders = orderRepository.findById(id);
        if (optionalOrders.isPresent()) {
            OrdersDto ordersDto = new OrdersDto();
            map(optionalOrders.get(), ordersDto);
            return ordersDto;
        }
        return null;
    }

    @Override
    public List getAllOrdersParam(String login) {
        List<OrderMenuDto> orderMenuDtoList = new ArrayList<>();
        map(orderRepository.getByLogin(login), orderMenuDtoList);
        return orderMenuDtoList;
    }
}
