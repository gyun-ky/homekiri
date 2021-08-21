package com.example.homekiri.recommendation.repository.ActivitySpecifics;

import com.example.homekiri.recommendation.model.activity.Info.WorkoutVideo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutVideoRepository extends JpaRepository<WorkoutVideo, Long> {
    WorkoutVideo findWorkoutVideoByExerciseIdx(Long exerciseIdx);
}
