package com.example.healthlifestyle.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(
        name = "client"
)
public class Client {

    /*
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;

    @Column(
            nullable = false,
            unique = true
    )
    private String email;

    @Column(
            nullable = false
    )
    private String password;

    @Column(
            name = "date_of_birth"
    )
    private LocalDate dateOfBirth;

    private String gender;

    @Column(
            name = "height_cm"
    )
    private Integer heightCm;

    @Column(
            name = "weight_kg"
    )
    private Integer weightKg;

    @Column(
            name = "progress_data",
            columnDefinition = "json"
    )
    private String progressData;

    @Column(
            name = "profile_photo"
    )
    private String profilePhoto;

    @Column(
            name = "activity_index"
    )
    private Float activityIndex; рабочая версия до ликвидации конфликта между валидациями*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email обязателен")
    @Email(message = "Некорректный формат email")
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "date_of_birth")
    @NotNull(message = "Дата рождения обязательна")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Пол обязателен")
    private String gender;

    @Column(name = "height_cm")
    @NotNull(message = "Рост обязателен")
    @Min(value = 65, message = "Рост должен быть от 65 до 272 см")
    @Max(value = 272, message = "Рост должен быть от 65 до 272 см")
    private Integer heightCm;

    @Column(name = "weight_kg")
    @NotNull(message = "Вес обязателен")
    @Min(value = 25, message = "Вес должен быть от 25 до 150 кг")
    @Max(value = 150, message = "Вес должен быть от 25 до 150 кг")
    private Integer weightKg;

    @Column(name = "progress_data", columnDefinition = "json")
    private String progressData;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "activity_index")
    private Float activityIndex;

    public Client() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getHeightCm() {
        return this.heightCm;
    }

    public void setHeightCm(Integer heightCm) {
        this.heightCm = heightCm;
    }

    public Integer getWeightKg() {
        return this.weightKg;
    }

    public void setWeightKg(Integer weightKg) {
        this.weightKg = weightKg;
    }

    public String getProgressData() {
        return this.progressData;
    }

    public void setProgressData(String progressData) {
        this.progressData = progressData;
    }

    public String getProfilePhoto() {
        return this.profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Float getActivityIndex() {
        return this.activityIndex;
    }

    public void setActivityIndex(Float activityIndex) {
        this.activityIndex = activityIndex;
    }

    public Integer getAge() {
        if (this.dateOfBirth == null) {
            return null;
        }
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
}
