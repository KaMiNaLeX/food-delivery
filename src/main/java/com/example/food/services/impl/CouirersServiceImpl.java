package com.example.food.services.impl;

import com.example.food.dto.CouirersDto;
import com.example.food.models.Couirers;
import com.example.food.repositories.CouirerRepository;
import com.example.food.services.CouirersService;
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

@Service
public class CouirersServiceImpl implements CouirersService, ModelMapperService {
    @Autowired
    private CouirerRepository couirerRepository;

    public List getAllCouirers(int page, int size)
            throws NoSuchFieldException, IllegalAccessException {
        Pageable pageable = PageRequest.of(page, size);
        Page<Map<String, Object>> pageCouirers = couirerRepository.findAllCouirers(pageable);
        List<Map<String, Object>> list = pageCouirers.getContent();
        List<CouirersDto> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            CouirersDto couirersDto = new CouirersDto();
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Field field = CouirersDto.class.getDeclaredField(entry.getKey());
                field.setAccessible(true);
                field.set(couirersDto, entry.getValue());
            }
            resultList.add(couirersDto);

        }
        return resultList;
    }

    public CouirersDto createCouirers(CouirersDto couirersDto) {
        Couirers couirers = new Couirers();
        map(couirersDto, couirers);
        map(couirerRepository.save(couirers), couirersDto);
        return couirersDto;
    }
}
