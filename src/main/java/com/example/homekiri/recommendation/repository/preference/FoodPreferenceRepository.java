package com.example.homekiri.recommendation.repository.preference;

import com.example.homekiri.recommendation.model.preferences.FoodPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodPreferenceRepository extends JpaRepository<FoodPreference, Long> {
}
