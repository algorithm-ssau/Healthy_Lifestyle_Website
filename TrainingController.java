package com.example.healthlifestyle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainingController {
    public TrainingController() {
    }

    @GetMapping({"/train"})
    public String view() {
        return "train.html";
    }
}
