package com.example.homekiri.recommendation.repository.ActivitySpecifics;

import com.example.homekiri.model.Media.MediaPlatform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaPlatformRepository extends JpaRepository<MediaPlatform, Long> {
    MediaPlatform findMediaPlatformByMediaIdx(Long mediaIdx);
}
