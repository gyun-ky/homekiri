package com.example.homekiri.recommendation.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.recommendation.Dto.activity.DessertActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.MediaActivityResponseDto;
import com.example.homekiri.recommendation.model.activity.DessertActivity;
import com.example.homekiri.recommendation.repository.DessertRecommendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DessertRecommendListService {
    private final DessertRecommendListRepository dessertRecommendListRepository;

    @Transactional(readOnly = true)
    public DessertActivityResponseDto findById(Long idx) throws BaseException {
        DessertActivity res = dessertRecommendListRepository.findById(idx).orElseThrow(()-> new BaseException(BaseResponseStatus.NO_TREND_LIST_ERROR));
        return new DessertActivityResponseDto(res);
    }
}