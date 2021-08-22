package com.example.homekiri.recommendation.repository.ActivitySpecifics;

import com.example.homekiri.recommendation.model.activity.Info.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findDrinkByCaffeine(String s);
}
