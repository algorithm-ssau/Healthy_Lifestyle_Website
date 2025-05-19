package com.example.healthlifestyle.models;

import java.util.List;
import java.util.Objects;

public class DayPlan {
    private String day;
    private List<Meal> meals;

    // Конструкторы
    public DayPlan() {
    }

    public DayPlan(String day, List<Meal> meals) {
        this.day = day;
        this.meals = meals;
    }

    // Геттеры и сеттеры
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    // equals, hashCode и toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayPlan dayPlan = (DayPlan) o;
        return Objects.equals(day, dayPlan.day) &&
                Objects.equals(meals, dayPlan.meals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, meals);
    }

    @Override
    public String toString() {
        return "DayPlan{" +
                "day='" + day + '\'' +
                ", meals=" + meals +
                '}';
    }
}