package com.example.healthlifestyle.controllers;

import com.example.healthlifestyle.entity.Client;
import com.example.healthlifestyle.services.ClientService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping({"/get_clients"})
    public List<Client> getAllClients() {
        return this.clientService.getAllClients();
    }
}
