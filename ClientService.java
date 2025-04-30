package com.example.healthlifestyle.services;

import com.example.healthlifestyle.entity.Client;
import com.example.healthlifestyle.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return this.clientRepository.findAll();
    }

    public Optional<Client> getClientById(Integer id) {
        return this.clientRepository.findById(id);
    }

    public Client saveClient(Client client) {
        return (Client)this.clientRepository.save(client);
    }

    public void deleteClient(Integer id) {
        this.clientRepository.deleteById(id);
    }