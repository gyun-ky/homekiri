package com.example.homekiri.dashboard.service;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.dashboard.Dto.DessertTrendListResponseDto;
import com.example.homekiri.dashboard.repository.DessertTrendListRepository;
import com.example.homekiri.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 디저트 트렌드 Service
 * @param Null
 * @return List<DessertTrendListResponseDto>
 */
@RequiredArgsConstructor
@Service
public class DessertTrendListService {
    private final DessertTrendListRepository dessertTrendListRepository;

    @Transactional(readOnly = true)
    public List<DessertTrendListResponseDto> returnDessertTrend()  throws BaseException {

        if(dessertTrendListRepository.findAll().isEmpty())
            throw new BaseException(BaseResponseStatus.NO_TREND_LIST_ERROR);

        return dessertTrendListRepository.findAll().stream()
                .map(DessertTrendListResponseDto::new)
                .collect(Collectors.toList());
    }

}
