package com.example.homekiri.dashboard.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.dashboard.Dto.FoodTrendListResponseDto;
import com.example.homekiri.dashboard.repository.FoodTrendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/*
 * 음식 트렌드 Service
 * @param Null
 * @return List<FoodTrendListResponseDto>
 */
@RequiredArgsConstructor
@Service
public class FoodTrendListService {
    private final FoodTrendListRepository foodTrendListRepository;

    @Transactional(readOnly = true)
    public List<FoodTrendListResponseDto> returnFoodTrend() throws BaseException {

        if(foodTrendListRepository.findAll().isEmpty())
            throw new BaseException(BaseResponseStatus.NO_TREND_LIST_ERROR);

        return foodTrendListRepository.findAll().stream()
                .map(FoodTrendListResponseDto::new)
                .collect(Collectors.toList());
    }
}
