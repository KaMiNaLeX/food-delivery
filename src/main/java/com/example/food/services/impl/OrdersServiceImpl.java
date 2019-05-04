package com.example.food.services.impl;

import com.example.food.dto.OrderMenuDto;
import com.example.food.dto.OrdersDto;
import com.example.food.models.Orders;
import com.example.food.repositories.OrderRepository;
import com.example.food.services.ModelMapperService;
import com.example.food.services.OrdersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService, ModelMapperService {
    private final Logger LOGGER = LoggerFactory.getLogger(OrdersServiceImpl.class);
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List getAllOrders(int page, int size) throws IllegalAccessException {
        Pageable pageable = PageRequest.of(page, size);
        Page<Map<String, Object>> pageOrders = orderRepository.findAllOrders(pageable);
        List<Map<String, Object>> list = pageOrders.getContent();
        List<OrdersDto> resultList = new ArrayList<>();
        try  {
            mapListMapToDto(list, resultList, OrdersDto.class);
        } catch (NoSuchMethodException e) {
            LOGGER.error("getAllOrders:NoSuchMethodException");
        } catch (InvocationTargetException e) {
            LOGGER.error("getAllOrders:InvocationTargetException");
        } catch (InstantiationException e) {
            LOGGER.error("getAllOrders:InstantiationException");
        }
        return resultList;
    }

    @Override
    public OrdersDto createOrders(OrdersDto ordersDto) {
        Orders orders = new Orders();
        map(ordersDto, orders);
        map(orderRepository.save(orders), ordersDto);
        LOGGER.info("Order create");
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
