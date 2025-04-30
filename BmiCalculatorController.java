package com.example.healthlifestyle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BmiCalculatorController {
    public BmiCalculatorController() {
    }

    @GetMapping({"/bmi-calculator"})
    public String view() {
        return "bmi-calculator.html";
    }
}
