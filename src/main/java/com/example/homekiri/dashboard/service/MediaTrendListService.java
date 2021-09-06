package com.example.homekiri.dashboard.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.dashboard.Dto.MediaTrendListResponseDto;
import com.example.homekiri.dashboard.repository.MediaTrendListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


/*
 * 미디어 트렌드 Service
 * @param Null
 * @return List<MediaTrendListResponseDto>
 */
@RequiredArgsConstructor
@Service
public class MediaTrendListService {
    private final MediaTrendListRepository mediaTrendListRepository;

    @Transactional(readOnly = true)
    public List<MediaTrendListResponseDto> returnMediaTrend() throws BaseException{

        if(mediaTrendListRepository.findAll().isEmpty())
            throw new BaseException(BaseResponseStatus.NO_TREND_LIST_ERROR);

        return mediaTrendListRepository.findAll().stream()
                .map(MediaTrendListResponseDto::new)
                .collect(Collectors.toList());
    }
}
