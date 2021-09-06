package com.example.homekiri.survey.Service;


import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponseStatus;
import com.example.homekiri.survey.Dto.ExerciseRequestDto;
import com.example.homekiri.survey.Dto.FoodRequestDto;
import com.example.homekiri.survey.Repository.ExerciseSurveyRepository;
import com.example.homekiri.survey.model.ExerciseSurvey;
import com.example.homekiri.user.UserRepository;
import com.example.homekiri.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExerciseSurveyService {
    public final ExerciseSurveyRepository exerciseSurveyRepository;
    public final UserRepository userRepository;

    public Long updateExerciseSurvey(ExerciseRequestDto exerciseRequestDto, Long userIdx) throws BaseException{
        User user = userRepository.findById(userIdx).orElseThrow(()->new BaseException(BaseResponseStatus.INVALID_USER_IDX));

        ExerciseSurvey exerciseSurvey = new ExerciseSurvey(exerciseRequestDto);
        exerciseSurvey.setUser(user);
        return exerciseSurveyRepository.save(exerciseSurvey).getIdx();
    }
}
