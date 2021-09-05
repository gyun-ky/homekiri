package com.example.homekiri.recommendation.repository.preference;

import com.example.homekiri.preferences.DessertPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DessertPreferenceRepository extends JpaRepository<DessertPreference, Long> {
}
