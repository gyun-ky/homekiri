package com.example.homekiri.recommendation.repository;


import com.example.homekiri.recommendation.Dto.activity.FoodActivityResponseDto;
import com.example.homekiri.recommendation.model.activity.FoodActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRecommendListRepository extends JpaRepository<FoodActivity, Long> {
    List<FoodActivity> findFoodActivitiesByIngredient(String s);
    List<FoodActivity> findFoodActivitiesByCountryIdx(Long idx);
}
