package com.example.homekiri.recommendation.repository;

import com.example.homekiri.recommendation.Dto.activity.MediaActivityResponseDto;
import com.example.homekiri.recommendation.model.activity.MediaActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MediaRecommendListRepository extends JpaRepository<MediaActivity, Long> {
    List<MediaActivity> findMediaActivitiesByGenreIdx(Long idx);
    List<MediaActivity> findMediaActivitiesByGenreIdxOrGenreIdx(Long idx1, Long idx2);
}
