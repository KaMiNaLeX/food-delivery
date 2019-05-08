package com.example.food.services.impl;

import com.example.food.dto.ShoppingCartDishDto;
import com.example.food.dto.ShoppingCartDto;
import com.example.food.models.ShoppingCart;
import com.example.food.repositories.ShoppingCartRepository;
import com.example.food.services.ModelMapperService;
import com.example.food.services.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService, ModelMapperService {
    private final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);
    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCartDto createShoppingCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        map(shoppingCartDto, shoppingCart);
        map(shoppingCartRepository.save(shoppingCart), shoppingCartDto);
        LOGGER.info("Shopping_cart create");
        return shoppingCartDto;
    }

    @Override
    public List getAllShoppingCartDish(int page, int size) throws IllegalAccessException {
        Pageable pageable = PageRequest.of(page, size);
        Page<Map<String, Object>> pageShoppingCartDishes = shoppingCartRepository.findAllShoppingCartDishes(pageable);
        List<Map<String, Object>> list = pageShoppingCartDishes.getContent();
        List<ShoppingCartDishDto> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            ShoppingCartDishDto shoppingCartDishDto = new ShoppingCartDishDto();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Field field = null;
                try {
                    field = ShoppingCartDishDto.class.getDeclaredField(entry.getKey());
                } catch (NoSuchFieldException e) {
                    LOGGER.error("getAllShoppingCartDish:NoSuchFieldException");
                }
                field.setAccessible(true);
                field.set(shoppingCartDishDto, entry.getValue());
            }
            resultList.add(shoppingCartDishDto);

        }
        return resultList;
    }


}
