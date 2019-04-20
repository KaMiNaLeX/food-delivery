package com.example.food.services.impl;

import com.example.food.dto.DishesDto;
import com.example.food.models.Dishes;
import com.example.food.repositories.DishRepository;
import com.example.food.services.DishesService;
import com.example.food.services.ModelMapperService;
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
public class DishesServiceImpl implements DishesService, ModelMapperService {
    @Autowired
    private DishRepository dishRepository;

    @Override
    public List getAllDishes(int page,int size) throws NoSuchFieldException, IllegalAccessException{
        Pageable pageable = PageRequest.of(page, size);
        Page<Map<String, Object>> pageDishes = dishRepository.findAllDishes(pageable);
        List<Map<String, Object>> list = pageDishes.getContent();
        List<DishesDto> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            DishesDto dishesDto = new DishesDto();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Field field = DishesDto.class.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(dishesDto, entry.getValue());
            }
            resultList.add(dishesDto);

        }
        return resultList;
    }

    @Override
    public DishesDto createDish(DishesDto dishesDto) {
        Dishes dishes = new Dishes();
        map(dishesDto, dishes);
        map((dishRepository.save(dishes)), dishesDto);
        return dishesDto;
    }

    @Override
    public DishesDto getDishById(Long id) {
        Optional<Dishes> optionalDishes = dishRepository.findById(id);
        if (optionalDishes.isPresent()) {
            DishesDto dishesDto = new DishesDto();
            map(optionalDishes.get(), dishesDto);
            return dishesDto;
        }
        return null;
    }
}
