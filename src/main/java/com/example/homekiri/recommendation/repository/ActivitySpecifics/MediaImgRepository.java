package com.example.homekiri.recommendation.repository.ActivitySpecifics;

import com.example.homekiri.model.Media.MediaImg;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MediaImgRepository extends JpaRepository<MediaImg, Long> {
    MediaImg findMediaImgByMediaIdx(Long MediaIdx);
}
