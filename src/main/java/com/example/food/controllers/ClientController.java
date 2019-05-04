package com.example.food.controllers;

import com.example.food.dto.ClientsDto;
import com.example.food.services.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientServiceImpl clientService;

    @GetMapping("/")
    public List getAllClients(@RequestParam("page") int page, @RequestParam("size") int size)
            throws IllegalAccessException {
        return clientService.getAllClients(page, size);
    }

    @PostMapping("/create")
    public ClientsDto createClients(@RequestBody @Valid ClientsDto clientsDto) {
        return clientService.createClients(clientsDto);
    }

    @GetMapping("/{id}")
    public ClientsDto getClientsById(@PathVariable("id") Long id) {
        return clientService.getClientsById(id);
    }
}
