package com.example.homekiri.food.controller;

import com.example.homekiri.config.BaseException;
import com.example.homekiri.config.BaseResponse;
import com.example.homekiri.food.Dto.FoodActivityResponseDto;
import com.example.homekiri.food.service.FoodActivityDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/web/details")
public class FoodSpecificActivityController {

    private final FoodActivityDetailsService foodActivityDetailsService;

    /*
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
}
