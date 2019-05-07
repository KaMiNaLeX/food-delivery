package com.example.food.repositories;

import com.example.food.models.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query(value = "SELECT D.name ,D.description,D.mass,M.category, M.cost FROM MENU M " +
            "INNER JOIN DISHES D ON M.dish_id = D.id ", countQuery = "SELECT COUNT(*) FROM MENU M " +
            "INNER JOIN DISHES D ON M.dish_id = D.id ", nativeQuery = true)
    Page<Map<String, Object>> findAllMenuDishes(Pageable pageable);

    @Query(value = "SELECT D.name ,D.description,D.mass,M.category, M.cost FROM MENU M " +
            "INNER JOIN DISHES D ON M.dish_id = D.id WHERE M.category=:category", countQuery = "SELECT COUNT(*) FROM MENU M " +
            "INNER JOIN DISHES D ON M.dish_id = D.id WHERE M.category=:category", nativeQuery = true)
    List<Map<String, Object>> getByCategory(@Param("category") String category);
}

