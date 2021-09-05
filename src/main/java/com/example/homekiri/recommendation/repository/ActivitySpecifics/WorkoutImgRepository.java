package com.example.homekiri.recommendation.repository.ActivitySpecifics;

import com.example.homekiri.exercise.model.WorkoutImg;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutImgRepository extends JpaRepository<WorkoutImg, Long> {
    WorkoutImg findWorkoutImgByExerciseIdx(Long exerciseIdx);
}
