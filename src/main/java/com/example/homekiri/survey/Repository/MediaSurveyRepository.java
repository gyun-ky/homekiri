package com.example.homekiri.survey.Repository;

import com.example.homekiri.survey.model.FoodSurvey;
import com.example.homekiri.survey.model.MediaSurvey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaSurveyRepository extends JpaRepository<MediaSurvey, Long> {
}
