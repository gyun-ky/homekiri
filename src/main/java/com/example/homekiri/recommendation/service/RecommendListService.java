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
import com.example.homekiri.recommendation.model.preferences.DessertPreference;
import com.example.homekiri.recommendation.model.preferences.FoodPreference;
import com.example.homekiri.recommendation.model.preferences.MediaPreference;
import com.example.homekiri.recommendation.model.preferences.WorkoutPreference;
import com.example.homekiri.recommendation.repository.DessertRecommendListRepository;
import com.example.homekiri.recommendation.repository.FoodRecommendListRepository;
import com.example.homekiri.recommendation.repository.MediaRecommendListRepository;
import com.example.homekiri.recommendation.repository.WorkoutRecommendListRepository;

import com.example.homekiri.recommendation.repository.preference.DessertPreferenceRepository;
import com.example.homekiri.recommendation.repository.preference.FoodPreferenceRepository;
import com.example.homekiri.recommendation.repository.preference.MediaPreferenceRepository;
import com.example.homekiri.recommendation.repository.preference.WorkoutPreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecommendListService {

    private final DessertPreferenceRepository dessertPreferenceRepository;
    private final FoodPreferenceRepository foodPreferenceRepository;
    private final MediaPreferenceRepository mediaPreferenceRepository;
    private final WorkoutPreferenceRepository workoutPreferenceRepository;

    private final DessertRecommendListRepository dessertRecommendListRepository;
    private final FoodRecommendListRepository foodRecommendListRepository;
    private final MediaRecommendListRepository mediaRecommendListRepository;
    private final WorkoutRecommendListRepository workoutRecommendListRepository;


    @Transactional
    public HashMap<String, Object> recommend(Long UserIdx) throws BaseException {
        //UserIdx Preference
        DessertPreference dessertPreference = dessertPreferenceRepository.findById(UserIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));
        FoodPreference foodPreference = foodPreferenceRepository.findById(UserIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));
        MediaPreference mediaPreference = mediaPreferenceRepository.findById(UserIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));
        WorkoutPreference workoutPreference = workoutPreferenceRepository.findById(UserIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));


        List<MediaActivityResponseDto> mediaActivities = new ArrayList<>();
        List<FoodActivityResponseDto> foodActivities = new ArrayList<>();
        List<DessertActivityResponseDto> dessertActivities = new ArrayList<>();
        List<WorkoutActivityResponseDto> workoutActivities = new ArrayList<>();

        /**
         * 추천 시스템...
         */

        if(mediaActivities.isEmpty() || foodActivities.isEmpty() || dessertActivities.isEmpty() || workoutActivities.isEmpty())
            throw new BaseException(BaseResponseStatus.PREFERENCE_LACK_ERROR);


        Collections.shuffle(mediaActivities);
        Collections.shuffle(foodActivities);
        Collections.shuffle(dessertActivities);
        Collections.shuffle(workoutActivities);

        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("media", mediaActivities);
        map.put("food", foodActivities);
        map.put("dessert", dessertActivities);
        map.put("workout", workoutActivities);
        return map;
    }
}
