package com.example.homekiri.exercise.repository;

import com.example.homekiri.exercise.model.WorkoutVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutVideoRepository extends JpaRepository<WorkoutVideo, Long> {
    WorkoutVideo findWorkoutVideoByExerciseIdx(Long exerciseIdx);
}
