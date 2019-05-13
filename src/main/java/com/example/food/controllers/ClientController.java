package com.example.food.controllers;

import com.example.food.dto.ClientsDto;
import com.example.food.services.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.security.Principal;
import java.util.ArrayList;
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

    @GetMapping("/login/{login}")
    public List getClientByLogin(@PathVariable("login") String login, Principal principal) {
        //current log-in id
        BigInteger id = clientService.getByLogin(principal.getName()).getId();
        //
        BigInteger clientid = clientService.getByLogin(login).getId();
        if (id == clientid) {
            return clientService.getClientByLogin(login);
        } else {
            return new ArrayList();
        }

    }


}
