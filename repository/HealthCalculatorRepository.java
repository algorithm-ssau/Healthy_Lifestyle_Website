package com.example.healthlifestyle.repository;

import com.example.healthlifestyle.entity.HealthCalculator;
import com.example.healthlifestyle.models.CalculatorType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface HealthCalculatorRepository extends JpaRepository<HealthCalculator, Integer> {
    List<HealthCalculator> findByClientId(Integer clientId);
    // Получение последних записей ИМТ для клиента
    @Query("SELECT h FROM HealthCalculator h WHERE h.client.id = :clientId AND h.calculatorType = 'BMI' ORDER BY h.createdAt DESC")
    List<HealthCalculator> findBmiHistoryByClientId(@Param("clientId") Integer clientId);

    // Получение последних записей по дням
    @Query("SELECT h FROM HealthCalculator h WHERE h.client.id = :clientId AND h.calculatorType = 'BMI' AND h.createdAt >= :startDate ORDER BY h.createdAt DESC")
    List<HealthCalculator> findBmiHistoryByPeriod(
            @Param("clientId") Integer clientId,
            @Param("startDate") LocalDateTime startDate);

    // Получение последней записи за каждый месяц
    @Query("SELECT h FROM HealthCalculator h WHERE h.id IN (" +
            "SELECT MAX(h2.id) FROM HealthCalculator h2 " +
            "WHERE h2.client.id = :clientId AND h2.calculatorType = 'BMI' " +
            "AND h2.createdAt >= :startDate " +
            "GROUP BY FUNCTION('MONTH', h2.createdAt), FUNCTION('YEAR', h2.createdAt)) " +
            "ORDER BY h.createdAt DESC")
    List<HealthCalculator> findMonthlyBmiHistory(@Param("clientId") Integer clientId,
                                                 @Param("startDate") LocalDateTime startDate);

    @Query("SELECT h FROM HealthCalculator h WHERE h.id IN (" +
            "SELECT MAX(h2.id) FROM HealthCalculator h2 " +
            "WHERE h2.client.id = :clientId AND h2.calculatorType = 'BMI' " +
            "AND h2.createdAt >= :startDate " +
            "GROUP BY FUNCTION('DATE', h2.createdAt)) " +
            "ORDER BY h.createdAt DESC")
    List<HealthCalculator> findDailyBmiHistory(@Param("clientId") Integer clientId,
                                               @Param("startDate") LocalDateTime startDate);


}