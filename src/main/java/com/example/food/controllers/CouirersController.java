package com.example.food.controllers;

import com.example.food.dto.CouirersDto;
import com.example.food.models.Couirers;
import com.example.food.services.CouirersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("couirers")
public class CouirersController {
    @Autowired
    private CouirersService couirersService;

    @GetMapping("/")
    public List<CouirersDto> getAllCouirers() {
        return couirersService.getAllCouirers();
    }

    @PostMapping("/create")
    public CouirersDto createCouirers(@RequestBody CouirersDto couirersDto) {
        return couirersService.createCouirers(couirersDto);
    }
}
