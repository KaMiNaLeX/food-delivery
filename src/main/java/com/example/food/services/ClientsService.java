package com.example.food.services;

import com.example.food.dto.ClientsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientsService {
    List getAllClients(int page, int size) throws NoSuchFieldException, IllegalAccessException;

    ClientsDto createClients(ClientsDto clientsDto);

    ClientsDto getClientsById(Long id);
}
