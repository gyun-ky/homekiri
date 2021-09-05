package com.example.homekiri.exercise.controller;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.exercise.Dto.WorkoutActivityResponseDto;
import com.example.homekiri.exercise.service.WorkoutActivityDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/details")
public class WorkoutSpecificActivityController {


    private final WorkoutActivityDetailsService workoutActivityDetailsService;

    /*
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
