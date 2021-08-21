package com.example.homekiri.recommendation.repository.ActivitySpecifics;

import com.example.homekiri.recommendation.model.activity.Info.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
}
