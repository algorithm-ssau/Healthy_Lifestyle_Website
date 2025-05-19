package com.example.healthlifestyle.models;

import com.example.healthlifestyle.models.DayPlan;

import java.util.List;
import java.util.Objects;

public class MealPlan {
    private List<DayPlan> days;

    // Конструкторы
    public MealPlan() {
    }

    public MealPlan(List<DayPlan> days) {
        this.days = days;
    }

    // Геттеры и сеттеры
    public List<DayPlan> getDays() {
        return days;
    }

    public void setDays(List<DayPlan> days) {
        this.days = days;
    }

    // equals, hashCode и toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealPlan mealPlan = (MealPlan) o;
        return Objects.equals(days, mealPlan.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days);
    }

    @Override
    public String toString() {
        return "MealPlan{" +
                "days=" + days +
                '}';
    }
}