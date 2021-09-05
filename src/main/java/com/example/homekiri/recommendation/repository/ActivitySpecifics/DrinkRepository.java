package com.example.homekiri.recommendation.repository.ActivitySpecifics;

import com.example.homekiri.dessert.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrinkRepository extends JpaRepository<Drink, Long> {
    List<Drink> findDrinksByCaffeine(String s);
    List<Drink> findDrinksByFlavor(String s);
    List<Drink> findDrinksByTemperatureContains(String s);
    List<Drink> findDrinksByDrinkNameContains(String s);
    List<Drink> findDrinksByDrinkNameContainsOrDrinkNameContains(String s1, String s2);
}
