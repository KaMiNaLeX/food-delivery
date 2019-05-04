package com.example.food.controllers;

import com.example.food.dto.CouirersDto;
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
    public List getAllCouirers(@RequestParam("page") int page, @RequestParam("size") int size)
            throws IllegalAccessException {
        return couirersService.getAllCouirers(page, size);
    }

    @PostMapping("/create")
    public CouirersDto createCouirers(@RequestBody CouirersDto couirersDto) {
        return couirersService.createCouirers(couirersDto);
    }
}
