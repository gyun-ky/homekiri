package com.example.homekiri.recommendation.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.dashboard.Dto.DessertTrendListResponseDto;
import com.example.homekiri.dashboard.Dto.MediaTrendListResponseDto;
import com.example.homekiri.recommendation.Dto.activity.DessertActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.FoodActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.MediaActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.WorkoutActivityResponseDto;
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
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecommendListService {
    private final DessertRecommendListRepository dessertRecommendListRepository;
    private final FoodRecommendListRepository foodRecommendListRepository;
    private final MediaRecommendListRepository mediaRecommendListRepository;
    private final WorkoutRecommendListRepository workoutRecommendListRepository;



    @Transactional
    public HashMap<String, Object> recommend(Long UserIdx) throws BaseException {
        List<MediaActivityResponseDto> mediaActivities = mediaRecommendListRepository.findAll().stream()
                .map(MediaActivityResponseDto::new)
                .collect(Collectors.toList());

        List<FoodActivityResponseDto> foodActivities = foodRecommendListRepository.findAll().stream()
                .map(FoodActivityResponseDto::new)
                .collect(Collectors.toList());

        List<DessertActivityResponseDto> dessertActivities = dessertRecommendListRepository.findAll().stream()
                .map(DessertActivityResponseDto::new)
                .collect(Collectors.toList());

        List<WorkoutActivityResponseDto> workoutActivities = workoutRecommendListRepository.findAll().stream()
                .map(WorkoutActivityResponseDto::new)
                .collect(Collectors.toList());

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
