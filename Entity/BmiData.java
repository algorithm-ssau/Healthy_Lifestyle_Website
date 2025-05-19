package com.example.healthlifestyle.entity;/*package com.example.healthlifestyle.entity;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class BmiData {
    @NotNull(message = "Рост обязателен")
    @Min(value = 65, message = "Рост должен быть не менее 65 см")
    @Max(value = 272, message = "Рост должен быть не более 272 см")
    private Integer height;

    @NotNull(message = "Вес обязателен")
    @Min(value = 25, message = "Вес должен быть не менее 25 кг")
    @Max(value = 150, message = "Вес должен быть не более 150 кг")
    private Integer weight;

    @NotNull(message = "ИМТ обязателен")
    @DecimalMin(value = "10.0", message = "ИМТ должен быть не менее 10")
    @DecimalMax(value = "50.0", message = "ИМТ должен быть не более 50")
    private Double bmi;

    @NotBlank(message = "Интерпретация обязательна")
    private String interpretation;
} раьочая версия*/



import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

public class BmiData {
    @NotNull(message = "Рост обязателен")
    @Min(value = 65, message = "Рост должен быть не менее 65 см")
    @Max(value = 272, message = "Рост должен быть не более 272 см")
    private Integer height;

    @NotNull(message = "Вес обязателен")
    @Min(value = 25, message = "Вес должен быть не менее 25 кг")
    @Max(value = 150, message = "Вес должен быть не более 150 кг")
    private Integer weight;

    private Double bmi;
    private String interpretation;

    // Геттеры и сеттеры
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }
}
