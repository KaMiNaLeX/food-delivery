package com.example.food.controllers;

import com.example.food.dto.adminDto.DishesDto;
import com.example.food.dto.clientDto.DishMenuDto;
import com.example.food.services.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("dishes")
public class DishesController {
    private static String UPLOADED_FOLDER = "D://DOWNLOAD//Универ//III курс//2 сем//ПСКП//курсач//food(2)//src//main//resources//static//images";
    @Autowired
    private DishesService dishesService;

    @GetMapping("/")
    public List getAllDishes(@RequestParam("page") int page, @RequestParam("size") int size)
            throws IllegalAccessException {
        return dishesService.getAllDishes(page, size);
    }

    @GetMapping("/menu/")
    public List findAllDishesMenu(@RequestParam("page") int page, @RequestParam("size") int size)
            throws IllegalAccessException {
        return dishesService.findAllDishesMenu(page, size);
    }

    @PostMapping("/create")
    public DishesDto createDish(@RequestBody DishesDto dishesDto) {
        return dishesService.createDish(dishesDto);
    }

    @GetMapping("/{id}")
    public DishesDto getDishesById(@PathVariable("id") Long id) {
        return dishesService.getDishById(id);
    }

    @GetMapping("/category/{category}")
    public List getAllDishesByCategory(@PathVariable("category") String category) {
        return dishesService.getAllDishesByCategory(category);
    }

    @GetMapping("/id/{id}")
    public DishMenuDto getById(@PathVariable("id") Long id) {
        return dishesService.ById(id);
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "index";
    }


}