package com.example.food.controllers;

import com.example.food.dto.ClientsDishesDto;
import com.example.food.models.ClientsDishes;
import com.example.food.services.ClientsDishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientsDishesController {
    @Autowired
    private ClientsDishesService clientsDishesService;

    @GetMapping("/clientsDishes")
    public List<ClientsDishesDto> getAllClientsDishes() {
        return clientsDishesService.getAllClientsDishes();
    }
}
