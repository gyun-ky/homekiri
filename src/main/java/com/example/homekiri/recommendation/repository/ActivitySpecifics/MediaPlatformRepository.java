package com.example.homekiri.recommendation.repository.ActivitySpecifics;

import com.example.homekiri.recommendation.model.activity.Info.MediaPlatform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaPlatformRepository extends JpaRepository<MediaPlatform, Long> {
    MediaPlatform findMediaPlatformByMediaIdx(Long mediaIdx);
}
