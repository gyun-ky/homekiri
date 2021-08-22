package com.example.homekiri.recommendation.repository;

import com.example.homekiri.recommendation.Dto.activity.WorkoutActivityResponseDto;
import com.example.homekiri.recommendation.model.activity.WorkoutActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRecommendListRepository extends JpaRepository<WorkoutActivity, Long> {
}
