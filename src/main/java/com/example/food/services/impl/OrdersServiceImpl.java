package com.example.food.services.impl;

import com.example.food.dto.DishesDto;
import com.example.food.dto.OrderMenuDto;
import com.example.food.dto.OrdersDto;
import com.example.food.models.Orders;
import com.example.food.repositories.OrderRepository;
import com.example.food.services.ModelMapperService;
import com.example.food.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService, ModelMapperService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List getAllOrders(int page, int size) throws NoSuchFieldException, IllegalAccessException {
        Pageable pageable = PageRequest.of(page, size);
        Page<Map<String, Object>> pageOrders = orderRepository.findAllOrders(pageable);
        List<Map<String, Object>> list = pageOrders.getContent();
        List<OrdersDto> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            OrdersDto ordersDto = new OrdersDto();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Field field = OrdersDto.class.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(ordersDto, entry.getValue());
            }
            resultList.add(ordersDto);

        }
        return resultList;
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
