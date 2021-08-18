package com.example.homekiri.recommendation.controller;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.dashboard.Dto.MediaTrendListResponseDto;
import com.example.homekiri.recommendation.Dto.activity.DessertActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.FoodActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.MediaActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.WorkoutActivityResponseDto;
import com.example.homekiri.recommendation.repository.DessertRecommendListRepository;
import com.example.homekiri.recommendation.repository.FoodRecommendListRepository;
import com.example.homekiri.recommendation.service.DessertRecommendListService;
import com.example.homekiri.recommendation.service.FoodRecommendListService;
import com.example.homekiri.recommendation.service.MediaRecommendListService;
import com.example.homekiri.recommendation.service.WorkoutRecommendListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/recommendation")
public class SpecificActivityController {
    private final DessertRecommendListService dessertRecommendListService;
    private final FoodRecommendListService foodRecommendListService;
    private final MediaRecommendListService mediaRecommendListService;
    private final WorkoutRecommendListService workoutRecommendListService;

    @ResponseBody
    @GetMapping("/dessert/{idx}")
    public BaseResponse<DessertActivityResponseDto> returnDessertActivity(@PathVariable Long idx){
        try{
            DessertActivityResponseDto result = dessertRecommendListService.findById(idx);
            return new BaseResponse<>(result);
        }
        catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/food/{idx}")
    public BaseResponse<FoodActivityResponseDto> returnFoodActivity(@PathVariable Long idx){
        try{
            FoodActivityResponseDto result = foodRecommendListService.findById(idx);
            return new BaseResponse<>(result);
        } catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/media/{idx}")
    public BaseResponse<MediaActivityResponseDto> returnMediaActivity(@PathVariable Long idx){
        try{
            MediaActivityResponseDto result = mediaRecommendListService.findById(idx);
            return new BaseResponse<>(result);
        } catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    @ResponseBody
    @GetMapping("/workout/{idx}")
    public BaseResponse<WorkoutActivityResponseDto> returnWorkoutActivity(@PathVariable Long idx){
        try{
            WorkoutActivityResponseDto result = workoutRecommendListService.findById(idx);
            return new BaseResponse<>(result);
        } catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

}
