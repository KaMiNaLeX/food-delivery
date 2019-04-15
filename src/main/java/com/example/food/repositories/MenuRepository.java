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
    @Query(value = "select D.name ,M.category, M.cost from Menu M " +
            "inner join Dishes D on M.dish_id = D.id", nativeQuery = true)
    Page<Map<String, Object>> findAllDishes(Pageable pageable);
}

