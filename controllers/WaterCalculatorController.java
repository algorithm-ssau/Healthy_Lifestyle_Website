package com.example.healthlifestyle.controllers;

import com.example.healthlifestyle.entity.Client;
import com.example.healthlifestyle.services.ClientService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WaterCalculatorController {
    private final ClientService clientService;

    public WaterCalculatorController(ClientService  clientService) {
        this.clientService = clientService;
    }


    @GetMapping({"/water-calculator"})
    public String view(Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && !auth.getName().equals("anonymousUser")) {
            Client client = clientService.findByEmail(auth.getName());
            model.addAttribute("client", client); // Добавьте эту строку
            model.addAttribute("hasProfileData", client.getWeightKg() != null);

            /* model.addAttribute("clientHeight", client.getHeightCm());
            model.addAttribute("clientWeight", client.getWeightKg());*/
        }
        return "water-calculator";
    }
}
