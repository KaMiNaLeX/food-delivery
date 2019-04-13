package com.example.food.services.impl;

import com.example.food.dto.MenuDto;
import com.example.food.models.Menu;
import com.example.food.repositories.MenuRepository;
import com.example.food.services.MenuService;
import com.example.food.services.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
