package com.example.food.controllers;

import com.example.food.dto.ClientsDto;
import com.example.food.models.Clients;
import com.example.food.services.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/clients")
    public List<ClientsDto> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("/clients/create")
    public ClientsDto createClients(@RequestBody @Valid ClientsDto clientsDto) {
        return clientService.createClients(clientsDto);
    }
}
