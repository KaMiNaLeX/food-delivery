package com.example.food.services;

import com.example.food.dto.CouirersDto;

import java.util.List;

public interface CouirersService {
    List getAllCouirers(int page, int size) throws IllegalAccessException;

    CouirersDto createCouirers(CouirersDto couirersDto);
}
