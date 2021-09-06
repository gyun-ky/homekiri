package com.example.homekiri.survey.Service;


import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.survey.Dto.FoodRequestDto;
import com.example.homekiri.survey.Dto.MediaRequestDto;
import com.example.homekiri.survey.Repository.MediaSurveyRepository;
import com.example.homekiri.survey.model.MediaSurvey;
import com.example.homekiri.user.UserRepository;
import com.example.homekiri.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MediaSurveyService {
    public final MediaSurveyRepository mediaSurveyRepository;
    public final UserRepository userRepository;

    public Long updateMediaSurvey(MediaRequestDto mediaRequestDto, Long userIdx) throws BaseException{
        User user = userRepository.findById(userIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));

        MediaSurvey mediaSurvey = new MediaSurvey(mediaRequestDto);
        mediaSurvey.setUser(user);
        return mediaSurveyRepository.save(mediaSurvey).getIdx();
    }
}
