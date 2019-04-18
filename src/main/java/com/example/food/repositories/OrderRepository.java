package com.example.food.repositories;

import com.example.food.models.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT O.id ,C.login,C.phone,C.address,O.sum FROM ORDERS O " +
            "INNER JOIN CLIENTS C ON O.client_id = C.id", countQuery = "SELECT COUNT(*) FROM ORDERS O " +
            "INNER JOIN CLIENTS C ON O.client_id = C.id ", nativeQuery = true)
    Page<Map<String, Object>> findAllOrders(Pageable pageable);
}
