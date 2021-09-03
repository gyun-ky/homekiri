package com.example.homekiri.recommendation.repository.preference;

import com.example.homekiri.model.preferences.MediaPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaPreferenceRepository extends JpaRepository<MediaPreference, Long> {
}
