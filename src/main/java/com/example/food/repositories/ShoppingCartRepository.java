package com.example.food.repositories;

import com.example.food.models.ShoppingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    @Query(value = "SELECT S.id ,D.name,S.count,S.sum FROM SHOPPING_CART S " +
            "INNER JOIN MENU M ON M.id = S.menu_id " +
            "INNER JOIN DISHES D ON D.id = M.dish_id"
            , countQuery = "SELECT COUNT(*) FROM SHOPPING_CART S " +
            "INNER JOIN MENU M ON M.id = S.menu_id " +
            "INNER JOIN DISHES D ON D.id = M.dish_id", nativeQuery = true)
    Page<Map<String, Object>> findAllShoppingCartDishes(Pageable pageable);
}
