package com.example.homekiri.survey.Repository;

import com.example.homekiri.survey.model.FoodSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FoodSurveyRepository extends JpaRepository<FoodSurvey, Long> {
}
