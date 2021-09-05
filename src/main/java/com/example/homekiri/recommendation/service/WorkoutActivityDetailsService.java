package com.example.homekiri.recommendation.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.recommendation.Dto.activity.WorkoutActivityResponseDto;
import com.example.homekiri.exercise.model.WorkoutActivity;
import com.example.homekiri.recommendation.repository.WorkoutRecommendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WorkoutActivityDetailsService {
    private final WorkoutRecommendListRepository workoutRecommendListRepository;


    @Transactional(readOnly = true)
    public WorkoutActivityResponseDto findById(Long idx) throws BaseException{
        WorkoutActivity res = workoutRecommendListRepository.findById(idx).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
        return new WorkoutActivityResponseDto(res);
    }
}

