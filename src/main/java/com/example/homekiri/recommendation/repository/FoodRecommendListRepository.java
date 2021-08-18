package com.example.homekiri.recommendation.repository;


import com.example.homekiri.recommendation.Dto.activity.FoodActivityResponseDto;
import com.example.homekiri.recommendation.model.activity.FoodActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRecommendListRepository extends JpaRepository<FoodActivity, Long> {
}
