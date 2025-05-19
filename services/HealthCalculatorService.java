package com.example.healthlifestyle.services;

import com.example.healthlifestyle.entity.HealthCalculator;
import com.example.healthlifestyle.repository.HealthCalculatorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HealthCalculatorService {
    private final HealthCalculatorRepository healthCalculatorRepository;

    public HealthCalculatorService(HealthCalculatorRepository healthCalculatorRepository) {
        this.healthCalculatorRepository = healthCalculatorRepository;
    }

    public HealthCalculator saveCalculatorData(HealthCalculator calculatorData) {
        return healthCalculatorRepository.save(calculatorData);
    }

    public List<HealthCalculator> getCalculatorDataByClientId(Integer clientId) {
        return healthCalculatorRepository.findByClientId(clientId);
    }
}