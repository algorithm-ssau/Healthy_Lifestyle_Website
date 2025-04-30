package com.example.healthlifestyle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    public ProfileController() {
    }

    @GetMapping({"/profile"})
    public String view() {
        return "profile.html";
    }
}