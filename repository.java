package com.example.healthlifestyle.repository;

import com.example.healthlifestyle.entity.Client;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(
            value = "SELECT * FROM client",
            nativeQuery = true
    )
    List<Client> findAllClientsNative();
}