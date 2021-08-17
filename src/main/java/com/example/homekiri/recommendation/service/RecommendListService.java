package com.example.homekiri.recommendation.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.recommendation.model.activity.DessertActivity;
import com.example.homekiri.recommendation.model.activity.FoodActivity;
import com.example.homekiri.recommendation.model.activity.MediaActivity;
import com.example.homekiri.recommendation.model.activity.WorkoutActivity;
import com.example.homekiri.recommendation.repository.DessertRecommendListRepository;
import com.example.homekiri.recommendation.repository.FoodRecommendListRepository;
import com.example.homekiri.recommendation.repository.MediaRecommendListRepository;
import com.example.homekiri.recommendation.repository.WorkoutRecommendListRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RecommendListService {
    private final DessertRecommendListRepository dessertRecommendListRepository;
    private final FoodRecommendListRepository foodRecommendListRepository;
    private final MediaRecommendListRepository mediaRecommendListRepository;
    private final WorkoutRecommendListRepository workoutRecommendListRepository;



    @Transactional
    public HashMap<String, Object> recommend(Long UserIdx) throws BaseException {
        List<MediaActivity> mediaActivities = mediaRecommendListRepository.findAll();
        List<FoodActivity> foodActivities = foodRecommendListRepository.findAll();
        List<DessertActivity> dessertActivities = dessertRecommendListRepository.findAll();
        List<WorkoutActivity> workoutActivities = workoutRecommendListRepository.findAll();

        if(foodRecommendListRepository.findAll().isEmpty())
            throw new BaseException(BaseResponseStatus.NO_TREND_LIST_ERROR);

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("media", mediaActivities);
        map.put("food", foodActivities);
        map.put("dessert", dessertActivities);
        map.put("workout", workoutActivities);

        return map;
    }
}
