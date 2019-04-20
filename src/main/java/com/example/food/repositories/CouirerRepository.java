package com.example.food.repositories;

import com.example.food.models.Couirers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CouirerRepository extends JpaRepository<Couirers, Long> {
    @Query(value = "SELECT * FROM COUIRERS ", countQuery = "SELECT COUNT(*) FROM COUIRERS ", nativeQuery = true)
    Page<Map<String, Object>> findAllCouirers(Pageable pageable);
}
