package com.example.food.controllers;

import com.example.food.dto.CouirersDto;
import com.example.food.models.Couirers;
import com.example.food.services.CouirersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CouirersController {
    @Autowired
    private CouirersService couirersService;

    @GetMapping("/couirers")
    public List<CouirersDto> getAllCouirers() {
        return couirersService.getAllCouirers();
    }

    @PostMapping("/couirers/create")
    public CouirersDto createCouirers(@RequestBody CouirersDto couirersDto) {
        return couirersService.createCouirers(couirersDto);
    }
}
