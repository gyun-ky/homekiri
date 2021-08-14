package com.example.homekiri.recommendation.repository;

import com.example.homekiri.dashboard.model.DessertTrend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRecommendListRepository extends JpaRepository<DessertTrend, Long> {
}
