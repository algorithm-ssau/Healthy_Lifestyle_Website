package com.example.healthlifestyle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WaterCalculatorController {
    public WaterCalculatorController() {
    }

    @GetMapping({"/water-calculator"})
    public String view() {
        return "water-calculator.html";
    }
}
