package com.example.healthlifestyle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalorieCalculatorController {
    public CalorieCalculatorController() {
    }

    @GetMapping({"/calorie-calculator"})
    public String view() {
        return "calorie-calculator.html";
    }
}