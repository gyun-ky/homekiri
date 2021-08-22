package com.example.homekiri.recommendation.repository.ActivitySpecifics;

import com.example.homekiri.recommendation.model.activity.Info.DessertImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DessertImageRepository extends JpaRepository<DessertImage, Long> {
    DessertImage findDessertImageByDessertIdx(Long dessertIdx);
}
