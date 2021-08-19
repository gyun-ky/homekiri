package com.example.homekiri.recommendation.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.recommendation.Dto.activity.FoodActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.MediaActivityResponseDto;
import com.example.homekiri.recommendation.model.activity.FoodActivity;
import com.example.homekiri.recommendation.model.activity.MediaActivity;
import com.example.homekiri.recommendation.repository.FoodRecommendListRepository;
import com.example.homekiri.recommendation.repository.MediaRecommendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MediaActivityDetailsService {
    private final MediaRecommendListRepository mediaRecommendListRepository;

    @Transactional(readOnly = true)
    public MediaActivityResponseDto findById(Long idx) throws BaseException {
        MediaActivity res = mediaRecommendListRepository.findById(idx).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
        return new MediaActivityResponseDto(res);
    }
}
