package com.example.homekiri.media.repository;

import com.example.homekiri.media.model.MediaImg;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MediaImgRepository extends JpaRepository<MediaImg, Long> {
    MediaImg findMediaImgByMediaIdx(Long MediaIdx);
}
