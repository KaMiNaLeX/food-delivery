package com.example.food.repositories;

import com.example.food.models.Clients;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ClientRepository extends JpaRepository<Clients, Long> {
    @Query(value = "SELECT * FROM CLIENTS ", countQuery = "SELECT COUNT(*) FROM CLIENTS ", nativeQuery = true)
    Page<Map<String, Object>> findAllClients(Pageable pageable);
}
