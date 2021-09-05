package com.example.homekiri.recommendation.repository;

import com.example.homekiri.dessert.model.DessertActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DessertRecommendListRepository extends JpaRepository<DessertActivity, Long> {

}
