package com.example.homekiri.dashboard.controller;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.dashboard.Dto.DessertTrendListResponseDto;
import com.example.homekiri.dashboard.Dto.FoodTrendListResponseDto;
import com.example.homekiri.dashboard.Dto.MediaTrendListResponseDto;
import com.example.homekiri.dashboard.Dto.WorkoutTrendListResponseDto;
import com.example.homekiri.dashboard.service.DessertTrendListService;
import com.example.homekiri.dashboard.service.FoodTrendListService;
import com.example.homekiri.dashboard.service.MediaTrendListService;
import com.example.homekiri.dashboard.service.WorkoutTrendListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/dashboard")
public class TrendListController {
    private final MediaTrendListService mediaTrendListService;
    private final FoodTrendListService foodTrendListService;
    private final DessertTrendListService dessertTrendListService;
    private final WorkoutTrendListService workoutTrendListService;

    /**
     * 미디어 트렌드 리스트 API
     * [GET] /web/dashboard/media-trend-list
     * @return BaseResponse<List<MediaTrendListResponseDto>>
     * if (MediaTrendList is Null) Throw NO_TREND_LIST_ERROR
     */
    @ResponseBody
    @GetMapping("/media-trend-list")
    public BaseResponse<List<MediaTrendListResponseDto>> returnMediaTrend(){

        try{
            List<MediaTrendListResponseDto> result = mediaTrendListService.returnMediaTrend();
            return new BaseResponse<>(result);
        }
        catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    /**
     * 음식 트렌드 리스트 API
     * [GET] /web/dashboard/food-trend-list
     * @return BaseResponse<List<FoodTrendListResponseDto>>
     * if (FoodTrendList is Null) Throw NO_TREND_LIST_ERROR
     */
    @ResponseBody
    @GetMapping("/food-trend-list")
    public BaseResponse<List<FoodTrendListResponseDto>> returnFoodTrend(){

        try{
            List<FoodTrendListResponseDto> result = foodTrendListService.returnFoodTrend();
            return new BaseResponse<>(result);
        }
        catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    /**
     * 디저트 트렌드 리스트 API
     * [GET] /web/dashboard/dessert-trend-list
     * @return BaseResponse<List<DessertTrendListResponseDto>>
     * if (DessertTrendList is Null) Throw NO_TREND_LIST_ERROR
     */
    @ResponseBody
    @GetMapping("/dessert-trend-list")
    public BaseResponse<List<DessertTrendListResponseDto>> returnDessertTrend(){

        try{
            List<DessertTrendListResponseDto> result = dessertTrendListService.returnDessertTrend();
            return new BaseResponse<>(result);
        }
        catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    /**
     * 운동 트렌드 리스트 API
     * [GET] /web/dashboard/workout-trend-list
     * @return BaseResponse<List<WorkoutTrendListResponseDto>>
     * if (WorkoutTrendList is Null) Throw NO_TREND_LIST_ERROR
     */
    @ResponseBody
    @GetMapping("/workout-trend-list")
    public BaseResponse<List<WorkoutTrendListResponseDto>> returnWorkoutTrend(){

        try{
            List<WorkoutTrendListResponseDto> result = workoutTrendListService.returnWorkoutTrend();
            return new BaseResponse<>(result);
        }
        catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }
}
