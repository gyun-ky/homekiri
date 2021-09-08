package com.example.homekiri.survey.Repository;

import com.example.homekiri.survey.model.ExerciseSurvey;
import com.example.homekiri.survey.model.FoodSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseSurveyRepository extends JpaRepository<ExerciseSurvey, Long> {
}
