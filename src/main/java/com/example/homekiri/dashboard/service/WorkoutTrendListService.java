package com.example.homekiri.dashboard.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.dashboard.Dto.WorkoutTrendListResponseDto;
import com.example.homekiri.dashboard.repository.WorkoutTrendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 운동 트렌드 Service
 * @param Null
 * @return List<WorkoutTrendListResponseDto>
 */
@RequiredArgsConstructor
@Service
public class WorkoutTrendListService {
    private final WorkoutTrendListRepository workoutTrendListRepository;

    @Transactional(readOnly = true)
    public List<WorkoutTrendListResponseDto> returnWorkoutTrend() throws BaseException {

        if(workoutTrendListRepository.findAll().isEmpty())
            throw new BaseException(BaseResponseStatus.NO_TREND_LIST_ERROR);

        return workoutTrendListRepository.findAll().stream()
                .map(WorkoutTrendListResponseDto::new)
                .collect(Collectors.toList()) ;
    }
}
