package com.example.homekiri.survey.Service;


import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.survey.Dto.DessertRequestDto;
import com.example.homekiri.survey.Dto.FoodRequestDto;
import com.example.homekiri.survey.Repository.DessertSurveyRepository;
import com.example.homekiri.survey.Repository.FoodSurveyRepository;
import com.example.homekiri.survey.model.DessertSurvey;
import com.example.homekiri.survey.model.FoodSurvey;
import com.example.homekiri.user.UserRepository;
import com.example.homekiri.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DessertSurveyService {
    private final DessertSurveyRepository dessertSurveyRepository;
    private final UserRepository userRepository;

    public Long updateDessertSurvey(DessertRequestDto dessertRequestDto, Long userIdx) throws BaseException {
        User user = userRepository.findById(userIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));
        // 유저가 성향조사 이미 한경우
        //***//
        DessertSurvey dessertSurvey = new DessertSurvey(dessertRequestDto);
        dessertSurvey.setUser(user);
        return dessertSurveyRepository.save(dessertSurvey).getIdx();
    }
}
