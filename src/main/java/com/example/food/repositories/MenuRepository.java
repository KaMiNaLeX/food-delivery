package com.example.food.repositories;

import com.example.food.models.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query(value = "SELECT D.NAME ,M.CATEGORY, M.COST FROM MENU M " +
            "INNER JOIN DISHES D ON M.DISH_ID = D.ID", countQuery = "SELECT COUNT(*) FROM MENU M " +
            "INNER JOIN DISHES D ON M.DISH_ID = D.ID ", nativeQuery = true)
    Page<Map<String, Object>> findAllDishes(Pageable pageable);
}

