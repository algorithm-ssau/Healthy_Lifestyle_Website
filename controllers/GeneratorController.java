package com.example.healthlifestyle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneratorController {
    public GeneratorController() {
    }

    @GetMapping({"/generator"})
    public String view() {
        return "generator.html";
    }
}
