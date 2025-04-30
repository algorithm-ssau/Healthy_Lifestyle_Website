package com.example.healthlifestyle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SleepCalculatorController {
    public SleepCalculatorController() {
    }

    @GetMapping({"/sleep-calculator"})
    public String view() {
        return "sleep-calculator.html";
    }
}