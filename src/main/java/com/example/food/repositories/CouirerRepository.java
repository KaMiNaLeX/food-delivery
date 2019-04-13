package com.example.food.repositories;

import com.example.food.models.Couirers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouirerRepository extends JpaRepository<Couirers, Long> {
}
