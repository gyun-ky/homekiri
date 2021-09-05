package com.example.homekiri.recommendation.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.recommendation.Dto.activity.FoodActivityResponseDto;
import com.example.homekiri.food.model.FoodActivity;
import com.example.homekiri.recommendation.repository.FoodRecommendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FoodActivityDetailsService {
    private final FoodRecommendListRepository foodRecommendListRepository;

    @Transactional(readOnly = true)
    public FoodActivityResponseDto findById(Long idx) throws BaseException {
        FoodActivity res = foodRecommendListRepository.findById(idx).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
        return new FoodActivityResponseDto(res);
    }
}
