
package com.example.healthlifestyle.services;

import com.example.healthlifestyle.entity.Client;
import com.example.healthlifestyle.repository.ClientRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ClientService implements UserDetailsService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public ClientService(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));

        return User.builder()
                .username(client.getEmail())
                .password(client.getPassword())
                .roles("USER")
                .build();
    }

    @Transactional(readOnly = true)
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + email + " not found"));
    }

    @Transactional
    public Client registerClient(Client client) {
        if (clientRepository.existsByEmail(client.getEmail())) {
            throw new IllegalArgumentException("Аккаунт с таким email уже существует");
        }

        if (client.getDateOfBirth() != null) {
            int age = Period.between(client.getDateOfBirth(), LocalDate.now()).getYears();
            if (age < 7 || age > 100) {
                throw new IllegalArgumentException("Возраст должен быть от 7 до 100 лет");
            }
        }

        client.setPassword(passwordEncoder.encode(client.getPassword()));
        return clientRepository.save(client);
    }

    @Transactional
    public Client updateClient(Client updatedClient) {
        Client existingClient = findByEmail(updatedClient.getEmail());

        if (updatedClient.getHeightCm() != null) {
            validateHeight(updatedClient.getHeightCm());
            existingClient.setHeightCm(updatedClient.getHeightCm());
        }

        if (updatedClient.getWeightKg() != null) {
            validateWeight(updatedClient.getWeightKg());
            existingClient.setWeightKg(updatedClient.getWeightKg());
        }

        if (updatedClient.getDateOfBirth() != null) {
            validateAge(updatedClient.getDateOfBirth());
            existingClient.setDateOfBirth(updatedClient.getDateOfBirth());
        }

        if (updatedClient.getActivityIndex() != null) {
            validateActivityIndex(updatedClient.getActivityIndex());
            existingClient.setActivityIndex(updatedClient.getActivityIndex());
        }

        if (updatedClient.getGender() != null) {
            existingClient.setGender(updatedClient.getGender());
        }

        return clientRepository.save(existingClient);
    }

    @Transactional
    public void deleteClient(String email) {
        if (!clientRepository.existsByEmail(email)) {
            throw new UsernameNotFoundException("User not found");
        }
        clientRepository.deleteByEmail(email);
    }

    @Transactional(readOnly = true)
    public boolean hasProfileData(String email) {
        Client client = findByEmail(email);
        return client.getHeightCm() != null &&
                client.getWeightKg() != null &&
                client.getDateOfBirth() != null &&
                client.getGender() != null;
    }

    private void validateHeight(Integer heightCm) {
        if (heightCm < 65 || heightCm > 272) {
            throw new IllegalArgumentException("Рост должен быть от 65 до 272 см");
        }
    }

    private void validateWeight(Integer weightKg) {
        if (weightKg < 25 || weightKg > 150) {
            throw new IllegalArgumentException("Вес должен быть от 25 до 150 кг");
        }
    }

    private void validateAge(LocalDate dateOfBirth) {
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        if (age < 7 || age > 85) {
            throw new IllegalArgumentException("Возраст должен быть от 7 до 85 лет");
        }
    }

    private void validateActivityIndex(Float activityIndex) {
        float[] validValues = {1.2f, 1.375f, 1.55f, 1.725f, 1.9f};
        for (float value : validValues) {
            if (Math.abs(activityIndex - value) < 0.001f) {
                return;
            }
        }
        throw new IllegalArgumentException("Некорректный индекс активности");
    }
}





