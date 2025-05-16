/*package com.example.healthlifestyle.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.Period;

@Data
public class ClientRegistrationDto {
    @Email(message = "Неверный формат почты")
    @NotBlank(message = "Почта обязательна")
    private String email;

    @NotBlank(message = "Пароль обязателен")
    @Size(min = 6, message = "Пароль должен содержать минимум 6 символов")
    private String password;

    @NotBlank(message = "Подтверждение пароля обязательно")
    private String confirmPassword;

    @NotNull(message = "Дата рождения обязательна")
    private LocalDate dateOfBirth;

    @AssertTrue(message = "Возраст должен быть от 7 до 100 лет")
    public boolean isValidAge() {
        if (dateOfBirth == null) return false;
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return age >= 7 && age <= 100;
    }
}*/
package com.example.healthlifestyle.dto;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.Period;

@Data
public class ClientRegistrationDto {
    @Email(message = "Неверный формат почты")
    @NotBlank(message = "Почта обязательна")
    private String email;

    @NotBlank(message = "Пароль обязателен")
    @Size(min = 6, message = "Пароль должен содержать минимум 6 символов")
    private String password;

    @NotBlank(message = "Подтверждение пароля обязательно")
    private String confirmPassword;

    @NotNull(message = "Дата рождения обязательна")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Пол обязателен")
    private String gender;

    @AssertTrue(message = "Возраст должен быть от 7 до 100 лет")
    public boolean isValidAge() {
        if (dateOfBirth == null) return false;
        int age = Period.between(dateOfBirth, LocalDate.now()).getYears();
        return age >= 7 && age <= 100;
    }
}