package com.example.food.services.impl;

import com.example.food.dto.ClientsDto;
import com.example.food.models.Clients;
import com.example.food.repositories.ClientRepository;
import com.example.food.services.ClientsService;
import com.example.food.services.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ModelMapperService, ClientsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientsDto> getAllClients() {
        List<ClientsDto> ClientsDtoList = new ArrayList<>();
        map(clientRepository.findAll(), ClientsDtoList);
        return ClientsDtoList;

    }

    @Override
    public ClientsDto createClients(ClientsDto clientsDto) {
        Clients clients = new Clients();
        map(clientsDto, clients);
        map(clientRepository.save(clients), clientsDto);
        return clientsDto;
    }

    @Override
    public ClientsDto getClientsById(Long id) {
        Optional<Clients> optionalClients = clientRepository.findById(id);
        if (optionalClients.isPresent()) {
            ClientsDto clientsDto = new ClientsDto();
            map(optionalClients.get(),clientsDto);
            return clientsDto;
        }
        return null;
    }
}
