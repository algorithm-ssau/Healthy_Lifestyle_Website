package com.example.healthlifestyle.entity;

import Conventer.JsonNodeConverter;
import com.example.healthlifestyle.models.CalculatorType;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "health_calculators")
@Data
public class HealthCalculator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Enumerated(EnumType.STRING)
    @Column(name = "calculator_type", nullable = false)
    private CalculatorType calculatorType;  // Используйте enum вместо String

    @Column(name = "input_data", columnDefinition = "json")
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode inputData;

    @Column(name = "result_data", columnDefinition = "json")
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode resultData;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    public JsonNode getResultData() {
        return this.resultData;
    }

    public LocalDateTime getDate(){
        return this.createdAt;
    }




}



