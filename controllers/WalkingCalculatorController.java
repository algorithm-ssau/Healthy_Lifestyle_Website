package com.example.healthlifestyle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WalkingCalculatorController {
    public WalkingCalculatorController() {
    }

    @GetMapping({"/walking-calculator"})
    public String view() {
        return "walking-calculator.html";
    }
}
