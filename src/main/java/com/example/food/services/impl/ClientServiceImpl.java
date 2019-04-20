package com.example.food.services.impl;

import com.example.food.dto.ClientsDto;
import com.example.food.dto.CouirersDto;
import com.example.food.models.Clients;
import com.example.food.repositories.ClientRepository;
import com.example.food.services.ClientsService;
import com.example.food.services.ModelMapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ModelMapperService, ClientsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List getAllClients(int page, int size) throws NoSuchFieldException, IllegalAccessException {
        Pageable pageable = PageRequest.of(page, size);
        Page<Map<String, Object>> pageClients = clientRepository.findAllClients(pageable);
        List<Map<String, Object>> list = pageClients.getContent();
        List<ClientsDto> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            ClientsDto clientsDto = new ClientsDto();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Field field = ClientsDto.class.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(clientsDto, entry.getValue());
            }
            resultList.add(clientsDto);

        }
        return resultList;

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
