package com.example.homekiri.recommendation.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.recommendation.Dto.activity.MediaActivityResponseDto;
import com.example.homekiri.recommendation.model.activity.MediaActivity;
import com.example.homekiri.recommendation.model.activity.Info.MediaImg;
import com.example.homekiri.recommendation.repository.ActivitySpecifics.MediaImgRepository;
import com.example.homekiri.recommendation.repository.MediaRecommendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MediaActivityDetailsService {
    private final MediaRecommendListRepository mediaRecommendListRepository;
    private final MediaImgRepository mediaImgRepository;

    @Transactional(readOnly = true)
    public MediaActivityResponseDto findById(Long idx) throws BaseException {
        if(idx == -1)
            throw new BaseException(BaseResponseStatus.MEDIA_DATA_LACK_ERROR);
        MediaActivity res1 = mediaRecommendListRepository.findById(idx).orElseThrow(()->new BaseException(BaseResponseStatus.ACTIVITY_IDX_ERROR));
        MediaImg res2 = mediaImgRepository.findMediaImgByMediaIdx(idx);
        return new MediaActivityResponseDto(res1, res2);
    }
}
