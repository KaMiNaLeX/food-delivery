package com.example.food.services.impl;

import com.example.food.dto.MenuDishDto;
import com.example.food.dto.MenuDto;
import com.example.food.models.Menu;
import com.example.food.repositories.MenuRepository;
import com.example.food.services.MenuService;
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

@Service
public class MenuServiceImpl implements MenuService, ModelMapperService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<MenuDto> getAllMenu() {
        List<MenuDto> menuDtoList = new ArrayList<>();
        map(menuRepository.findAll(), menuDtoList);
        return menuDtoList;
    }

    @Override
    public MenuDto createMenu(MenuDto menuDto) {
        Menu menu = new Menu();
        map(menuDto, menu);
        map(menuRepository.save(menu), menuDto);
        return menuDto;
    }

    @Override
    public List getAllMenuDishes() throws NoSuchFieldException, IllegalAccessException{
        Pageable pageable = PageRequest.of(0, 6);
        Page<Map<String, Object>> pageDishes = menuRepository.findAllDishes(pageable);
        List<Map<String, Object>> list = pageDishes.getContent();
        List<MenuDishDto> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            MenuDishDto menuDishDto = new MenuDishDto();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Field field = MenuDishDto.class.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(menuDishDto, entry.getValue());
            }
            resultList.add(menuDishDto);

        }
        return resultList;
    }
}
