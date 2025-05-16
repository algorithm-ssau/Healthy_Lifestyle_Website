package com.example.healthlifestyle.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CalculatorsContoller {
    public CalculatorsContoller() {
    }

    @GetMapping({"/calculators"})
    public String view() {
        return "calculators.html";
    }
}
