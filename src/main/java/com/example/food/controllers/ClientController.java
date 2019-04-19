package com.example.food.controllers;

import com.example.food.dto.ClientsDto;
import com.example.food.models.Clients;
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
    public List<ClientsDto> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("/create")
    public ClientsDto createClients(@RequestBody @Valid ClientsDto clientsDto) {
        return clientService.createClients(clientsDto);
    }

    @GetMapping("/{id}")
    public ClientsDto getClientsById(@PathVariable ("id") Long id){
        return  clientService.getClientsById(id);
    }
}
