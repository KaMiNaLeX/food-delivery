package com.example.food.services.impl;

import com.example.food.dto.CouirersDto;
import com.example.food.models.Couirers;
import com.example.food.repositories.CouirerRepository;
import com.example.food.services.CouirersService;
import com.example.food.services.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouirersServiceImpl implements CouirersService, ModelMapperService {
    @Autowired
    private CouirerRepository couirerRepository;

    public List<CouirersDto> getAllCouirers() {
        List<CouirersDto> couirersDtoList = new ArrayList<>();
        map(couirerRepository.findAll(), couirersDtoList);
        return couirersDtoList;
    }

    public CouirersDto createCouirers(CouirersDto couirersDto) {
        Couirers couirers = new Couirers();
        map(couirersDto, couirers);
        map(couirerRepository.save(couirers), couirersDto);
        return couirersDto;
    }
}
