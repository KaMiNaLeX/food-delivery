package com.example.food.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/about")
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/check-out")
    public String checkout(){
        return "check-out";
    }

    @RequestMapping(value = "/listing")
    public String listing(){
        return "listing";
    }

    @RequestMapping(value = "/single")
    public String single(){
        return "single";
    }

    @RequestMapping(value = "/orders")
    public String orders() {
        return "orders";
    }
}
