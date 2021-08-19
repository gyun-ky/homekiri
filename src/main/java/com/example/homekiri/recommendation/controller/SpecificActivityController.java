package com.example.homekiri.recommendation.controller;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.recommendation.Dto.activity.DessertActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.FoodActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.MediaActivityResponseDto;
import com.example.homekiri.recommendation.Dto.activity.WorkoutActivityResponseDto;
import com.example.homekiri.recommendation.service.DessertActivityDetailsService;
import com.example.homekiri.recommendation.service.FoodActivityDetailsService;
import com.example.homekiri.recommendation.service.MediaActivityDetailsService;
import com.example.homekiri.recommendation.service.WorkoutActivityDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/recommendation")
public class SpecificActivityController {
    private final DessertActivityDetailsService dessertActivityDetailsService;
    private final FoodActivityDetailsService foodActivityDetailsService;
    private final MediaActivityDetailsService mediaActivityDetailsService;
    private final WorkoutActivityDetailsService workoutActivityDetailsService;

    /**
     * 디저트 상세 설명 API
     * [GET] /web/dessert/{idx}
     * @param Long
     * @return BaseResponse<DessertActivityResponseDto>
     * if (Activity Index not exist) Throw INVALID_ACTIVITY_IDX
     */
    @ResponseBody
    @GetMapping("/dessert/{idx}")
    public BaseResponse<DessertActivityResponseDto> returnDessertActivity(@PathVariable Long idx){
        try{
            System.out.println(idx);
            DessertActivityResponseDto result = dessertActivityDetailsService.findById(idx);
            System.out.println(result);
            return new BaseResponse<>(result);
        }
        catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    /**
     * 음식 상세 설명 API
     * [GET] /web/food/{idx}
     * @param Long
     * @return BaseResponse<FoodActivityResponseDto>
     * if (Activity Index not exist) Throw INVALID_ACTIVITY_IDX
     */
    @ResponseBody
    @GetMapping("/food/{idx}")
    public BaseResponse<FoodActivityResponseDto> returnFoodActivity(@PathVariable Long idx){
        try{
            FoodActivityResponseDto result = foodActivityDetailsService.findById(idx);
            return new BaseResponse<>(result);
        } catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    /**
     * 미디어 상세 설명 API
     * [GET] /web/media/{idx}
     * @param Long
     * @return BaseResponse<MediaActivityResponseDto>
     * if (Activity Index not exist) Throw INVALID_ACTIVITY_IDX
     */
    @ResponseBody
    @GetMapping("/media/{idx}")
    public BaseResponse<MediaActivityResponseDto> returnMediaActivity(@PathVariable Long idx){
        try{
            MediaActivityResponseDto result = mediaActivityDetailsService.findById(idx);
            return new BaseResponse<>(result);
        } catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

    /**
     * 운동 상세 설명 API
     * [GET] /web/workout/{idx}
     * @param Long
     * @return BaseResponse<WorkoutActivityResponseDto>
     * if (Activity Index not exist) Throw INVALID_ACTIVITY_IDX
     */
    @ResponseBody
    @GetMapping("/workout/{idx}")
    public BaseResponse<WorkoutActivityResponseDto> returnWorkoutActivity(@PathVariable Long idx){
        try{
            WorkoutActivityResponseDto result = workoutActivityDetailsService.findById(idx);
            return new BaseResponse<>(result);
        } catch (BaseException e){
            return new BaseResponse<>(e.getStatus());
        }
    }

}
