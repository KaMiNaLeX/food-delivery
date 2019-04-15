package com.example.food.controllers;

import com.example.food.dto.MenuDishDto;
import com.example.food.dto.MenuDto;
import com.example.food.repositories.MenuRepository;
import com.example.food.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/menu/dishes")
    public List getAllMenuDishes() throws NoSuchFieldException, IllegalAccessException {
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

    @GetMapping("/menu")
    public List<MenuDto> getAllMenu() {
        return menuService.getAllMenu();
    }

    @PostMapping("/menu/create")
    public MenuDto createMenu(@RequestBody MenuDto menuDto) {
        return menuService.createMenu(menuDto);
    }
}
