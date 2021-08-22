package com.example.homekiri.recommendation.repository.ActivitySpecifics;

import com.example.homekiri.recommendation.model.activity.Info.WorkoutImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutImgRepository extends JpaRepository<WorkoutImg, Long> {
    WorkoutImg findWorkoutImgByExerciseIdx(Long exerciseIdx);
}
