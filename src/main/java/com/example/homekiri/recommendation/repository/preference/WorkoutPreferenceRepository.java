package com.example.homekiri.recommendation.repository.preference;

import com.example.homekiri.recommendation.model.preferences.WorkoutPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutPreferenceRepository extends JpaRepository<WorkoutPreference, Long> {
}
