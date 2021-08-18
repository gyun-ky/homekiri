package com.example.homekiri.recommendation.repository;

import com.example.homekiri.recommendation.Dto.activity.MediaActivityResponseDto;
import com.example.homekiri.recommendation.model.activity.MediaActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRecommendListRepository extends JpaRepository<MediaActivity, Long> {
}
