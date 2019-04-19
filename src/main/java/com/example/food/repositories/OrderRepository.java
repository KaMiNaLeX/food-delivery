package com.example.food.repositories;

import com.example.food.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT O.ID ,C.LOGIN,C.PHONE,C.ADDRESS,O.SUM FROM CLIENTS C " +
            "INNER JOIN ORDERS O  ON O.CLIENT_ID = C.ID WHERE C.LOGIN=:LOGIN", countQuery = "SELECT COUNT(*) FROM CLIENTS C " +
            "INNER JOIN ORDERS O ON O.CLIENT_ID = C.ID WHERE C.LOGIN=:LOGIN", nativeQuery = true)
    List<Map<String, Object>> getByLogin(@Param("LOGIN") String login);

}
