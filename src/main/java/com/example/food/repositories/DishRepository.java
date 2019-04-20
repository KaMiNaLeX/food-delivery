package com.example.food.repositories;

import com.example.food.models.Dishes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface DishRepository extends JpaRepository<Dishes, Long> {
    @Query(value = "SELECT * FROM DISHES ", countQuery = "SELECT COUNT(*) FROM DISHES ", nativeQuery = true)
    Page<Map<String, Object>> findAllDishes(Pageable pageable);
}
