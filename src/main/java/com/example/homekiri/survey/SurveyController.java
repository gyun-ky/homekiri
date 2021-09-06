package com.example.homekiri.survey;


import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.survey.Dto.*;
import com.example.homekiri.survey.Service.DessertSurveyService;
import com.example.homekiri.survey.Service.ExerciseSurveyService;
import com.example.homekiri.survey.Service.FoodSurveyService;
import com.example.homekiri.survey.Service.MediaSurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/survey")
public class SurveyController {

    private final FoodSurveyService foodsurveyService;
    private final DessertSurveyService dessertSurveyService;
    private final MediaSurveyService mediaSurveyService;
    private final ExerciseSurveyService exerciseSurveyService;

    @PostMapping("/{userIdx}/food")
    public BaseResponse<FoodResponseDto> saveFoodSurveyResult(@RequestBody FoodRequestDto foodRequestDto, @PathVariable Long userIdx) {
        try {
            Long result = foodsurveyService.updateFoodSurvey(foodRequestDto, userIdx);
            return new BaseResponse(result);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @PostMapping("/{userIdx}/dessert")
    public BaseResponse<DessertResponseDto> saveDessertResult(@RequestBody DessertRequestDto dessertRequestDto, @PathVariable Long userIdx) {
        try {
            Long result = dessertSurveyService.updateDessertSurvey(dessertRequestDto, userIdx);
            return new BaseResponse(result);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @PostMapping("/{userIdx}/media")
    public BaseResponse<MediaResponseDto> saveMediaResult(@RequestBody MediaRequestDto mediaRequestDto, @PathVariable Long userIdx) {
        try {
            Long result = mediaSurveyService.updateMediaSurvey(mediaRequestDto, userIdx);
            return new BaseResponse(result);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    @PostMapping("/{userIdx}/exercise")
    public BaseResponse<ExerciseResponseDto> saveExerciseResult(@RequestBody ExerciseRequestDto exerciseRequestDto, @PathVariable Long userIdx) {
        try {
            Long result = exerciseSurveyService.updateExerciseSurvey(exerciseRequestDto, userIdx);
            return new BaseResponse(result);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}
