package com.example.homekiri.recommendation.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.recommendation.Dto.activity.MediaActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.WorkoutActivityResponseDto;
import com.example.homekiri.recommendation.model.activity.Info.WorkoutImg;
import com.example.homekiri.recommendation.model.activity.Info.WorkoutVideo;
import com.example.homekiri.recommendation.model.activity.MediaActivity;
import com.example.homekiri.recommendation.model.activity.WorkoutActivity;
import com.example.homekiri.recommendation.repository.ActivitySpecifics.WorkoutImgRepository;
import com.example.homekiri.recommendation.repository.ActivitySpecifics.WorkoutVideoRepository;
import com.example.homekiri.recommendation.repository.MediaRecommendListRepository;
import com.example.homekiri.recommendation.repository.WorkoutRecommendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WorkoutActivityDetailsService {
    private final WorkoutRecommendListRepository workoutRecommendListRepository;
    private final WorkoutImgRepository workoutImgRepository;
    private final WorkoutVideoRepository workoutVideoRepository;

    @Transactional(readOnly = true)
    public WorkoutActivityResponseDto findById(Long idx) throws BaseException{
        WorkoutActivity res = workoutRecommendListRepository.findById(idx).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
        WorkoutImg res2 = workoutImgRepository.findWorkoutImgByExerciseIdx(idx);
        WorkoutVideo res3 = workoutVideoRepository.findWorkoutVideoByExerciseIdx(idx);
        return new WorkoutActivityResponseDto(res, res2, res3);
    }
}

