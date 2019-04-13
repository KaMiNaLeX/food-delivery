package com.example.food.services;

import com.example.food.dto.CouirersDto;

import java.util.List;

public interface CouirersService {
    List<CouirersDto> getAllCouirers();

    CouirersDto createCouirers(CouirersDto couirersDto);
}
