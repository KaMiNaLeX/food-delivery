package com.example.food.services;

import org.modelmapper.ModelMapper;

import java.util.List;

public interface ModelMapperService {
    default void map(Object src, Object dest) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(src, dest);
    }

    default void map(List src, List dest) {
        dest.addAll(src);
    }
}
