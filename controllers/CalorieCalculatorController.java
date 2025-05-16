/*package com.example.healthlifestyle.controllers;

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
package com.example.healthlifestyle.controllers;

import com.example.healthlifestyle.entity.Client;
import com.example.healthlifestyle.services.ClientService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Period;

@Controller
public class CalorieCalculatorController {
    private final ClientService clientService;

    public CalorieCalculatorController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/calorie-calculator")
    public String view(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && !auth.getName().equals("anonymousUser")) {
            Client client = clientService.findByEmail(auth.getName());
            boolean hasProfileData = client.getHeightCm() != null ||
                    client.getWeightKg() != null ||
                    client.getDateOfBirth() != null ||
                    client.getGender() != null;

            model.addAttribute("hasProfileData", hasProfileData);
            model.addAttribute("clientHeight", client.getHeightCm());
            model.addAttribute("clientWeight", client.getWeightKg());
            model.addAttribute("clientAge", client.getDateOfBirth() != null ?
                    Period.between(client.getDateOfBirth(), LocalDate.now()).getYears() : null);
            model.addAttribute("clientGender", client.getGender());
        }
        return "calorie-calculator";
    }
}*/
package com.example.healthlifestyle.controllers;

import com.example.healthlifestyle.entity.Client;
import com.example.healthlifestyle.services.ClientService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Period;

@Controller
public class CalorieCalculatorController {
    private final ClientService clientService;

    public CalorieCalculatorController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/calorie-calculator")
    public String view(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && !auth.getName().equals("anonymousUser")) {
            Client client = clientService.findByEmail(auth.getName());

            model.addAttribute("hasProfileData",
                    client.getHeightCm() != null ||
                            client.getWeightKg() != null ||
                            client.getDateOfBirth() != null ||
                            client.getGender() != null);

            model.addAttribute("clientHeight", client.getHeightCm());
            model.addAttribute("clientWeight", client.getWeightKg());
            model.addAttribute("clientAge",
                    client.getDateOfBirth() != null ?
                            Period.between(client.getDateOfBirth(), LocalDate.now()).getYears() : null);
            model.addAttribute("clientGender", client.getGender());
        }
        return "calorie-calculator";
    }
}




